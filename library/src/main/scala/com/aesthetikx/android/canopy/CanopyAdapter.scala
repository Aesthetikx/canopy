package com.aesthetikx.android.canopy

import android.content.Context
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.BaseAdapter

class CanopyAdapter(val context: Context, var items: List[CanopyItem]) extends BaseAdapter {

  override def getCount(): Int = items.filter(item => item.isVisible).length

  override def getItemId(position: Int): Long = position

  override def getItem(position: Int): Object = items.filter(item => item.isVisible)(position)

  override def getView(position: Int, convertView: View, parent: ViewGroup): View = {
    val item = getItem(position).asInstanceOf[CanopyItem]

    val inflater = context
      .getSystemService(Context.LAYOUT_INFLATER_SERVICE)
      .asInstanceOf[LayoutInflater]

    val view: View = item.isExpanded match {
      case true => item.getExpandedView(inflater, parent)
      case false => item.getCollapsedView(inflater, parent)
    }

    view.setVisibility(if (item.isVisible) View.VISIBLE else View.GONE)

    view
  }

}
