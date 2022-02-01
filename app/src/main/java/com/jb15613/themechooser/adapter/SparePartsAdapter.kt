package com.jb15613.themechooser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.jb15613.themechooser.component.ChooserSwatch
import com.jb15613.themechooser.demo.MainActivity
import com.jb15613.themechooser.demo.R
import com.jb15613.themechooser.utility.NAV_ITEM_LOG
import com.jb15613.themechooser.utility.NAV_ITEM_SETTINGS
import com.jb15613.themechooser.utility.NAV_ITEM_UPDATE
import com.jb15613.themechooser.utility.ThemeChooserUtils
import java.util.*

class SparePartsAdapter(private val mThemeTitles: Array<String>, private val mContext: Context) :
    RecyclerView.Adapter<SparePartsAdapter.ViewHolder>() {

    class ViewHolder(view: View?, viewType: Int) : RecyclerView.ViewHolder(view!!) {

        var mCard: CardView? = null
        var mChooserSwatch: ChooserSwatch? = null

        init {
            mCard = view?.findViewById(R.id.cardView)
            mChooserSwatch = view?.findViewById(R.id.swatch)
        }

    } // View Holder

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        return ViewHolder(getLayoutInflater(viewType, viewGroup), viewType)
    }

    private fun getLayoutInflater(viewType: Int, viewGroup: ViewGroup): View? {
        return LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.spare_part_grid_item, viewGroup, false)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val prefs = PreferenceManager.getDefaultSharedPreferences(mContext)
        if (prefs.getBoolean("multiColoredCards", false)) {
            viewHolder.mCard?.setCardBackgroundColor(ThemeChooserUtils.getRandomThemeColor())
        }

        viewHolder.mCard?.tag = mThemeTitles[position]
        viewHolder.mCard?.setOnClickListener(cardClickListener)
        viewHolder.mCard?.setOnLongClickListener(cardLongClickListener)

        val colors = ThemeChooserUtils.getThemeColorSet(mThemeTitles[position])
        viewHolder.mChooserSwatch?.setAllCircleColors(colors)

    } // onBindViewHolder

    private var cardClickListener: View.OnClickListener = View.OnClickListener {
        val tag = it.tag.toString()
        val card = it as CardView
        val constraint = card.getChildAt(0) as ConstraintLayout
        val swatch = constraint.getChildAt(0) as ChooserSwatch
        swatch.toggleChecked()
        if (mContext is MainActivity) {
            mContext.showSnackBar(tag)
        }
    } // cardClickListener

    private var cardLongClickListener: View.OnLongClickListener = View.OnLongClickListener {
        val tag = it.tag.toString()
        if (mContext is MainActivity) {
            mContext.showCardClickDialog(tag)
        }
        return@OnLongClickListener true
    } // cardClickListener

    override fun getItemCount() = mThemeTitles.size

} // Adapter