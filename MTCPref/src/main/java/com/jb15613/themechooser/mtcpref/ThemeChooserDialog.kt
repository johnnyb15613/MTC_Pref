package com.jb15613.themechooser.mtcpref

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.jb15613.themechooser.utility.color.AccentColor

class ThemeChooserDialog : DialogFragment() {

    // Context
    private var mContext: Context? = null
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
    // Resources
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.themechooser_dialog, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (PrefUtils.getCellSize() == 0 ) {
            val width = this.resources.displayMetrics.widthPixels
            val cellDimen = width / 6
            PrefUtils.setCellSize(cellDimen)
        }

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
        mSwitch!!.isChecked = getThemeHue()

        // set switch listener
        mSwitch!!.setOnCheckedChangeListener(mSwitchListener)

        // ThemeWrapper for the Dialog

        val context: ContextThemeWrapper = if (getThemeHue()) {
            ContextThemeWrapper(activity, android.R.style.Theme_Material_Light_Dialog)
        } else {
            ContextThemeWrapper(activity, android.R.style.Theme_Material_Dialog)
        } // if theme is light or dark

        // set switch text color
        if (getThemeHue()) {
            mSwitch!!.setTextColor(-0x1000000)
        } else {
            mSwitch!!.setTextColor(-0x1)
        }

        // create dialog
        mAlertDialog = AlertDialog.Builder(context).setTitle(DIALOG_TITLE).setView(view).create()
        // mAlertDialog!!.show()

