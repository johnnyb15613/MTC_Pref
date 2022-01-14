package com.jb15613.themechooser.mtcpref

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.*
import android.widget.CompoundButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import androidx.appcompat.widget.SwitchCompat
import androidx.cardview.widget.CardView
import androidx.fragment.app.DialogFragment
import com.jb15613.themechooser.utility.*
import com.jb15613.themechooser.utility.PrefUtils.getThemeColor
import com.jb15613.themechooser.utility.PrefUtils.getThemeHue
import com.jb15613.themechooser.utility.PrefUtils.setAccentColor
import com.jb15613.themechooser.utility.PrefUtils.setThemeColor
import com.jb15613.themechooser.utility.PrefUtils.setThemeHue

class ThemeChooserDialog : DialogFragment() {

    // Context
    var mContext: Context? = null

    // Dialog
    private var mAlertDialog: AlertDialog? = null

    // Accent Scroll View
    var mAccentParent: HorizontalScrollView? = null

    // Layout to add Accent Items to
    var mAccentContainer: LinearLayout? = null

    // ScrollView to add Portrait
    var mPortraitParent: ScrollView? = null

    // Layout to add Portrait Swatch Items to
    var mPortraitContainer: TableLayout? = null

    // ScrollView to add Landscape
    var mLandscapeParent: HorizontalScrollView? = null

    // Layout to add Landscape Swatch Items to
    var mLandscapeContainer: LinearLayout? = null

    // Switch for Light/Dark
    private var mSwitch: SwitchCompat? = null

    // isLandscape
    private var isPortrait = false

    // Theme Change Listener
    private var mListener: OnThemeChangedListener? = null

    // Preferences
    private var mPrefs: SharedPreferences? = null

    private var mResources: Resources? = null

    // Interface linked to ThemeChooserPreference
    interface OnThemeChangedListener {
        fun onThemeChanged(theme: String?, hue: Boolean)
    } // OnThemeChangedListener

    fun setOnThemeChangedListener(listener: OnThemeChangedListener) {
        mListener = listener
    } // setOnThemeChangedListener


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val d: Dialog = super.onCreateDialog(savedInstanceState)
        setStyle(STYLE_NORMAL, android.R.style.Theme_Dialog)

        val c: Context? = activity
        if (c != null) {
            mContext = c
        }

