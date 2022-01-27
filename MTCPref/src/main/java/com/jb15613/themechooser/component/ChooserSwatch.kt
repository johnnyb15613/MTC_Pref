package com.jb15613.themechooser.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.ImageView
import com.jb15613.themechooser.mtcpref.R


class ChooserSwatch : ConstraintLayout {

    private var mAttrs: AttributeSet? = null
    private var mColorPrimary = 0
    private var mColorDark = 0
    private var mColorAccent = 0

    private lateinit var mAccentCircle: ImageView
    private lateinit var mPrimaryCircle: ImageView
    private lateinit var mDarkCircle: ImageView

    constructor(context: Context) : super(context) {
        initialize()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mAttrs = attrs
        initialize(attrs)
    } // constructor
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mAttrs = attrs
        initialize(attrs)
    } // constructor

    init {
        // LayoutInflater.from(context).inflate(R.layout.chooser_swatch_view, this, true)
    } // init

    private fun initialize(vararg attrs: AttributeSet?) {

        LayoutInflater.from(context).inflate(R.layout.chooser_swatch_view, this, true)

        mAccentCircle = findViewById(R.id.bottom_circle_image)
        mPrimaryCircle = findViewById(R.id.middle_circle_image)
        mDarkCircle = findViewById(R.id.top_circle_image)

        val arraySize = attrs.size

        if (arraySize == 0) {
            // code usage
            setColorPrimary(Color.BLUE)
            setColorDark(Color.CYAN)
            setColorAccent(Color.GREEN)
        } else {
            // xml usage

            val attributes = attrs[0]

            /*
            val ta = context.obtainStyledAttributes(attributes, R.styleable.ChooserSwatch, 0, 0)
            try {
                setColorPrimary(ta.getColor(R.styleable.ChooserSwatch_color_primary, 0))
                setColorDark(ta.getColor(R.styleable.ChooserSwatch_color_dark, 0))
                setColorAccent(ta.getColor(R.styleable.ChooserSwatch_color_accent, 0))
            } finally {
                ta.recycle()
            }
                 */

            context.theme.obtainStyledAttributes(attributes, R.styleable.ChooserSwatch, 0, 0).apply {
                try {
                    setColorPrimary(getColor(R.styleable.ChooserSwatch_color_primary, 0))
                    setColorDark(getColor(R.styleable.ChooserSwatch_color_dark, 0))
                    setColorAccent(getColor(R.styleable.ChooserSwatch_color_accent, 0))
                } finally {
                    recycle()
                }
            } // obtainStyledAttributes

        }

        mPrimaryCircle.setColorFilter(getColorPrimary(), PorterDuff.Mode.MULTIPLY)
        mDarkCircle.setColorFilter(getColorDark(), PorterDuff.Mode.MULTIPLY)
        mAccentCircle.setColorFilter(getColorAccent(), PorterDuff.Mode.MULTIPLY)

    } // initialize

    fun setPrimaryCircleColor(color: Int) {
        setColorPrimary(color)
        mPrimaryCircle.setColorFilter(getColorPrimary(), PorterDuff.Mode.MULTIPLY)
        invalidate()
    }

    fun setDarkCircleColor(color: Int) {
        setColorDark(color)
        mDarkCircle.setColorFilter(getColorDark(), PorterDuff.Mode.MULTIPLY)
        invalidate()
    }

    fun setAccentCircleColor(color: Int) {
        setColorAccent(color)
        mAccentCircle.setColorFilter(getColorAccent(), PorterDuff.Mode.MULTIPLY)
        invalidate()
    }

    fun setAllCircleColors(colors: IntArray) {
        // setColorPrimary(colors[0])
        // setColorDark(colors[1])
        // setColorAccent(colors[2])
        setPrimaryCircleColor(colors[0])
        setDarkCircleColor(colors[1])
        setAccentCircleColor(colors[2])
        // mPrimaryCircle.setColorFilter(getColorPrimary(), PorterDuff.Mode.MULTIPLY)
        // mDarkCircle.setColorFilter(getColorPrimary(), PorterDuff.Mode.MULTIPLY)
        // mAccentCircle.setColorFilter(getColorPrimary(), PorterDuff.Mode.MULTIPLY)
        // invalidate()
    }

    private fun setColorPrimary(color: Int) {
        mColorPrimary = color
    }

    private fun getColorPrimary() : Int {
        return mColorPrimary
    }

    private fun setColorDark(color: Int) {
        mColorDark = color
    }

    private fun getColorDark() : Int {
        return mColorDark
    }

    private fun setColorAccent(color: Int) {
        mColorAccent = color
    }

    private fun getColorAccent() : Int {
        return mColorAccent
    }

} // ChooserSwatch Class