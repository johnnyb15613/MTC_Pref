package com.jb15613.themechooser.demo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jb15613.themechooser.adapter.SparePartsAdapter
import com.jb15613.themechooser.utility.ThemeChooserUtils

class SparePartsFragment: Fragment(R.layout.activity_spare_parts)  {

    private lateinit var mRedArray: Array<String>
    private lateinit var mRedAdapter: SparePartsAdapter
    private lateinit var redRecycler: RecyclerView

    private lateinit var mPinkArray: Array<String>
    private lateinit var mPinkAdapter: SparePartsAdapter
    private lateinit var pinkRecycler: RecyclerView

    private lateinit var mPurpleArray: Array<String>
    private lateinit var mPurpleAdapter: SparePartsAdapter
    private lateinit var purpleRecycler: RecyclerView

    private lateinit var mDeepPurpleArray: Array<String>
    private lateinit var mDeepPurpleAdapter: SparePartsAdapter
    private lateinit var deepPurpleRecycler: RecyclerView

    private lateinit var mIndigoArray: Array<String>
    private lateinit var mIndigoAdapter: SparePartsAdapter
    private lateinit var indigoRecycler: RecyclerView

    private lateinit var mBlueArray: Array<String>
    private lateinit var mBlueAdapter: SparePartsAdapter
    private lateinit var blueRecycler: RecyclerView

    private lateinit var mLightBlueArray: Array<String>
    private lateinit var mLightBlueAdapter: SparePartsAdapter
    private lateinit var lightBlueRecycler: RecyclerView

    private lateinit var mCyanArray: Array<String>
    private lateinit var mCyanAdapter: SparePartsAdapter
    private lateinit var cyanRecycler: RecyclerView

    private lateinit var mTealArray: Array<String>
    private lateinit var mTealAdapter: SparePartsAdapter
    private lateinit var tealRecycler: RecyclerView

    private lateinit var mGreenArray: Array<String>
    private lateinit var mGreenAdapter: SparePartsAdapter
    private lateinit var greenRecycler: RecyclerView

    private lateinit var mLightGreenArray: Array<String>
    private lateinit var mLightGreenAdapter: SparePartsAdapter
    private lateinit var lightGreenRecycler: RecyclerView

    private lateinit var mLimeArray: Array<String>
    private lateinit var mLimeAdapter: SparePartsAdapter
    private lateinit var limeRecycler: RecyclerView

    private lateinit var mYellowArray: Array<String>
    private lateinit var mYellowAdapter: SparePartsAdapter
    private lateinit var yellowRecycler: RecyclerView

    private lateinit var mAmberArray: Array<String>
    private lateinit var mAmberAdapter: SparePartsAdapter
    private lateinit var amberRecycler: RecyclerView

    private lateinit var mOrangeArray: Array<String>
    private lateinit var mOrangeAdapter: SparePartsAdapter
    private lateinit var orangeRecycler: RecyclerView

    private lateinit var mDeepOrangeArray: Array<String>
    private lateinit var mDeepOrangeAdapter: SparePartsAdapter
    private lateinit var deepOrangeRecycler: RecyclerView

    private lateinit var mBrownArray: Array<String>
    private lateinit var mBrownAdapter: SparePartsAdapter
    private lateinit var brownRecycler: RecyclerView

    private lateinit var mGreyArray: Array<String>
    private lateinit var mGreyAdapter: SparePartsAdapter
    private lateinit var greyRecycler: RecyclerView

