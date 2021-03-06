package com.jb15613.themechooser.mtcpref

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.CompoundButton
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.set
import androidx.fragment.app.DialogFragment
import com.jb15613.themechooser.utility.*
import com.jb15613.themechooser.utility.PrefUtils.getThemeHue
import com.jb15613.themechooser.utility.ThemeChooserUtils.getPrimaryBgColor
import com.jb15613.themechooser.utility.ThemeChooserUtils.getPrimaryTextColor
import com.jb15613.themechooser.utility.ThemeChooserUtils.getSecondaryBgColor
import com.jb15613.themechooser.utility.color.AccentColor

/**
 * ## Custom [DialogFragment] Implementation
 */
class ThemeChooserDialog : DialogFragment() {

    // Context
    private var mContext: Context? = null
    // Parent Container
    var mParent: RelativeLayout? = null
    // Title Text View
    var mTitleText: TextView? = null
    // Divider
    var mDivider: View? = null
    // Accent Text View
    var mAccentText: TextView? = null
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
    // Toggle for Light/Dark
    private var mToggle: ToggleButton? = null
    // isLandscape
    private var isPortrait = false
    // Theme Change Listener
    private var mListener: OnThemeChangedListener? = null
    // Preferences
    private var mPrefs: SharedPreferences? = null
    // Resources
    private var mResources: Resources? = null

    // Interface linked to ThemeChooserPreference
    interface OnThemeChangedListener {
        fun onThemeChanged(theme: String?, hue: Boolean, isSwitch: Boolean)
    } // OnThemeChangedListener

