package com.jb15613.themechooser.utility

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import com.jb15613.themechooser.mtcpref.R
import android.widget.RelativeLayout

import android.widget.LinearLayout
import android.view.Gravity
import android.widget.TextView
import com.jb15613.themechooser.utility.ImageLoader.AsyncDrawable
import com.jb15613.themechooser.utility.ThemeChooserUtils.getPrimaryBgColor
import com.jb15613.themechooser.utility.color.AccentColor


class DialogUtils {

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
     * @param  context a [Context] that is needed to access preferences
     * @param  isPortrait a [Boolean] that is true if Portrait, false if Landscape
     * @param  portraitContainer a [TableLayout] that holds all the table rows
     * @param  landscapeContainer a [LinearLayout] that holds all the theme items
     */
    fun recheckThemeColor(context: Context, isPortrait: Boolean, portraitContainer: TableLayout, landscapeContainer: LinearLayout) {

        var themeName = PrefUtils.getThemeColor(context)

        val colors: IntArray = ColorUtils().getColorSet(themeName, context, true)

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
                        cv.setCardBackgroundColor(getPrimaryBgColor(context))
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
                    cv.setCardBackgroundColor(getPrimaryBgColor(context))
                }

            } // forEach

        } // if isPortrait or Landscape

    } // recheckThemeColor()

    /**
     * recheckAccentColor(context: [Context], accentContainer: [LinearLayout])
     *
     * Sets a Checkmark on appropriate Accent Item
     *
     * @param  context a [Context] that is needed to access preferences
     * @param  accentContainer a [LinearLayout] that holds all the accent items
     */
    fun recheckAccentColor(context: Context, accentContainer: LinearLayout) {

        val themeName = PrefUtils.getThemeColor(context)

        val colors = ColorUtils().getColorSet(themeName, context, true)

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
                cv.setCardBackgroundColor(getPrimaryBgColor(context))
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

        val colors = ColorUtils().getColorSet(themeName, context, false)

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        cv = inflater.inflate(R.layout.card_view, null) as CardView

        val ll = LinearLayout(context)
        val rl = RelativeLayout(context)

        if (isPortrait) {
            // Portrait Mode
            val cvParams: TableRow.LayoutParams = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT)
            cvParams.setMargins(4, 2, 4, 2)
            cvParams.weight = 1.0f
            cv.layoutParams = cvParams
            cv.setCardBackgroundColor(getPrimaryBgColor(context))
            cv.cardElevation = 5f
        } else {
            // Landscape Mode
            val cvParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            cvParams.setMargins(4, 2, 4, 2)
            cv.layoutParams = cvParams
            cv.setCardBackgroundColor(getPrimaryBgColor(context))
            cv.cardElevation = 5f
        }

        val llParams = FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        ll.layoutParams = llParams
        ll.orientation = LinearLayout.VERTICAL
        ll.gravity = Gravity.CENTER
        ll.setPadding(3, 3, 3, 3)

        val cellSize: Int = PrefUtils.getCellSize(context)

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

        if (PrefUtils.getThemeHue(context)) {
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

        val tn: String = PrefUtils.getThemeColor(context)

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
        val themename: String = PrefUtils.getThemeColor(context)
        val colors: IntArray = ColorUtils().getColorSet(themename, context, true)
        val color: Int = AccentColor().getColor(themeName, context)
        val cv: CardView
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        cv = inflater.inflate(R.layout.card_view, null) as CardView
        val ll = LinearLayout(context)
        val rl = RelativeLayout(context)
        val cvParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        cvParams.setMargins(4, 2, 4, 2)
        cvParams.weight = 1.0f
        cv.layoutParams = cvParams
        cv.setCardBackgroundColor(getPrimaryBgColor(context))
        cv.cardElevation = 5f
        val llParams: FrameLayout.LayoutParams = FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        )
        ll.layoutParams = llParams
        ll.orientation = LinearLayout.VERTICAL
        ll.gravity = Gravity.CENTER
        ll.setPadding(3, 3, 3, 3)
        val cellSize: Int = PrefUtils.getCellSize(context)
        val rlParams = RelativeLayout.LayoutParams(cellSize, cellSize)
        rl.layoutParams = rlParams
        rl.setPadding(3, 3, 3, 3)
        val tv = TextView(context)
        val circle = ImageView(context)
        val checked = ImageView(context)
        val tvParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val circleParams = RelativeLayout.LayoutParams(cellSize / 2 + 30, cellSize / 2 + 30)
        val checkedParams = RelativeLayout.LayoutParams(cellSize / 2, cellSize / 2)
        tv.layoutParams = tvParams
        tv.gravity = Gravity.CENTER
        circle.layoutParams = circleParams
        checked.layoutParams = checkedParams
        loadDrawable(
            context,
            "circle$themeName",
            circle,
            R.drawable.themechooser_shape_circle,
            color
        )
        if (PrefUtils.getThemeHue(context)) {
            loadDrawable(
                context,
                VIEW_CHECKED + themeName,
                checked,
                R.drawable.checkmark,
                -0x1000000
            )
        } else {
            loadDrawable(
                context,
                VIEW_CHECKED + themeName,
                checked,
                R.drawable.checkmark,
                -0x1
            )
        }
        circleParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        checkedParams.addRule(RelativeLayout.CENTER_IN_PARENT)
        tv.text = themeName
        tv.setTextColor(color)
        rl.addView(circle)
        rl.addView(checked)
        ll.addView(rl)
        ll.addView(tv)
        val tn: String = PrefUtils.getThemeColor(context)
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
            cv.setCardBackgroundColor(getPrimaryBgColor(context))
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
        // if (cancelPotentialWork(title, imageView)) {
            val task = ImageLoader(imageView, context.resources, id, color)
            val asyncDrawable = AsyncDrawable(context.resources, task)
            imageView.setImageDrawable(asyncDrawable)
            task.execute(title)
        // } // if work is not already ongoing
    } // loadDrawable

} // Class