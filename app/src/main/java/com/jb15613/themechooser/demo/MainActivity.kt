package com.jb15613.themechooser.demo

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jb15613.themechooser.adapter.NavigationAdapter
import com.jb15613.themechooser.model.NavObject
import com.jb15613.themechooser.mtcpref.Theme
import com.jb15613.themechooser.mtcpref.ThemeChooser
import com.jb15613.themechooser.mtcpref.Themes
import com.jb15613.themechooser.utility.*
import android.view.Menu
import android.view.MenuItem
import com.jb15613.themechooser.startup.ThemeChooserInitializer


class MainActivity : AppCompatActivity() {

    private var mVersion = ""
    private var mBuildTime: String? = null
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: NavigationAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    lateinit var mArray: ArrayList<NavObject>
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isAutomaticInitializationDone()) {
            Log.e("isAutoInitDone", "true")
            setTheme(ThemeChooser.getTheme())
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

        val actionBar: ActionBar? = supportActionBar

        actionBar?.setHomeAsUpIndicator(R.mipmap.ic_menu_white)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        mFragmentManager = supportFragmentManager

        try {
            val color: String = ColorUtils().getColorAsHtmlString(ThemeChooserUtils.getThemeColor(this))
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

    } // onCreate

    private fun isAutomaticInitializationDone(): Boolean {
        return ThemeChooser.isInitialized
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    } // onCreateOptionsMenu

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
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

    override fun onBackPressed() {
        // super.onBackPressed();
        val fm2 = supportFragmentManager
        val ft2 = fm2.beginTransaction()
        val frag: SettingsFragment? = supportFragmentManager.findFragmentByTag("prefsFrag") as SettingsFragment?

        if (frag != null) {
            if (frag.isAdded && frag.isVisible) {
                ft2.remove(frag)
                ft2.commit()
                recreate()
            }
        }
    } // onBackPressed

}