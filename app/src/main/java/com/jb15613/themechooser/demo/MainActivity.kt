package com.jb15613.themechooser.demo

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jb15613.themechooser.adapter.NavigationAdapter
import com.jb15613.themechooser.model.NavObject
import com.jb15613.themechooser.mtcpref.ThemeChooser
import com.jb15613.themechooser.utility.*
import com.jb15613.themechooser.utility.FragmentSwapperUtilities.getCurrentNav
import com.jb15613.themechooser.utility.FragmentSwapperUtilities.setCurrentNav
import com.jb15613.themechooser.utility.color.AccentColor


class MainActivity : AppCompatActivity() {

    private var mVersion = ""
    private var mBuildTime: String? = null
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: NavigationAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var mArray: ArrayList<NavObject>
    private lateinit var mFragmentManager: FragmentManager
    private lateinit var mCoordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isAutomaticInitializationDone()) {
            Log.e("isAutoInitDone", "true")
            setTheme(ThemeChooser.getTheme())
            // setTheme(ThemeChooser.getTheme("Deep Orange & Blue Grey - Dark"))


            /*
            // Using the Builder
            setTheme(
                Theme.ThemeBuilder()
                    .themeColor(Themes.ThemeColor.randomThemeColor)
                    .accentColor(Themes.AccentColor.randomAccentColor)
                    .isLightTheme(Themes.randomThemeHue)
                    .build()
                    .theme) */

        } else {
            Log.e("isAutoInitDone", "false")
        }

        /*
        // Using the Preference
        setTheme(ThemeChooser.getTheme(this))
         */

        /*
        // Using Strings
        setTheme(ThemeChooser.getTheme("Deep Purple"))
        // setTheme(ThemeChooser.getTheme("Deep Purple - Dark"))
        // setTheme(ThemeChooser.getTheme("Deep Purple - Light"))
        // setTheme(ThemeChooser.getTheme("Deep Purple & Pink"))
        // setTheme(ThemeChooser.getTheme("Deep Purple & Pink - Light"))
        // setTheme(ThemeChooser.getTheme("Purple & Deep Orange - Dark"))
         */

        /*
        // Using the Builder
        setTheme(
            Theme.ThemeBuilder()
                .themeColor(Themes.ThemeColor.randomThemeColor)
                .accentColor(Themes.AccentColor.randomAccentColor)
                .isLightTheme(Themes.randomThemeHue)
                .build(this)
                .theme
        )
         */

        setContentView(R.layout.activity_main)

        val dispatcher = onBackPressedDispatcher

        val onBackPressedCallback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                val settingsFragment = supportFragmentManager.findFragmentByTag("prefsFrag")
                if (settingsFragment != null && settingsFragment.isAdded && settingsFragment.isVisible) {
                    supportFragmentManager.beginTransaction().remove(settingsFragment).commit()
                    recreate()
                } else if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    isEnabled = false // Disable this callback
                    onBackPressedDispatcher.onBackPressed() // Trigger default behavior or next callback
                    isEnabled = true // Re-enable if you want it to be active for future presses
                }
            }
        }
        dispatcher.addCallback(this, onBackPressedCallback)

        val actionBar: ActionBar? = supportActionBar

        actionBar?.setHomeAsUpIndicator(R.mipmap.ic_menu_white)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        mFragmentManager = supportFragmentManager
        mCoordinatorLayout = findViewById(R.id.coordinator)

        try {
            val color: String = ThemeChooserUtils.getColorAsHtmlString(ThemeChooserUtils.getThemeColor())
            var v = ""
            mVersion = "v" + packageManager.getPackageInfo(PACKAGE, 0).versionName
            if (isDebugMode()) {
                mVersion += " Debug"
            }
            v += "<font color='$color'> $mVersion</font>"
            mVersion = v
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mBuildTime = getAppTimeStamp(this)

        mDrawerLayout = findViewById(R.id.drawer_layout)
        mRecyclerView = findViewById(R.id.RecyclerView)
        mRecyclerView.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager
        mAdapter = setupAdapter(this)
        mRecyclerView.adapter = mAdapter

        swapActivityFragment(getNav())
    } // onCreate

    private fun isAutomaticInitializationDone(): Boolean {
        return PrefUtils.isInitialized &&
                ColorUtils.isInitialized &&
                AccentColor.isInitialized &&
                ThemeChooserUtils.isInitialized
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    } // onCreateOptionsMenu

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> mDrawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    private fun setupAdapter(context: Context): NavigationAdapter {
        mArray = getNavItems(context)
        val navTitles = arrayOfNulls<String>(mArray.size)
        val navIcons = arrayOfNulls<Drawable>(mArray.size)

        for (i in mArray.indices) {
            val no = mArray[i]
            navTitles[i] = no.title
            navIcons[i] = no.icon
        }

        mAdapter = NavigationAdapter(navTitles, navIcons, context)
        return mAdapter
    } // setupAdapter

    private fun getNavItems(c: Context): ArrayList<NavObject> {
        val array: ArrayList<NavObject> = ArrayList()
        array.add(NavObject(NAV_ITEM_HEADER, null, 0))
        array.add(NavObject(NAV_ITEM_NAV, null, 0))
        array.add(NavObject(NAV_ITEM_HOME, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_home, null), 2))
        array.add(NavObject(NAV_ITEM_TEXT_VIEWS, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_text_views, null), 2))
        array.add(NavObject(NAV_ITEM_BUTTON_VIEWS, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_button_views, null), 2))
        array.add(NavObject(NAV_ITEM_WIDGET_VIEWS, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_widget_views, null), 2))
        array.add(NavObject(NAV_ITEM_SPARE_PARTS, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_spare_parts, null), 2))
        array.add(NavObject(NAV_ITEM_OPTIONS, null, 0))
        array.add(NavObject(NAV_ITEM_SETTINGS, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_settings, null), 1))
        array.add(NavObject(NAV_ITEM_LOG, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_sendlog, null), 1))
        array.add(NavObject(NAV_ITEM_UPDATE, ResourcesCompat.getDrawable(c.resources, R.mipmap.nav_item_checkforupdates, null), 1))
        array.add(NavObject(mVersion, null, 0))
        array.add(NavObject(mBuildTime, null, 0))
        return array
    } // getNavItems

    fun closeNavDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START)
    } // closeNavDrawer

    fun showSnackBar(message: String) {
        val snackbar = Snackbar
            .make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG)
        val sbView: View = snackbar.view
        sbView.setBackgroundColor(ThemeChooserUtils.getThemeDarkColor())
        snackbar.setTextColor(ThemeChooserUtils.getPrimaryTextColor())
        snackbar.show()
    } // showSnackBar

    fun setNav(value: String) {
        setCurrentNav(this, value)
    }

    fun getNav(): String {
        return getCurrentNav(this)
    }

    fun swapActivityFragment(newFrag: String) {

        setNav(newFrag)

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()

        when (newFrag) {
            NAV_ITEM_HOME -> {
                val frag = HomeFragment()
                ft.replace(R.id.fragment_container, frag)
                ft.commit()
            }
            NAV_ITEM_TEXT_VIEWS -> {
                val frag = TextViewsFragment()
                ft.replace(R.id.fragment_container, frag)
                ft.commit()
            }
            NAV_ITEM_BUTTON_VIEWS -> {
                val frag = ButtonViewsFragment()
                ft.replace(R.id.fragment_container, frag)
                ft.commit()
            }
            NAV_ITEM_WIDGET_VIEWS -> {
                val frag = WidgetViewsFragment()
                ft.replace(R.id.fragment_container, frag)
                ft.commit()
            }
            NAV_ITEM_SPARE_PARTS -> {
                val frag = SparePartsFragment()
                ft.replace(R.id.fragment_container, frag)
                ft.commit()
            }
        }

    }

    fun showSettingsFragment() {
        val mFragmentTransaction: FragmentTransaction = mFragmentManager.beginTransaction()
        val mPrefsFragment = SettingsFragment()
        mFragmentTransaction.replace(android.R.id.content, mPrefsFragment, "prefsFrag")
        mFragmentTransaction.addToBackStack(null)
        mFragmentTransaction.commit()
    } // showSettingsFragment

    fun getStatusBarHeight() : Int {
        var result = 0
        val resourceId: Int =
            this.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = this.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }// getStatusBarHeight

    fun showCardClickDialog(theme: String) {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setCancelable(false)
        builder.setTitle("M.T.C. Pref")
        builder.setMessage("$theme\nWould you like to set this as the App Theme?\n(Requires App Restart)")
        builder.setPositiveButton("Yes"
        ) { dialog, _ ->
            // yes
            val hue = PrefUtils.getThemeHue()
            val suffix = if (hue) {
                " - Day"
            } else {
                " - Night"
            }
            showSnackBar("Setting theme to $theme$suffix")
            swapTheme("$theme$suffix")
            dialog.dismiss()
        }
        builder.setNegativeButton("No"
        ) { dialog, _ ->
            // no
            dialog.dismiss()
        }
        val mDialog: AlertDialog = builder.create()
        mDialog.setOnShowListener {
            mDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ThemeChooserUtils.getThemeAccentColor())
            mDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ThemeChooserUtils.getThemeAccentColor())
        }
        mDialog.show()

    } // showCardClickDialog

    private fun swapTheme(themeName: String) {
        PrefUtils.setThemeName(themeName)
        recreate()
    } // swapTheme

}