        mResources = resources
        mPrefs = mContext!!.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)

        isPortrait = when (mResources?.configuration?.orientation) {
            1 -> true
            else -> false
        }

        return d
        // init
    } // onCreateDialog

    @SuppressLint("InflateParams")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LayoutInflater.from(activity).inflate(R.layout.themechooser_dialog, null)

        if (PrefUtils.getCellSize(mContext!!) == 0 ) {
            val width = this.resources.displayMetrics.widthPixels
            val cellDimen = width / 6
            PrefUtils.setCellSize(mContext!!, cellDimen)
        }

        // get views
        // get views
        mAccentParent = view.findViewById(R.id.tcd_accentParent) as HorizontalScrollView
        mAccentContainer = view.findViewById(R.id.tcd_accentContainer) as LinearLayout
        mPortraitParent = view.findViewById(R.id.tcd_portraitSwatchParent) as ScrollView
        mLandscapeParent = view.findViewById(R.id.tcd_landSwatchParent) as HorizontalScrollView
        mPortraitContainer = view.findViewById(R.id.tcd_portraitSwatchContainer) as TableLayout
        mLandscapeContainer = view.findViewById(R.id.tcd_landSwatchContainer) as LinearLayout
        mSwitch = view.findViewById(R.id.tcd_switch) as SwitchCompat

        if (isPortrait) {
            mPortraitParent!!.visibility = View.VISIBLE
            mLandscapeParent!!.visibility = View.GONE
        } else {
            mPortraitParent!!.visibility = View.GONE
            mLandscapeParent!!.visibility = View.VISIBLE
        }

        // start building the table
        initTable()

        // set switch position
        mSwitch!!.isChecked = getThemeHue(mContext!!)

        // set switch listener
        mSwitch!!.setOnCheckedChangeListener(mSwitchListener)

        // ThemeWrapper for the Dialog

        val context: ContextThemeWrapper = if (getThemeHue(mContext!!)) {
            ContextThemeWrapper(activity, android.R.style.Theme_Material_Light_Dialog)
        } else {
            ContextThemeWrapper(activity, android.R.style.Theme_Material_Dialog)
        } // if theme is light or dark

        // set switch text color
        if (getThemeHue(mContext!!)) {
            mSwitch!!.setTextColor(-0x1000000)
        } else {
            mSwitch!!.setTextColor(-0x1)
        }

        // create dialog
        // create dialog
        mAlertDialog = AlertDialog.Builder(context).setTitle(DIALOG_TITLE).setView(view).create()

        // UI
    } // onViewCreated

    private fun initTable() {

        val swatchArray: ArrayList<CardView> = getSwatchArray()

        val rows: ArrayList<TableRow> = ArrayList()

        // need to count how many items we add to tablerow
        var counter = 0

        var tr: TableRow? = null

        for (i in swatchArray.indices) {

            counter.plus(1)
            var cv: CardView

            if (getIsPortrait()) {
                // Portrait Mode

                cv = swatchArray[i]
                cv.setOnClickListener(swatchClickListener)

                if (counter == 1) {
                    tr = TableRow(mContext)
                    tr.layoutParams = TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                    )
                    tr.setPadding(10, 5, 10, 5)
                }

                tr?.addView(cv)

                if (counter == 3 || i == swatchArray.size) {
                    counter = 0
                    rows.add(tr!!)
                } // if its the 3rd item in group or if its the last item


            } else {
                // Landscape Mode

                cv = swatchArray[i]
                cv.setOnClickListener(swatchClickListener)

                mLandscapeContainer!!.addView(cv)

            }

        } // forEach

        for (row in rows) {
            mPortraitContainer!!.addView(row)
        } // for each loop

        val accentArray = getAccentsArray()

        for (ii in accentArray.indices) {

            val lay = accentArray[ii]
            lay.setOnClickListener(accentClickListener)

            mAccentContainer!!.addView(lay)

        } // forEach

        mAccentParent!!.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                mAccentParent!!.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val tn = getThemeColor(mContext!!)
                val tName: String?
                val aName: String
                if (tn.contains(THEME_SPLITTER)) {
                    val i: Array<String> = tn.split(THEME_SPLITTER).toTypedArray()
                    tName = i[0]
                    aName = i[1]
                } else {
                    tName = tn
                    val al: String = if (tName == BROWN || tName == GREY || tName == BLUEGREY) {
                        " 3"
                    } else {
                        " A1"
                    }
                    aName = tName + al
                }

                // Theme horizontal
                DialogUtils().scrollHorizontalThemePanelTo(tName, mLandscapeParent!!, mLandscapeContainer!!)
                // Theme vertical
                DialogUtils().scrollVerticalThemePanelTo(tName, mPortraitParent!!, mPortraitContainer!!)
                // Accent
                DialogUtils().scrollHorizontalThemePanelTo(aName, mAccentParent!!, mAccentContainer!!)
            }
        })

        swatchArray.clear()
        accentArray.clear()

    } // initTable

    // Switch Listener
    private var mSwitchListener =
        CompoundButton.OnCheckedChangeListener { _, isChecked ->
            // if theme is light or dark
            setThemeHue(mContext!!, isChecked)
            mListener?.onThemeChanged(getThemeColor(mContext!!), getThemeHue(mContext!!))
        } // onCheckChanged
    // mSwitchListener

    // SwatchListener
    private var swatchClickListener = View.OnClickListener { v ->
            val themeName = v.tag.toString()
            setThemeColor(mContext!!, themeName)
        val accentLabel: String =
            if (themeName == BROWN || themeName == GREY || themeName == BLUEGREY) {
                " 3"
            } else {
                " A1"
            }
            setAccentColor(mContext!!, themeName + accentLabel)
            DialogUtils().recheckThemeColor(mContext!!, getIsPortrait(), mPortraitContainer!!, mLandscapeContainer!!)
            DialogUtils().recheckAccentColor(mContext!!, mAccentContainer!!)
            DialogUtils().scrollHorizontalThemePanelTo(themeName, mAccentParent!!, mAccentContainer!!)
            mListener?.onThemeChanged(themeName, getThemeHue(mContext!!))
        } // onClick
    // swatchClickListener

    // AccentListener
    private var accentClickListener = View.OnClickListener { v ->
            val accentName = v.tag.toString()
            setAccentColor(mContext!!, accentName)
            var themeName = getThemeColor(mContext!!)
            if (themeName.contains(THEME_SPLITTER)) {
                val items: Array<String> = themeName.split(THEME_SPLITTER).toTypedArray()
                themeName = items[0]
            } // if theme has custom accent color
            themeName = themeName + THEME_SPLITTER + accentName
            setThemeColor(mContext!!, themeName)
            setAccentColor(mContext!!, accentName)
            DialogUtils().recheckAccentColor(mContext!!, mAccentContainer!!)
            mListener?.onThemeChanged(themeName, getThemeHue(mContext!!))
        } // onClick
    // accentClickListener

    // Processes Swatch Items
    private fun getSwatchArray(): ArrayList<CardView> {
        val cells: ArrayList<CardView> = ArrayList()
        val themesArray = resources.getStringArray(R.array.theme_color_names)
        for (th in themesArray) {
            cells.add(DialogUtils().getSwatchItem(mContext!!, th, getIsPortrait()))
        }
        return cells
    } // getSwatchArray

    // Processes Accent Items
    private fun getAccentsArray(): ArrayList<CardView> {
        val cells: ArrayList<CardView> = ArrayList()
        val themesArray = resources.getStringArray(R.array.accent_color_names)
        for (th in themesArray) {
            cells.add(DialogUtils().getAccentItem(mContext!!, th))
        }
        return cells
    } // getAccentsArray

    // Get Orientation as Boolean
    private fun getIsPortrait(): Boolean {
        return resources.configuration.orientation == 1
    } // getIsPortrait

} // Class