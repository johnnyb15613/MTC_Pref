package com.jb15613.themechooser.demo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jb15613.themechooser.adapter.SparePartsAdapter

class SparePartsFragment: Fragment(R.layout.activity_spare_parts)  {

    lateinit var mArray: Array<String>
    lateinit var mAdapter: SparePartsAdapter
    lateinit var mLayoutManager: LinearLayoutManager
    lateinit var mStaggered: StaggeredGridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mArray = getAdapterData()

        val recycler: RecyclerView = view.findViewById(R.id.recyclerView)
        recycler.setHasFixedSize(true)

        mAdapter = SparePartsAdapter(mArray, requireActivity())
        mLayoutManager = LinearLayoutManager(requireContext())
        mStaggered = StaggeredGridLayoutManager(3, 1)

        recycler.layoutManager = mStaggered
        recycler.adapter = mAdapter

    } // onViewCreated

    fun getAdapterData(): Array<String> {
        return arrayOf("Amber", "Blue", "Blue Grey", "Brown", "Cyan", "Deep Orange", "Deep Purple", "Green", "Grey",
                        "Indigo", "Light Blue", "Light Green", "Lime", "Orange", "Pink", "Purple", "Red", "Teal", "Yellow")
    }

} // Fragment