        // UI
    } // onViewCreated

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
                    tr.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT)
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

        val accentArray = getAccentsArray()

        for (ii in accentArray.indices) {

            val lay = accentArray[ii]
            lay.setOnClickListener(accentClickListener)

            mAccentContainer!!.addView(lay)

        } // forEach

        mAccentParent!!.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {

                mAccentParent!!.viewTreeObserver.removeOnGlobalLayoutListener(this)

                val tn = getThemeColor()
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
                scrollHorizontalThemePanelTo(tName, mLandscapeParent!!, mLandscapeContainer!!)
                // Theme vertical
                scrollVerticalThemePanelTo(tName, mPortraitParent!!, mPortraitContainer!!)
                // Accent
                scrollHorizontalThemePanelTo(aName, mAccentParent!!, mAccentContainer!!)
            }
        })

        swatchArray.clear()
        accentArray.clear()

    } // initTable

    // Switch Listener
    private var mSwitchListener =
        CompoundButton.OnCheckedChangeListener { _, isChecked ->
            // if theme is light or dark
            setThemeHue(isChecked)
            mListener?.onThemeChanged(getThemeColor(), getThemeHue())
        } // onCheckChanged
    // mSwitchListener

    // SwatchListener
    private var swatchClickListener = View.OnClickListener { v ->
            val themeName = v.tag.toString()
            setThemeColor(themeName)
        val accentLabel: String =
            if (themeName == BROWN || themeName == GREY || themeName == BLUEGREY) {
                " 3"
            } else {
                " A1"
            }
            setAccentColor(themeName + accentLabel)
            recheckThemeColor(getIsPortrait(), mPortraitContainer!!, mLandscapeContainer!!)
            recheckAccentColor(mAccentContainer!!)
            scrollHorizontalThemePanelTo(themeName, mAccentParent!!, mAccentContainer!!)
            mListener?.onThemeChanged(themeName, getThemeHue())
        } // onClick
    // swatchClickListener

    // AccentListener
    private var accentClickListener = View.OnClickListener { v ->
            val accentName = v.tag.toString()
            setAccentColor(accentName)
            var themeName = getThemeColor()
            if (themeName.contains(THEME_SPLITTER)) {
                val items: Array<String> = themeName.split(THEME_SPLITTER).toTypedArray()
                themeName = items[0]
            } // if theme has custom accent color
            themeName = themeName + THEME_SPLITTER + accentName
            setThemeColor(themeName)
            setAccentColor(accentName)
            recheckAccentColor(mAccentContainer!!)
            mListener?.onThemeChanged(themeName, getThemeHue())
        } // onClick
    // accentClickListener

    // Processes Swatch Items
    private fun getSwatchArray(): ArrayList<CardView> {
        val cells: ArrayList<CardView> = ArrayList()
        val themesArray = resources.getStringArray(R.array.theme_color_names)
        for (th in themesArray) {
            cells.add(getSwatchItem(mContext!!, th, getIsPortrait()))
        }
        return cells
    } // getSwatchArray

    // Processes Accent Items
    private fun getAccentsArray(): ArrayList<CardView> {
        val cells: ArrayList<CardView> = ArrayList()
        val themesArray = resources.getStringArray(R.array.accent_color_names)
        for (th in themesArray) {
            cells.add(getAccentItem(mContext!!, th))
        }
        return cells
    } // getAccentsArray

    // Get Orientation as Boolean
    private fun getIsPortrait(): Boolean {
        return resources.configuration.orientation == 1
    } // getIsPortrait

    /**
     * scrollVerticalThemePanelTo(themeName: [String], portraitParent: [ScrollView], portraitContainer: [TableLayout])
     *
     * Scrolls the Vertical Theme Table to desired position
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
     * scrollHorizontalThemePanelTo(themeName: [String], landscapeParent: [HorizontalScrollView], landscapeContainer: [LinearLayout])
     *
     * Scrolls the Vertical Theme Table to desired position
     *
     * @param  themeName a [String] that represents which item to scroll to
     * @param  landscapeParent a [HorizontalScrollView] that will get its scroll position set
     * @param  landscapeContainer a [LinearLayout] that hold all the items inside scroll view
     */
    fun scrollHorizontalThemePanelTo(themeName: String, landscapeParent: HorizontalScrollView, landscapeContainer: LinearLayout) {

        var desiredItem = 0

        for (i in 0 until landscapeContainer.childCount) {

            val cv1: CardView = landscapeContainer.getChildAt(0) as CardView

            if (cv1.tag.equals(themeName)) {
                desiredItem = cv1.left
            }

        } // forEach

        landscapeParent.scrollX = desiredItem

    } // scrollHorizontalThemePanelTo

    /**
     * recheckThemeColor(context: [Context], isPortrait: [Boolean], portraitContainer: [TableLayout], landscapeContainer: [LinearLayout])
     *
     * Sets a Checkmark on appropriate Theme Item
     *
     * @param  isPortrait a [Boolean] that is true if Portrait, false if Landscape
     * @param  portraitContainer a [TableLayout] that holds all the table rows
     * @param  landscapeContainer a [LinearLayout] that holds all the theme items
     */
    fun recheckThemeColor(isPortrait: Boolean, portraitContainer: TableLayout, landscapeContainer: LinearLayout) {

        var themeName = getThemeColor()

        val colors: IntArray = ColorUtils.getColorSet(themeName, true)

        if (themeName.contains(THEME_SPLITTER)) {
            val items: List<String> = themeName.split(THEME_SPLITTER)
            themeName = items[0]
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
     * recheckAccentColor(accentContainer: [LinearLayout])
     *
     * Sets a Checkmark on appropriate Accent Item
     *
     * @param  accentContainer a [LinearLayout] that holds all the accent items
     */
    fun recheckAccentColor(accentContainer: LinearLayout) {

        val themeName = getThemeColor()

        val colors = ColorUtils.getColorSet(themeName, true)

        for (i in 0 until accentContainer.childCount) {

            val cv: CardView = accentContainer.getChildAt(i) as CardView
            val ll: LinearLayout = cv.getChildAt(0) as LinearLayout
            val rl: RelativeLayout = ll.getChildAt(0) as RelativeLayout

            val checked: ImageView = rl.findViewWithTag(VIEW_CHECKED)

            if (checked.visibility == View.VISIBLE) {
                checked.visibility = View.INVISIBLE
            }

            if (themeName == cv.tag) {
                checked.visibility = View.VISIBLE
                cv.setCardBackgroundColor(colors[2])
            } else {
                cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
            }

        }

    } // recheckAccentColor()

    /**
     * getSwatchItem(context: [Context], themeName: [String], isPortrait: [Boolean]) : [CardView]
     *
     * Creates a [CardView] containing a Swatch Item
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

        if (getThemeHue()) {
            loadDrawable(context, VIEW_CHECKED + themeName, checked, R.drawable.checkmark, Color.BLACK)
        } else {
            loadDrawable(context, VIEW_CHECKED + themeName, checked, R.drawable.checkmark, Color.WHITE)
        }

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

        val tn: String = getThemeColor()

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
     * getAccentItem(context: [Context], themeName: [String]): [CardView]
     *
     * Creates a [CardView] containing an Accent Item
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
        val themename: String = getThemeColor()
        val colors: IntArray = ColorUtils.getColorSet(themename, true)
        val color: Int = AccentColor().getColor(themeName, context)

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
        if (PrefUtils.getThemeHue()) {
            loadDrawable(context, VIEW_CHECKED + themeName, checked, R.drawable.checkmark, -0x1000000)
        } else {
            loadDrawable(context, VIEW_CHECKED + themeName, checked, R.drawable.checkmark, -0x1)
        }

        circleParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT)

        tv.text = themeName
        tv.setTextColor(color)

        rl.addView(circle)
        rl.addView(checked)

        ll.addView(rl)
        ll.addView(tv)

        val tn: String = getThemeColor()
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
        } else {
            checked.visibility = View.INVISIBLE
            cv.setCardBackgroundColor(ThemeChooserUtils.getPrimaryBgColor())
        }

        checked.tag = VIEW_CHECKED
        cv.tag = themeName
        cv.addView(ll)

        return cv
    } // getAccentItem


    /**
     * private loadDrawable(context: [Context], title: [String], imageView: [ImageView], id: [Int], color: [Int])
     *
     * Loads drawables asynchronously
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