package com.jb15613.themechooser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jb15613.themechooser.component.ChooserSwatch
import com.jb15613.themechooser.demo.R
import com.jb15613.themechooser.utility.ThemeChooserUtils

class SparePartsAdapter(private val mThemeTitles: Array<String>, private val mContext: Context) :
    RecyclerView.Adapter<SparePartsAdapter.ViewHolder>() {

    class ViewHolder(view: View?, viewType: Int) : RecyclerView.ViewHolder(view!!) {

        var mCard: CardView? = null
        var mTextView: TextView? = null
        var mChooserSwatch: ChooserSwatch? = null

        init {
            mCard = view?.findViewById(R.id.cardView)
            mTextView = view?.findViewById(R.id.title)
            mChooserSwatch = view?.findViewById(R.id.swatch)
        }

    } // View Holder

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SparePartsAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        return SparePartsAdapter.ViewHolder(getLayoutInflater(viewType, viewGroup), viewType)
    }

    private fun getLayoutInflater(viewType: Int, viewGroup: ViewGroup): View? {
        return LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.spare_part_grid_item, viewGroup, false)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: SparePartsAdapter.ViewHolder, position: Int) {

        viewHolder.mCard?.setCardBackgroundColor(ThemeChooserUtils.getRandomThemeColor())
        viewHolder.mTextView?.text = mThemeTitles[position]
        val colors = ThemeChooserUtils.getThemeColorSet(mThemeTitles[position])
        viewHolder.mChooserSwatch?.setAllCircleColors(colors)

    } // onBindViewHolder

    override fun getItemCount() = mThemeTitles.size

} // Adapter