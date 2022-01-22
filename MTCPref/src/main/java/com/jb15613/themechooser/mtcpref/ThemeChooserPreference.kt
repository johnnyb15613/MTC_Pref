package com.jb15613.themechooser.mtcpref

import android.widget.RelativeLayout
import android.graphics.PorterDuff
import androidx.core.content.res.ResourcesCompat
import android.view.Gravity
import android.widget.LinearLayout
import android.content.Context
import android.os.Parcelable
import android.widget.TextView
import androidx.preference.PreferenceViewHolder
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.preference.Preference
import com.jb15613.themechooser.mtcpref.ThemeChooserDialog.OnThemeChangedListener
import com.jb15613.themechooser.utility.*
import com.jb15613.themechooser.utility.HUE_SPLITTER
import com.jb15613.themechooser.utility.LIGHTBLUE
import com.jb15613.themechooser.utility.PrefUtils.getDensityScale
import com.jb15613.themechooser.utility.PrefUtils.getThemeHue
import com.jb15613.themechooser.utility.PrefUtils.getThemeName
import com.jb15613.themechooser.utility.PrefUtils.setDensityScale
import com.jb15613.themechooser.utility.THEME_SPLITTER
import com.jb15613.themechooser.utility.color.AccentColor
import java.lang.ClassCastException
import java.lang.NullPointerException

/**
 * ## Custom [Preference] Implementation
 */
class ThemeChooserPreference : Preference, Preference.OnPreferenceClickListener, OnThemeChangedListener {