    private lateinit var mBlueGreyArray: Array<String>
    private lateinit var mBlueGreyAdapter: SparePartsAdapter
    private lateinit var blueGreyRecycler: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setupArrays()
        setupTextViews(view)
        setupRecyclers(view)
        setupAdapters()

    } // onViewCreated

    private fun setupArrays() {
        mRedArray = getAdapterData("Red")
        mPinkArray = getAdapterData("Pink")
        mPurpleArray = getAdapterData("Purple")
        mDeepPurpleArray = getAdapterData("Deep Purple")
        mIndigoArray = getAdapterData("Indigo")
        mBlueArray = getAdapterData("Blue")
        mLightBlueArray = getAdapterData("Light Blue")
        mCyanArray = getAdapterData("Cyan")
        mTealArray = getAdapterData("Teal")
        mGreenArray = getAdapterData("Green")
        mLightGreenArray = getAdapterData("Light Green")
        mLimeArray = getAdapterData("Lime")
        mYellowArray = getAdapterData("Yellow")
        mAmberArray = getAdapterData("Amber")
        mOrangeArray = getAdapterData("Orange")
        mDeepOrangeArray = getAdapterData("Deep Orange")
        mBrownArray = getAdapterData("Brown")
        mGreyArray = getAdapterData("Grey")
        mBlueGreyArray = getAdapterData("Blue Grey")
    }

    private fun setupTextViews(view: View) {
        val red: TextView = view.findViewById(R.id.redText)
        red.setTextColor(ThemeChooserUtils.getColor("Red"))

        val pink: TextView = view.findViewById(R.id.pinkText)
        pink.setTextColor(ThemeChooserUtils.getColor("Pink"))

        val purple: TextView = view.findViewById(R.id.purpleText)
        purple.setTextColor(ThemeChooserUtils.getColor("Purple"))

        val deepPurple: TextView = view.findViewById(R.id.deepPurpleText)
        deepPurple.setTextColor(ThemeChooserUtils.getColor("Deep Purple"))

        val indigo: TextView = view.findViewById(R.id.indigoText)
        indigo.setTextColor(ThemeChooserUtils.getColor("Indigo"))

        val blue: TextView = view.findViewById(R.id.blueText)
        blue.setTextColor(ThemeChooserUtils.getColor("Blue"))

        val lightBlue: TextView = view.findViewById(R.id.lightBlueText)
        lightBlue.setTextColor(ThemeChooserUtils.getColor("Light Blue"))

        val cyan: TextView = view.findViewById(R.id.cyanText)
        cyan.setTextColor(ThemeChooserUtils.getColor("Cyan"))

        val teal: TextView = view.findViewById(R.id.tealText)
        teal.setTextColor(ThemeChooserUtils.getColor("Teal"))

        val green: TextView = view.findViewById(R.id.greenText)
        green.setTextColor(ThemeChooserUtils.getColor("Green"))

        val lightGreen: TextView = view.findViewById(R.id.lightGreenText)
        lightGreen.setTextColor(ThemeChooserUtils.getColor("Light Green"))

        val lime: TextView = view.findViewById(R.id.limeText)
        lime.setTextColor(ThemeChooserUtils.getColor("Lime"))

        val yellow: TextView = view.findViewById(R.id.yellowText)
        yellow.setTextColor(ThemeChooserUtils.getColor("Yellow"))

        val amber: TextView = view.findViewById(R.id.amberText)
        amber.setTextColor(ThemeChooserUtils.getColor("Amber"))

        val orange: TextView = view.findViewById(R.id.orangeText)
        orange.setTextColor(ThemeChooserUtils.getColor("Orange"))

        val deepOrange: TextView = view.findViewById(R.id.deepOrangeText)
        deepOrange.setTextColor(ThemeChooserUtils.getColor("Deep Orange"))

        val brown: TextView = view.findViewById(R.id.brownText)
        brown.setTextColor(ThemeChooserUtils.getColor("Brown"))

        val grey: TextView = view.findViewById(R.id.greyText)
        grey.setTextColor(ThemeChooserUtils.getColor("Grey"))

        val blueGrey: TextView = view.findViewById(R.id.blueGreyText)
        blueGrey.setTextColor(ThemeChooserUtils.getColor("Blue Grey"))
    }

    private fun setupRecyclers(view: View) {
        redRecycler = view.findViewById(R.id.redRecyclerView)
        redRecycler.setHasFixedSize(true)
        redRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        pinkRecycler = view.findViewById(R.id.pinkRecyclerView)
        pinkRecycler.setHasFixedSize(true)
        pinkRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        purpleRecycler = view.findViewById(R.id.purpleRecyclerView)
        purpleRecycler.setHasFixedSize(true)
        purpleRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        deepPurpleRecycler = view.findViewById(R.id.deepPurpleRecyclerView)
        deepPurpleRecycler.setHasFixedSize(true)
        deepPurpleRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        indigoRecycler = view.findViewById(R.id.indigoRecyclerView)
        indigoRecycler.setHasFixedSize(true)
        indigoRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        blueRecycler = view.findViewById(R.id.blueRecyclerView)
        blueRecycler.setHasFixedSize(true)
        blueRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        lightBlueRecycler = view.findViewById(R.id.lightBlueRecyclerView)
        lightBlueRecycler.setHasFixedSize(true)
        lightBlueRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        cyanRecycler = view.findViewById(R.id.cyanRecyclerView)
        cyanRecycler.setHasFixedSize(true)
        cyanRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        tealRecycler = view.findViewById(R.id.tealRecyclerView)
        tealRecycler.setHasFixedSize(true)
        tealRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        greenRecycler = view.findViewById(R.id.greenRecyclerView)
        greenRecycler.setHasFixedSize(true)
        greenRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        lightGreenRecycler = view.findViewById(R.id.lightGreenRecyclerView)
        lightGreenRecycler.setHasFixedSize(true)
        lightGreenRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        limeRecycler = view.findViewById(R.id.limeRecyclerView)
        limeRecycler.setHasFixedSize(true)
        limeRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        yellowRecycler = view.findViewById(R.id.yellowRecyclerView)
        yellowRecycler.setHasFixedSize(true)
        yellowRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        amberRecycler = view.findViewById(R.id.amberRecyclerView)
        amberRecycler.setHasFixedSize(true)
        amberRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        orangeRecycler = view.findViewById(R.id.orangeRecyclerView)
        orangeRecycler.setHasFixedSize(true)
        orangeRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        deepOrangeRecycler = view.findViewById(R.id.deepOrangeRecyclerView)
        deepOrangeRecycler.setHasFixedSize(true)
        deepOrangeRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        brownRecycler = view.findViewById(R.id.brownRecyclerView)
        brownRecycler.setHasFixedSize(true)
        brownRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        greyRecycler = view.findViewById(R.id.greyRecyclerView)
        greyRecycler.setHasFixedSize(true)
        greyRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)

        blueGreyRecycler = view.findViewById(R.id.blueGreyRecyclerView)
        blueGreyRecycler.setHasFixedSize(true)
        blueGreyRecycler.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)
    }

    private fun setupAdapters() {
        mRedAdapter = SparePartsAdapter(mRedArray, requireActivity())
        redRecycler.adapter = mRedAdapter

        mPinkAdapter = SparePartsAdapter(mPinkArray, requireActivity())
        pinkRecycler.adapter = mPinkAdapter

        mPurpleAdapter = SparePartsAdapter(mPurpleArray, requireActivity())
        purpleRecycler.adapter = mPurpleAdapter

        mDeepPurpleAdapter = SparePartsAdapter(mDeepPurpleArray, requireActivity())
        deepPurpleRecycler.adapter = mDeepPurpleAdapter

        mIndigoAdapter = SparePartsAdapter(mIndigoArray, requireActivity())
        indigoRecycler.adapter = mIndigoAdapter

        mBlueAdapter = SparePartsAdapter(mBlueArray, requireActivity())
        blueRecycler.adapter = mBlueAdapter

        mLightBlueAdapter = SparePartsAdapter(mLightBlueArray, requireActivity())
        lightBlueRecycler.adapter = mLightBlueAdapter

        mCyanAdapter = SparePartsAdapter(mCyanArray, requireActivity())
        cyanRecycler.adapter = mCyanAdapter

        mTealAdapter = SparePartsAdapter(mTealArray, requireActivity())
        tealRecycler.adapter = mTealAdapter

        mGreenAdapter = SparePartsAdapter(mGreenArray, requireActivity())
        greenRecycler.adapter = mGreenAdapter

        mLightGreenAdapter = SparePartsAdapter(mLightGreenArray, requireActivity())
        lightGreenRecycler.adapter = mLightGreenAdapter

        mLimeAdapter = SparePartsAdapter(mLimeArray, requireActivity())
        limeRecycler.adapter = mLimeAdapter

        mYellowAdapter = SparePartsAdapter(mYellowArray, requireActivity())
        yellowRecycler.adapter = mYellowAdapter

        mAmberAdapter = SparePartsAdapter(mAmberArray, requireActivity())
        amberRecycler.adapter = mAmberAdapter

        mOrangeAdapter = SparePartsAdapter(mOrangeArray, requireActivity())
        orangeRecycler.adapter = mOrangeAdapter

        mDeepOrangeAdapter = SparePartsAdapter(mDeepOrangeArray, requireActivity())
        deepOrangeRecycler.adapter = mDeepOrangeAdapter

        mBrownAdapter = SparePartsAdapter(mBrownArray, requireActivity())
        brownRecycler.adapter = mBrownAdapter

        mGreyAdapter = SparePartsAdapter(mGreyArray, requireActivity())
        greyRecycler.adapter = mGreyAdapter

        mBlueGreyAdapter = SparePartsAdapter(mBlueGreyArray, requireActivity())
        blueGreyRecycler.adapter = mBlueGreyAdapter
    }

    private fun getAdapterData(themeName: String): Array<String> {
        return arrayOf(
            themeName, "$themeName & Amber", "$themeName & Amber A1", "$themeName & Amber A2", "$themeName & Amber A4", "$themeName & Amber A7",
            "$themeName & Blue", "$themeName & Blue A1", "$themeName & Blue A2", "$themeName & Blue A4", "$themeName & Blue A7",
            "$themeName & Blue Grey", "$themeName & Blue Grey 3",
            "$themeName & Brown", "$themeName & Brown 3",
            "$themeName & Cyan", "$themeName & Cyan A1", "$themeName & Cyan A2", "$themeName & Cyan A4", "$themeName & Cyan A7",
            "$themeName & Deep Orange", "$themeName & Deep Orange A1", "$themeName & Deep Orange A2", "$themeName & Deep Orange A4", "$themeName & Deep Orange A7",
            "$themeName & Deep Purple", "$themeName & Deep Purple A1", "$themeName & Deep Purple A2", "$themeName & Deep Purple A4", "$themeName & Deep Purple A7",
            "$themeName & Green", "$themeName & Green A1", "$themeName & Green A2", "$themeName & Green A4", "$themeName & Green A7",
            "$themeName & Grey", "$themeName & Grey 3",
            "$themeName & Indigo", "$themeName & Indigo A1", "$themeName & Indigo A2", "$themeName & Indigo A4", "$themeName & Indigo A7",
            "$themeName & Light Blue", "$themeName & Light Blue A1", "$themeName & Light Blue A2", "$themeName & Light Blue A4", "$themeName & Light Blue A7",
            "$themeName & Light Green", "$themeName & Light Green A1", "$themeName & Light Green A2", "$themeName & Light Green A4", "$themeName & Light Green A7",
            "$themeName & Lime", "$themeName & Lime A1", "$themeName & Lime A2", "$themeName & Lime A4", "$themeName & Lime A7",
            "$themeName & Orange", "$themeName & Orange A1", "$themeName & Orange A2", "$themeName & Orange A4", "$themeName & Orange A7",
            "$themeName & Pink", "$themeName & Pink A1", "$themeName & Pink A2", "$themeName & Pink A4", "$themeName & Pink A7",
            "$themeName & Purple", "$themeName & Purple A1", "$themeName & Purple A2", "$themeName & Purple A4", "$themeName & Purple A7",
            "$themeName & Red", "$themeName & Red A1", "$themeName & Red A2", "$themeName & Red A4", "$themeName & Red A7",
            "$themeName & Teal", "$themeName & Teal A1", "$themeName & Teal A2", "$themeName & Teal A4", "$themeName & Teal A7",
            "$themeName & Yellow", "$themeName & Yellow A1", "$themeName & Yellow A2", "$themeName & Yellow A4", "$themeName & Yellow A7")
    }

} // Fragment