package com.ingic.template.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ingic.template.R
import com.ingic.template.interfaces.OnViewHolderClick
import com.ingic.template.ui.adapters.abstracts.RecyclerViewListAdapter

class SideMenuAdapter(context: Context, listener: OnViewHolderClick) : RecyclerViewListAdapter<String>(context, listener) {

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun createView(context: Context?, viewGroup: ViewGroup?, viewType: Int): View {
        return inflater.inflate(R.layout.item_sidemenu, viewGroup, false)
    }

    override fun bindView(item: String?, viewHolder: RecyclerviewViewHolder?) {
        val title: TextView = viewHolder?.getView(R.id.titleTextView) as TextView
        val image: ImageView = viewHolder.getView(R.id.addImage) as ImageView
        val itemValue = item ?: ""
        if (itemValue.toLowerCase().contains("about") || (itemValue.toLowerCase().contains("setting"))) {
            image.visibility = View.VISIBLE
        } else {
            image.visibility = View.INVISIBLE
        }
        title.text = itemValue
    }

    override fun bindItemViewType(position: Int): Int {
        return position
    }

    override fun bindItemId(position: Int): Int {
        return position
    }

}