    private var mContext: Context? = null
    private var mCtx: Context = context
    private var mSwatchContainer: LinearLayout? = null

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        mContext = context
        init()
    }

    private fun init() {
        layoutResource = R.layout.themechooser_preference
        onPreferenceClickListener = this
        onPreferenceChangeListener = pcListener
        if (mContext != null) {
            mCtx = mContext as Context
        }
    }

    override fun onGetDefaultValue(a: TypedArray, index: Int): Any {
        val mThemeDefaultValue = a.getString(index)
        return mThemeDefaultValue ?: LIGHTBLUE
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        mSwatchContainer = holder.findViewById(R.id.swatchView) as LinearLayout?
        val mSummaryText = holder.findViewById(R.id.summary) as TextView
        if (getDensityScale() == 0f) {
            setDensityScale(context.resources.displayMetrics.density)
        }
        swapThemeSwatch(getThemeName())
        val summary = getThemeName()
        mSummaryText.text = summary
    }

    override fun onThemeChanged(theme: String?, hue: Boolean, isSwitch: Boolean) {
        try {
            onPreferenceChangeListener.onPreferenceChange(this, isSwitch)
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    } // onThemeChanged

    private var pcListener: OnPreferenceChangeListener = OnPreferenceChangeListener { preference, newValue ->
        Log.e("onPreferenceChange", "$preference : newValue : $newValue")

        val themeName = PrefUtils.getThemeName()

        if (newValue is Boolean) {
            // SHOULD ALWAYS BE TRUE
            if (!newValue) {
                // called from theme or accent
                swapThemeSwatch(themeName)
            }
        }

        preference.summary = themeName
        true
    } // OnPreferenceChangeListener

    override fun onSaveInstanceState(): Parcelable {
        Log.e("MTCPref", "onSaveInstanceState() called")
        return super.onSaveInstanceState()
    } // onSaveInstanceState

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        Log.e("MTCPref", "onRestoreInstanceState() called")
        val fm: FragmentManager? = getFragMan()
        if (fm != null) {
            val mDialog = fm.findFragmentByTag("TCD") as ThemeChooserDialog
            mDialog.setOnThemeChangedListener(this)
        }
        onPreferenceClickListener = this
        onPreferenceChangeListener = pcListener
    } // onRestoreInstanceState

    override fun onPreferenceClick(preference: Preference?): Boolean {
        showDialog()
        return false
    } // onPreferenceClick

    /**
     * ## Shows the Dialog
     */
    private fun showDialog() {
        val fm: FragmentManager? = getFragMan()
        if (fm != null) {
            val mDialog = ThemeChooserDialog()
            mDialog.setOnThemeChangedListener(this)
            mDialog.show(fm, "TCD")
        }
    } // showDialog

    /**
     * ## Retrieves the [FragmentManager]
     *
     * @return [FragmentManager]
     */
    private fun getFragMan(): FragmentManager? {
        return try {
            val a: FragmentActivity = mContext as FragmentActivity
            a.supportFragmentManager
        } catch (e: ClassCastException) {
            e.printStackTrace()
            null
        }
    }// getFragMan

    /**
     * ## Used to clear and reload the new Theme Icon
     *
     * @param theme a [String] that is the new Theme Name
     */
    private fun swapThemeSwatch(theme: String?) {
        if (mSwatchContainer!!.childCount > 0) {
            mSwatchContainer!!.removeAllViews()
        }
        mSwatchContainer!!.addView(getCellItem(theme))
    } // swapThemeSwatch

    /**
     * ## Creates a new MTC Pref Icon representing the 3 Main Theme Colors
     *
     * @param themeName a [String] that is the Theme Name
     *
     * @return [LinearLayout] that holds the icon view
     */
    private fun getCellItem(themeName: String?): LinearLayout {

        val tName = themeName.toString()
        val colors: IntArray = ColorUtils.getColorSet(tName, false)

        if (tName.contains(HUE_SPLITTER)) {
            // SHOULD ALWAYS BE TRUE
            val hSplit: List<String> = tName.split(HUE_SPLITTER)
            if (hSplit[0].contains(THEME_SPLITTER)) {
                val tn: List<String> = hSplit[0].split(THEME_SPLITTER)
                colors[2] = AccentColor.getColor(tn[1])
            } else {
                colors[2] = AccentColor.getColor(hSplit[0])
            }
        }

        val ll = LinearLayout(mContext)
        val rl = RelativeLayout(mContext)

        val llParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        ll.layoutParams = llParams
        ll.orientation = LinearLayout.VERTICAL
        ll.gravity = Gravity.CENTER

        val rlParams = RelativeLayout.LayoutParams(pToDp(45), pToDp(45))
        rl.layoutParams = rlParams

        val bottomCircle = ImageView(mContext)
        val middleCircle = ImageView(mContext)
        val topCircle = ImageView(mContext)

        val bottomCircleParams = RelativeLayout.LayoutParams(pToDp(22), pToDp(22))
        val middleCircleParams = RelativeLayout.LayoutParams(pToDp(22), pToDp(22))
        val topCircleParams = RelativeLayout.LayoutParams(pToDp(22), pToDp(22))

        bottomCircle.layoutParams = bottomCircleParams
        middleCircle.layoutParams = middleCircleParams
        topCircle.layoutParams = topCircleParams

        bottomCircle.setImageDrawable(ResourcesCompat.getDrawable(mCtx.resources, R.drawable.themechooser_shape_circle, null))
        middleCircle.setImageDrawable(ResourcesCompat.getDrawable(mCtx.resources, R.drawable.themechooser_shape_circle, null))
        topCircle.setImageDrawable(ResourcesCompat.getDrawable(mCtx.resources, R.drawable.themechooser_shape_circle, null))

        bottomCircle.setColorFilter(colors[2], PorterDuff.Mode.MULTIPLY)
        middleCircle.setColorFilter(colors[0], PorterDuff.Mode.MULTIPLY)
        topCircle.setColorFilter(colors[1], PorterDuff.Mode.MULTIPLY)

        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        bottomCircleParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)

        middleCircleParams.addRule(RelativeLayout.CENTER_IN_PARENT)

        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        topCircleParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)

        rl.addView(bottomCircle)
        rl.addView(middleCircle)
        rl.addView(topCircle)
        ll.addView(rl)

        return ll
    } // getCellItem

    /**
     * ## Converts Pixels to DensityPixels
     *
     * @param p an [Int] in pixels
     *
     * @return [Int] the density pixel value
     */
    private fun pToDp(p: Int): Int {
        return (p * getDensityScale() + 0.5f).toInt()
    } // pToDp

} // Class
