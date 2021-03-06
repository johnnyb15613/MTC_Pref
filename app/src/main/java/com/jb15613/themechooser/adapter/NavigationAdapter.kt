package com.jb15613.themechooser.adapter

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.fromHtml
import androidx.recyclerview.widget.RecyclerView
import com.jb15613.themechooser.demo.MainActivity
import com.jb15613.themechooser.demo.R
import com.jb15613.themechooser.utility.*


class NavigationAdapter(private val mNavTitles: Array<String?>, private val mIcons: Array<Drawable?>, private val mContext: Context) :
    RecyclerView.Adapter<NavigationAdapter.ViewHolder>() {

    private val typeMenuHeader = 0
    private val typeSubHeader = 1
    private val typeAppItem = 2
    private val typeNavItem = 3
    private val typeAboutItem = 4
    private var selectedPosition = 0

    var d = if (mContext is MainActivity) {
        when (mContext.getNav()) {
            NAV_ITEM_HOME -> selectedPosition = 2
            NAV_ITEM_TEXT_VIEWS -> selectedPosition = 3
            NAV_ITEM_BUTTON_VIEWS -> selectedPosition = 4
            NAV_ITEM_WIDGET_VIEWS -> selectedPosition = 5
            NAV_ITEM_SPARE_PARTS -> selectedPosition = 6
            else -> {
                // panic
            }
        }
    } else {
        selectedPosition = 2
    }



    class ViewHolder(view: View?, viewType: Int) : RecyclerView.ViewHolder(view!!) {

        // clickableView
        var clickView: View? = null

        // nav_row_menu_header
        var nrHeaderBg: ImageView? = null
        var nrMenuHeader: TextView? = null
        var nrMenuHeaderBg: LinearLayout? = null

        // nav_row_sub_header
        var nrSubMenuHeader: TextView? = null

        // nav_row_app_item
        var nrAppItemIcon: ImageView? = null
        var nrAppItemTitle: TextView? = null

        // nav_row_nav_item
        var nrNavItemIcon: ImageView? = null
        var nrNavItemTitle: TextView? = null

        // nav_row_about_item
        var nrAboutItemTitle: TextView? = null

        init {
            clickView = view
            when (viewType) {
                0 -> {
                    // nav_row_menu_header
                    nrHeaderBg = view?.findViewById(R.id.nav_row_menu_header_bgImage)
                    nrMenuHeader = view?.findViewById(R.id.nav_row_menu_header_textView)
                    nrMenuHeaderBg = view?.findViewById(R.id.nav_row_menu_header_textContainer)
                }
                1 -> {
                    // nav_row_sub_header
                    nrSubMenuHeader = view?.findViewById(R.id.nav_row_sub_header)
                }
                2 -> {
                    // nav_row_app_item
                    nrAppItemIcon = view?.findViewById(R.id.nav_row_app_item_icon)
                    nrAppItemTitle = view?.findViewById(R.id.nav_row_app_item_title)
                }
                3 -> {
                    // nav_row_nav_item
                    nrNavItemIcon = view?.findViewById(R.id.nav_row_nav_item_icon)
                    nrNavItemTitle = view?.findViewById(R.id.nav_row_nav_item_title)
                }
                4 -> {
                    // nav_row_about_item
                    nrAboutItemTitle = view?.findViewById(R.id.nav_row_about_title)
                }
            } // viewType switch

        } // init

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        return ViewHolder(getLayoutInflater(viewType, viewGroup), viewType)
    }

    private fun getLayoutInflater(viewType: Int, viewGroup: ViewGroup) : View? {
        var view: View? = null
        when (viewType) {
            typeMenuHeader -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.nav_row_menu_header, viewGroup, false)
            }
            typeSubHeader -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.nav_row_sub_header, viewGroup, false)
            }
            typeAppItem -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.nav_row_app_item, viewGroup, false)
            }
            typeNavItem -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.nav_row_nav_item, viewGroup, false)
            }
            typeAboutItem -> {
                view = LayoutInflater.from(viewGroup.context).inflate(R.layout.nav_row_about_item, viewGroup, false)
            }
        }
        return view
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        when (viewHolder.itemViewType) {
            typeMenuHeader -> {
                val bg: Drawable? = ResourcesCompat.getDrawable(mContext.resources, R.mipmap.nav_item_menuheader, null)
                bg?.colorFilter = PorterDuffColorFilter(ThemeChooserUtils.getThemeColor(), PorterDuff.Mode.OVERLAY)

                viewHolder.nrHeaderBg?.background = bg
                viewHolder.nrMenuHeader?.text = APP_TITLE
                viewHolder.nrMenuHeader?.setShadowLayer(1.0F, 2.0F, 1.0F, 0xff000000.toInt())
                viewHolder.nrMenuHeaderBg?.setBackgroundColor(ThemeChooserUtils.getThemeColor(0.5f))
            }
            typeSubHeader -> {
                viewHolder.nrSubMenuHeader?.text = mNavTitles[position]
            }
            typeAppItem -> {
                viewHolder.nrAppItemTitle?.text = mNavTitles[position]
                viewHolder.nrAppItemIcon?.setImageDrawable(mIcons[position])
                viewHolder.nrAppItemIcon?.setColorFilter(ThemeChooserUtils.getPrimaryTextColor(), PorterDuff.Mode.SRC_IN)
            }
            typeNavItem -> {
                viewHolder.nrNavItemTitle?.text = mNavTitles[position]
                viewHolder.nrNavItemIcon?.setImageDrawable(mIcons[position])
                viewHolder.nrNavItemIcon?.setColorFilter(ThemeChooserUtils.getPrimaryTextColor(), PorterDuff.Mode.SRC_IN)

                if(selectedPosition == position){
                    viewHolder.itemView.setBackgroundColor(ThemeChooserUtils.getThemeDarkColor())
                }else{
                    viewHolder.itemView.setBackgroundColor(ThemeChooserUtils.getSecondaryBgColor())
                }

            }
            typeAboutItem -> {
                val span: Spanned = fromHtml(mNavTitles[position].toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
                viewHolder.nrAboutItemTitle?.setText(span, TextView.BufferType.SPANNABLE)
            }
        } // viewTypeSwitch

        when (viewHolder.itemViewType) {
            typeNavItem, typeAppItem -> setClickListener(viewHolder, position)
        }

    } // onBindViewHolder

    private fun setClickListener(viewHolder: ViewHolder, position: Int) {
        viewHolder.clickView?.setOnClickListener {

            if (mNavTitles[position].equals(NAV_ITEM_SETTINGS)) {
                if (mContext is MainActivity) {
                    mContext.showSettingsFragment()
                }
            }

            if (mNavTitles[position].equals(NAV_ITEM_LOG)) {
                if (mContext is MainActivity) {
                    mContext.showSnackBar("No Sense Sending A Log For A Demo App!!")
                }
            }

            if (mNavTitles[position].equals(NAV_ITEM_UPDATE)) {
                if (mContext is MainActivity) {
                    mContext.showSnackBar("That is just for show!!")
                }
            }

            if (isPositionNavItem(position)) {
                notifyItemChanged(selectedPosition)
                selectedPosition = position
                notifyItemChanged(selectedPosition)
                // save position to prefs, then reload it from prefs in activity
                if (mContext is MainActivity) {
                    mContext.swapActivityFragment(mNavTitles[position].toString())
                }
            }
            if (mContext is MainActivity) {
                mContext.closeNavDrawer()
            }

        }
    } // setClickListener

    override fun getItemCount() = mNavTitles.size

    override fun getItemViewType(position: Int): Int {
        if (isPositionMenuHeader(position)) {
            return typeMenuHeader
        }
        if (isPositionSubMenuHeader(position)) {
            return typeSubHeader
        }
        if (isPositionNavItem(position)) {
            return typeNavItem
        }
        if (isPositionAppItem(position)) {
            return typeAppItem
        }
        if (isPositionAboutItem(position)) {
            return typeAboutItem
        }
        return super.getItemViewType(position)
    } // getItemViewType

    private fun isPositionMenuHeader(position: Int): Boolean {
        return position == 0
    } // isPositionMenuHeader

    private fun isPositionSubMenuHeader(position: Int): Boolean {
        val title = mNavTitles[position]
        return title == NAV_ITEM_OPTIONS || title == NAV_ITEM_NAV
    } // isPositionSubMenuHeader

    private fun isPositionNavItem(position: Int): Boolean {
        val title = mNavTitles[position]
        return title == NAV_ITEM_HOME || title == NAV_ITEM_SPARE_PARTS || title == NAV_ITEM_TEXT_VIEWS || title == NAV_ITEM_BUTTON_VIEWS || title == NAV_ITEM_WIDGET_VIEWS
    } // isPositionNavItem

    private fun isPositionAppItem(position: Int): Boolean {
        val title = mNavTitles[position]
        return title == NAV_ITEM_SETTINGS || title == NAV_ITEM_LOG || title == NAV_ITEM_UPDATE
    } // isPositionAppItem

    private fun isPositionAboutItem(position: Int): Boolean {
        val title = mNavTitles[position]
        return (title != NAV_ITEM_NAV
                && title != NAV_ITEM_HOME
                && title != NAV_ITEM_SPARE_PARTS
                && title != NAV_ITEM_TEXT_VIEWS
                && title != NAV_ITEM_BUTTON_VIEWS
                && title != NAV_ITEM_WIDGET_VIEWS
                && title != NAV_ITEM_OPTIONS
                && title != NAV_ITEM_SETTINGS
                && title != NAV_ITEM_LOG
                && title != NAV_ITEM_UPDATE)
    } // isPositionAboutItem

} // class