    fun setOnThemeChangedListener(listener: OnThemeChangedListener) {
        mListener = listener
    } // setOnThemeChangedListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val d: Dialog = super.onCreateDialog(savedInstanceState)
        setStyle(STYLE_NORMAL, ThemeChooser.getTheme())

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
    } // onCreateDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.themechooser_dialog, container)
    } // onCreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (PrefUtils.getCellSize() == 0 ) {
            val width = this.resources.displayMetrics.widthPixels
            val cellDimen = width / 6
            PrefUtils.setCellSize(cellDimen)
        }

        // get views
        mParent = view.findViewById(R.id.tcd_relativeLayout) as RelativeLayout
        mTitleText = view.findViewById(R.id.themeChooserTextView) as TextView
        mDivider = view.findViewById(R.id.divider) as View
        mAccentText = view.findViewById(R.id.tcd_textView) as TextView
        mPortraitParent = view.findViewById(R.id.tcd_portraitSwatchParent) as ScrollView
        mPortraitContainer = view.findViewById(R.id.tcd_portraitSwatchContainer) as TableLayout
        mLandscapeParent = view.findViewById(R.id.tcd_landSwatchParent) as HorizontalScrollView
        mLandscapeContainer = view.findViewById(R.id.tcd_landSwatchContainer) as LinearLayout
        mAccentParent = view.findViewById(R.id.tcd_accentParent) as HorizontalScrollView
        mAccentContainer = view.findViewById(R.id.tcd_accentContainer) as LinearLayout
        mToggle = view.findViewById(R.id.tcd_toggleButton) as ToggleButton

        if (isPortrait) {
            mPortraitParent!!.visibility = View.VISIBLE
            mLandscapeParent!!.visibility = View.GONE
        } else {
            mPortraitParent!!.visibility = View.GONE
            mLandscapeParent!!.visibility = View.VISIBLE
        }

        // set colors
        setDialogColors()

        // start building the table
        initTable()

        // set toggle position
        mToggle!!.isChecked = getThemeHue()

        // set switch listener
        mToggle!!.setOnCheckedChangeListener(mToggleListener)

        // set switch text color
        mToggle!!.setTextColor(PrefUtils.getThemePrimaryTextColorInt())

    } // onViewCreated

    /**
     * Sets Appropriate Colors
     */
    private fun setDialogColors() {
        mParent?.setBackgroundColor(getSecondaryBgColor())
        mTitleText?.setTextColor(getPrimaryTextColor())
        mDivider?.setBackgroundColor(getPrimaryTextColor())
        mAccentText?.setTextColor(getPrimaryTextColor())
        mToggle?.setTextColor(getPrimaryTextColor())
    } // setDialogColors

    /**
     * ## Loads the Table with Theme Swatches
     */
    private fun initTable() {

        val swatchArray: ArrayList<CardView> = getSwatchArray()
        val rows: ArrayList<TableRow> = ArrayList()

        // need to count how many items we add to table row
        var rowCounter = 0
        var totalItemCount = 0
        var tr: TableRow? = null

        for (cv: CardView in swatchArray) {
            rowCounter += 1
            totalItemCount += 1
            // Log.e("ThemeChooserDialog", "counter = $rowCounter")
            // Log.e("ThemeChooserDialog", "totalItemCount = $totalItemCount")
            if (getIsPortrait()) {
                // Portrait Mode

                cv.setOnClickListener(swatchClickListener)

                if (rowCounter == 1) {
                    tr = TableRow(mContext)
                    tr.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
                    tr.setPadding(10, 5, 10, 5)
                }

                tr?.addView(cv)

                if (rowCounter == 3 || totalItemCount == swatchArray.size) {
                    rowCounter = 0
                    rows.add(tr!!)
                } // if its the 3rd item in group or if its the last item


            } else {
                // Landscape Mode

                cv.setOnClickListener(swatchClickListener)

                mLandscapeContainer!!.addView(cv)

            }
        } // forEach

        for (row in rows) {
            // Log.e("ThemeChooserDialog", "portrait row added")
            mPortraitContainer!!.addView(row)
        } // for each loop

        val accentArray: ArrayList<CardView> = getAccentsArray()
        for (cv: CardView in accentArray) {
            cv.setOnClickListener(accentClickListener)
            mAccentContainer!!.addView(cv)
        }

        mAccentParent!!.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                mAccentParent!!.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val tn = PrefUtils.getThemeName()
                val tName: String?
                val aName: String

                if (tn.contains(HUE_SPLITTER)) {
                    // SHOULD ALWAYS BE TRUE
                    val hueSplit: Array<String> = tn.split(HUE_SPLITTER).toTypedArray()
                    val hueSplitTheme = hueSplit[0]

                    if (hueSplitTheme.contains(THEME_SPLITTER)) {
                        val themeSplit: Array<String> = hueSplitTheme.split(THEME_SPLITTER).toTypedArray()
                        tName = themeSplit[0]
                        aName = themeSplit[1]
                    } else {
                        tName = hueSplitTheme
                        val al: String = if (tName == BROWN || tName == GREY || tName == BLUEGREY) {
                            " 3"
                        } else {
                            " A1"
                        }
                        aName = "$tName$al"
                    }

                } else {
                    // SHOULD NEVER HAPPEN
                    if (tn.contains(THEME_SPLITTER)) {
                        val themeSplit: Array<String> = tn.split(THEME_SPLITTER).toTypedArray()
                        tName = themeSplit[0]
                        aName = themeSplit[1]
                    } else {
                        tName = tn
                        val al: String = if (tName == BROWN || tName == GREY || tName == BLUEGREY) {
                            " 3"
                        } else {
                            " A1"
                        }
                        aName = tName + al
                    }

                }

                // Place Checkmarks
                recheckAccentColor(mAccentContainer!!)
                recheckThemeColor(getIsPortrait(), mPortraitContainer!!, mLandscapeContainer!!)

                // Scroll To
                // Theme horizontal (Landscape Mode)
                scrollHorizontalThemePanelTo(tName, mLandscapeParent!!, mLandscapeContainer!!)
                // Theme vertical (Portrait Mode)
                scrollVerticalThemePanelTo(tName, mPortraitParent!!, mPortraitContainer!!)
                // Accent (Both Orientations)
                scrollHorizontalThemePanelTo(aName, mAccentParent!!, mAccentContainer!!)
            }
        })

        swatchArray.clear()
        accentArray.clear()

    } // initTable

    /**
     * ## Listener on the [ToggleButton] controlling Theme *Hue*
     */
    private var mToggleListener = CompoundButton.OnCheckedChangeListener { _, isChecked ->
        // if theme is light or dark
        val oldTheme = PrefUtils.getThemeName()

        var old = ""

        if (oldTheme.contains(HUE_SPLITTER)) {
            // SHOULD ALWAYS BE TRUE
            val oldSplit: List<String> = oldTheme.split(HUE_SPLITTER)
            old = oldSplit[0]
        }

        val newTheme: String = if (isChecked) {
            // Light Theme
            "$old$HUE_SPLITTER$HUE_LIGHT"
        } else {
            // Dark Theme
            "$old$HUE_SPLITTER$HUE_DARK"
        }

        PrefUtils.setThemeHue(isChecked)
        PrefUtils.setThemeName(newTheme)
        mListener?.onThemeChanged(newTheme, isChecked, true)
        setDialogColors()
        // also want to recheck swatch item
        recheckThemeColor(getIsPortrait(), mPortraitContainer!!, mLandscapeContainer!!)
        recheckAccentColor(mAccentContainer!!)
        // swap and animate bg
    } // onCheckChanged

    /**
     * ## Listener on the Theme Swatch
     */
    private var swatchClickListener = View.OnClickListener { v ->

        // this tag holds the new Theme Color
        val themeName = v.tag.toString()

        // get old Theme from prefs so we can see what hue it's using
        val oldTheme = PrefUtils.getThemeName()

        // this will hold our old hue value

        // see if theme has a hue set
        val oldHue: String = if (oldTheme.contains(HUE_SPLITTER)) {
            // SHOULD ALWAYS BE TRUE
            // split it to isolate the hue
            val items: List<String> = oldTheme.split(HUE_SPLITTER)
            items[1]
        } else {
            // SHOULD NEVER HAPPEN
            // use default value
            HUE_DARK
        }

        // Set Theme Name
        PrefUtils.setThemeName("$themeName$HUE_SPLITTER$oldHue")

        // put a checkmark on theme item
        recheckThemeColor(getIsPortrait(), mPortraitContainer!!, mLandscapeContainer!!)

        // put a checkmark on accent item
        recheckAccentColor(mAccentContainer!!)

        // scroll accent panel to checked item
        scrollHorizontalThemePanelTo(PrefUtils.getAccentName().toString(), mAccentParent!!, mAccentContainer!!)

        // report preference change
        mListener?.onThemeChanged("$themeName$HUE_SPLITTER$oldHue", getThemeHue(), false)

        } // swatchClickListener

    /**
     * ## Listener on the Accent Swatch controlling Theme *Accent*
     */
    private var accentClickListener = View.OnClickListener { v ->

        val accentName = v.tag.toString()

        val oldHue: String
        var oldTheme = ""

        val themeName = PrefUtils.getThemeName()

        if (themeName.contains(HUE_SPLITTER)) {
            // SHOULD ALWAYS BE TRUE
            val hueSplit: List<String> = themeName.split(HUE_SPLITTER)
            oldHue = hueSplit[1]

            oldTheme = if (hueSplit[0].contains(THEME_SPLITTER)) {
                val themeSplit: List<String> = hueSplit[0].split(THEME_SPLITTER)
                themeSplit[0]
            } else {
                hueSplit[0]
            }

        } else {
            oldHue = HUE_DARK
        }

        val newTheme = "$oldTheme$THEME_SPLITTER$accentName$HUE_SPLITTER$oldHue"
        PrefUtils.setThemeName(newTheme)
        recheckAccentColor(mAccentContainer!!)
        mListener?.onThemeChanged(newTheme, getThemeHue(), false)
    } // accentClickListener

    /**
     * ## Loads an [ArrayList] with [CardView]s containing Theme Swatches
     *
     * @return [ArrayList] with Theme Swatches
     */
    private fun getSwatchArray(): ArrayList<CardView> {
        val cells: ArrayList<CardView> = ArrayList()
        val themesArray = resources.getStringArray(R.array.theme_color_names)
        for (th in themesArray) {
            cells.add(getSwatchItem(mContext!!, th, getIsPortrait()))
        }
        return cells
    } // getSwatchArray

    /**
     * ## Loads an [ArrayList] with [CardView]s containing Accent Swatches
     *
     * @return [ArrayList] with Accent Swatches
     */
    private fun getAccentsArray(): ArrayList<CardView> {
        val cells: ArrayList<CardView> = ArrayList()
        val themesArray = resources.getStringArray(R.array.accent_color_names)
        for (th in themesArray) {
            cells.add(getAccentItem(mContext!!, th))
        }
        return cells
    } // getAccentsArray

    /**
     * ## Gets Device Orientation
     *
     * @return [Boolean] (true = Portrait | false = Landscape)
     */
    private fun getIsPortrait(): Boolean {
        return resources.configuration.orientation == 1
    } // getIsPortrait

    /**
     ## Scrolls the Vertical Theme Table to desired position
     *
     * @param  themeName a [String] that represents which item to scroll to
     * @param  portraitParent a [ScrollView] that will get its scroll position set
     * @param  portraitContainer a [TableLayout] that hold all the items inside scroll view
     */
    fun scrollVerticalThemePanelTo(themeName: String, portraitParent: ScrollView, portraitContainer: TableLayout) {

        var desiredItem = 0

        for (i in 0 until portraitContainer.childCount) {

            val tr: TableRow = portraitContainer.getChildAt(i) as TableRow

            if (tr.childCount > 1) {

                val cv1: CardView = tr.getChildAt(0) as CardView
                val cv2: CardView = tr.getChildAt(1) as CardView
                val cv3: CardView = tr.getChildAt(2) as CardView

                if (cv1.tag.equals(themeName) || cv2.tag.equals(themeName) || cv3.tag.equals(themeName)) {
                    desiredItem = tr.top
                }

            } else {

                val cv1: CardView = tr.getChildAt(0) as CardView

                if (cv1.tag.equals(themeName)) {
                    desiredItem = tr.top
                }

            } // if child count is greater than 1 or not

        } // for every table row

        portraitParent.scrollY = desiredItem

    } // scrollVerticalThemePanelTo()

    /**
     ## Scrolls the Vertical Theme Table to desired position
     *
     * @param  themeName a [String] that represents which item to scroll to
     * @param  landscapeParent a [HorizontalScrollView] that will get its scroll position set
     * @param  landscapeContainer a [LinearLayout] that hold all the items inside scroll view
     */
    fun scrollHorizontalThemePanelTo(themeName: String, landscapeParent: HorizontalScrollView, landscapeContainer: LinearLayout) {

        var desiredItem = 0

        for (i in 0 until landscapeContainer.childCount) {

            val cv1: CardView = landscapeContainer.getChildAt(i) as CardView
            if (cv1.tag.equals(themeName)) {
                desiredItem = cv1.left
            }

        } // forEach

        landscapeParent.scrollX = desiredItem

    } // scrollHorizontalThemePanelTo

    /**
     ## Sets a Checkmark on appropriate Theme Item
     *
     * @param  isPortrait a [Boolean] that is true if Portrait, false if Landscape
     * @param  portraitContainer a [TableLayout] that holds all the table rows
     * @param  landscapeContainer a [LinearLayout] that holds all the theme items
     */
    private fun recheckThemeColor(isPortrait: Boolean, portraitContainer: TableLayout, landscapeContainer: LinearLayout) {

        var themeName = PrefUtils.getThemeName()

        val colors: IntArray = ColorUtils.getColorSet(themeName, true)

        if (themeName.contains(HUE_SPLITTER)) {
            // SHOULD ALWAYS BE TRUE
            // split it at the hue
            val items: List<String> = themeName.split(HUE_SPLITTER)

            themeName = if (items[0].contains(THEME_SPLITTER)) {
                val tSplit: List<String> = items[0].split(THEME_SPLITTER)
                tSplit[0]
            } else {
                items[0]
            }

        }

        if (isPortrait) {
            // Portrait mode
            for (i in 0 until portraitContainer.childCount) {

                val tr: TableRow = portraitContainer.getChildAt(i) as TableRow
                for (ii in 0 until tr.childCount) {

                    val cv: CardView = tr.getChildAt(ii) as CardView
                    val ll: LinearLayout = cv.getChildAt(0) as LinearLayout
                    val rl: RelativeLayout = ll.getChildAt(0) as RelativeLayout

                    val checked: ImageView = rl.findViewWithTag(VIEW_CHECKED)
                    checked.setColorFilter(getPrimaryTextColor(), PorterDuff.Mode.SRC_IN)

                    if (checked.visibility == View.VISIBLE) {
                        checked.visibility = View.INVISIBLE
                    }

                    if (themeName == cv.tag) {
                        checked.visibility = View.VISIBLE
                        cv.setCardBackgroundColor(colors[2])
                    } else {
                        cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
                    }

                } // forEach

            } // forEach

        } else {
            // Landscape Mode
            for (i in 0 until landscapeContainer.childCount) {

                val cv: CardView = landscapeContainer.getChildAt(i) as CardView
                val ll: LinearLayout = cv.getChildAt(0) as LinearLayout
                val rl: RelativeLayout = ll.getChildAt(0) as RelativeLayout

                val checked: ImageView = rl.findViewWithTag(VIEW_CHECKED)
                checked.setColorFilter(getPrimaryTextColor(), PorterDuff.Mode.SRC_IN)

                if (checked.visibility == View.VISIBLE) {
                    checked.visibility = View.INVISIBLE
                }

                if (themeName == cv.tag) {
                    checked.visibility = View.VISIBLE
                    cv.setCardBackgroundColor(colors[2])
                } else {
                    cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
                }

            } // forEach

        } // if isPortrait or Landscape

    } // recheckThemeColor()

    /**
     ## Sets a Checkmark on appropriate Accent Item
     *
     * @param  accentContainer a [LinearLayout] that holds all the accent items
     */
    private fun recheckAccentColor(accentContainer: LinearLayout) {

        val themeName = PrefUtils.getThemeName()
        val accentName = PrefUtils.getAccentName()

        val colors = ColorUtils.getColorSet(themeName, true)

        for (i in 0 until accentContainer.childCount) {

            val cv: CardView = accentContainer.getChildAt(i) as CardView
            val ll: LinearLayout = cv.getChildAt(0) as LinearLayout
            val rl: RelativeLayout = ll.getChildAt(0) as RelativeLayout
            val tv: TextView = ll.getChildAt(1) as TextView

            val checked: ImageView = rl.findViewWithTag(VIEW_CHECKED)
            checked.setColorFilter(getPrimaryTextColor(), PorterDuff.Mode.SRC_IN)

            if (checked.visibility == View.VISIBLE) {
                checked.visibility = View.INVISIBLE
            }

            if (accentName == cv.tag) {
                checked.visibility = View.VISIBLE
                cv.setCardBackgroundColor(colors[2])
                tv.setTextColor(ThemeChooserUtils.getPrimaryTextColor())
            } else {
                cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
                tv.setTextColor(ColorUtils.getCustomAccentColor(cv.tag.toString()))
            }

        }

    } // recheckAccentColor()

    /**
     ## Creates a [CardView] containing a Swatch Item
     *
     * @param context a [Context] to retrieve [LayoutInflater]
     * @param  themeName a [String] containing the Theme Name
     * @param isPortrait a [Boolean] that represents the orientation of our view
     *
     * @return [CardView] that represents an icon depicting current chosen Theme Colors
     */
    @SuppressLint("InflateParams")
    fun getSwatchItem(context: Context, themeName: String, isPortrait: Boolean) : CardView {

        val cv:CardView

        val colors = ColorUtils.getColorSet(themeName, false)

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        cv = inflater.inflate(R.layout.card_view, null) as CardView

        val ll = LinearLayout(context)
        val rl = RelativeLayout(context)

        if (isPortrait) {
            // Portrait Mode
            val cvParams: TableRow.LayoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
            cvParams.setMargins(4, 2, 4, 2)
            cvParams.weight = 1.0f
            cv.layoutParams = cvParams
            cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
            cv.cardElevation = 5f
        } else {
            // Landscape Mode
            val cvParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            cvParams.setMargins(4, 2, 4, 2)
            cv.layoutParams = cvParams
            cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
            cv.cardElevation = 5f
        }

        val llParams = FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        ll.layoutParams = llParams
        ll.orientation = LinearLayout.VERTICAL
        ll.gravity = Gravity.CENTER
        ll.setPadding(3, 3, 3, 3)

        val cellSize: Int = PrefUtils.getCellSize()

        val rlParams = RelativeLayout.LayoutParams(cellSize, cellSize)
        rl.layoutParams = rlParams
        rl.setPadding(3, 3, 3, 3)

        val tv = TextView(context)

        val bottomCircle = ImageView(context)
        val middleCircle = ImageView(context)
        val topCircle = ImageView(context)
        val checked = ImageView(context)

        val tvParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        val bottomCircleParams = RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2)
        val middleCircleParams = RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2)
        val topCircleParams = RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2)
        val checkedParams = RelativeLayout.LayoutParams(cellSize - 8, cellSize - 8)

        tv.layoutParams = tvParams
        tv.gravity = Gravity.CENTER

        bottomCircle.layoutParams = bottomCircleParams
        middleCircle.layoutParams = middleCircleParams
        topCircle.layoutParams = topCircleParams
        checked.layoutParams = checkedParams

        loadDrawable(context, "bottomCircle$themeName", bottomCircle, R.drawable.themechooser_shape_circle, colors[2])
        loadDrawable(context, "middleCircle$themeName", middleCircle, R.drawable.themechooser_shape_circle, colors[0])
        loadDrawable(context, "topCircle$themeName", topCircle, R.drawable.themechooser_shape_circle, colors[1])

        loadDrawable(context, VIEW_CHECKED + themeName, checked, R.drawable.checkmark, PrefUtils.getThemePrimaryTextColorInt())

        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

        middleCircleParams.addRule(RelativeLayout.CENTER_IN_PARENT)

        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)

        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT)

        tv.text = themeName
        tv.setTextColor(colors[0])

        rl.addView(bottomCircle)
        rl.addView(middleCircle)
        rl.addView(topCircle)
        rl.addView(checked)

        ll.addView(rl)
        ll.addView(tv)

        val tn: String = PrefUtils.getThemeName()

        if (tn.contains(THEME_SPLITTER)) {
            val t: Array<String> = tn.split(THEME_SPLITTER).toTypedArray()
            if (t[0] == themeName) {
                checked.visibility = View.VISIBLE
                cv.setCardBackgroundColor(colors[2])
            } else {
                checked.visibility = View.INVISIBLE
            }
        } else {
            if (tn == themeName) {
                checked.visibility = View.VISIBLE
                cv.setCardBackgroundColor(colors[2])
            } else {
                checked.visibility = View.INVISIBLE
            }
        }

        checked.tag = VIEW_CHECKED

        cv.tag = themeName
        cv.addView(ll)

        return cv

    } // getSwatchItem()

    /**
     ## Creates a [CardView] containing an Accent Item
     *
     * @param context a [Context] to retrieve a [LayoutInflater]
     * @param  themeName a [String] that contains the Theme Name
     *
     * @return [CardView] that represents an icon depicting current chosen Accent Color
     */
    @SuppressLint("InflateParams")
    fun getAccentItem(context: Context, themeName: String): CardView {

        // comes from accent_names_array
        // no splitting needed
        val themename: String = PrefUtils.getThemeName()
        val colors: IntArray = ColorUtils.getColorSet(themename, true)
        val color: Int = AccentColor.getColor(themeName)

        val cv: CardView

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        cv = inflater.inflate(R.layout.card_view, null) as CardView

        val ll = LinearLayout(context)
        val rl = RelativeLayout(context)

        val cvParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        cvParams.setMargins(4, 2, 4, 2)
        cvParams.weight = 1.0f
        cv.layoutParams = cvParams
        cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
        cv.cardElevation = 5f

        val llParams: FrameLayout.LayoutParams = FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        ll.layoutParams = llParams
        ll.orientation = LinearLayout.VERTICAL
        ll.gravity = Gravity.CENTER
        ll.setPadding(3, 3, 3, 3)

        val cellSize: Int = PrefUtils.getCellSize()

        val rlParams = RelativeLayout.LayoutParams(cellSize, cellSize)
        rl.layoutParams = rlParams
        rl.setPadding(3, 3, 3, 3)

        val tv = TextView(context)
        val circle = ImageView(context)
        val checked = ImageView(context)

        val tvParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val circleParams = RelativeLayout.LayoutParams(cellSize / 2 + 30, cellSize / 2 + 30)
        val checkedParams = RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2)

        tv.layoutParams = tvParams
        tv.gravity = Gravity.CENTER
        circle.layoutParams = circleParams
        checked.layoutParams = checkedParams

        loadDrawable(context, "circle$themeName", circle, R.drawable.themechooser_shape_circle, color)
        loadDrawable(context, VIEW_CHECKED + themeName, checked, R.drawable.checkmark, PrefUtils.getThemePrimaryTextColorInt())

        circleParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT)

        tv.text = themeName

        rl.addView(circle)
        rl.addView(checked)

        ll.addView(rl)
        ll.addView(tv)

        val tn: String = PrefUtils.getThemeName()
        val tName: String
        val aName: String

        if (tn.contains(THEME_SPLITTER)) {
            val items: Array<String> = tn.split(THEME_SPLITTER).toTypedArray()
            aName = items[1]
        } else {
            tName = tn
            val anl: String = if (tn == BROWN || tn == GREY || tn == BLUEGREY) {
                " 3"
            } else {
                " A1"
            }
            aName = tName + anl
        }

        if (themeName == aName) {
            checked.visibility = View.VISIBLE
            cv.setCardBackgroundColor(colors[0])
            tv.setTextColor(ThemeChooserUtils.getPrimaryTextColor())
        } else {
            checked.visibility = View.INVISIBLE
            cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
            tv.setTextColor(color)
        }

        checked.tag = VIEW_CHECKED
        cv.tag = themeName
        cv.addView(ll)

        return cv
    } // getAccentItem

    /**
     ## Loads drawables asynchronously
     *
     * @param context a [Context] to retrieve Resources
     * @param  title a [String] that is used to identify a drawable
     * @param  imageView an [ImageView] that the drawable will be bound to
     * @param  id an [Int] that is the ResourceId of the Drawable
     * @param  color an [Int] that represents the color we want to make the drawable
     */
    private fun loadDrawable(context: Context, title: String, imageView: ImageView, id: Int, color: Int) {
        // if (ImageLoader(imageView, mResources, id, color).cancelPotentialWork(title, imageView)) {
            val task = ImageLoader(imageView, context.resources, id, color)
            val asyncDrawable = ImageLoader.AsyncDrawable(context.resources, task)
            imageView.setImageDrawable(asyncDrawable)
            task.execute(title)
        // } // if work is not already ongoing

    } // loadDrawable

} // Class