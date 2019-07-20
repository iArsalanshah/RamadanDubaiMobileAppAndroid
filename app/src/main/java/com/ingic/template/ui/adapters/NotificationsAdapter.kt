package com.ingic.template.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ingic.template.interfaces.OnViewHolderClick
import com.ingic.template.ui.adapters.abstracts.RecyclerViewListAdapter

//Only for use case of Generic @RecyclerViewListAdapter
class NotificationsAdapter(context: Context, listener: OnViewHolderClick) : RecyclerViewListAdapter<Any>(context, listener) {

    override fun createView(context: Context, viewGroup: ViewGroup, viewType: Int): View? {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //        return inflater.inflate(R.layout.item_notifications, viewGroup, false);
        return null
    }

    override fun bindView(item: Any?, viewHolder: RecyclerViewListAdapter.RecyclerviewViewHolder) {
        if (item != null) {
            val position = viewHolder.adapterPosition
            //            ImageView imgIcon = (ImageView) viewHolder.getView(R.id.img_itemNotification);
        }
    }

    override fun bindItemViewType(position: Int): Int {
        return 0
    }

    override fun bindItemId(position: Int): Int {
        return position
    }
}
