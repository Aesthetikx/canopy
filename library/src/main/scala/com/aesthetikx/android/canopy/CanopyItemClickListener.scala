package com.aesthetikx.android.canopy

import android.view.View
import android.widget.{AdapterView, BaseAdapter}

import java.util.List

class CanopyItemClickListener(private val adapter: BaseAdapter) extends AdapterView.OnItemClickListener {

  override def onItemClick(parent: AdapterView[_], view: View, position: Int, id: Long) : Unit = {
    adapter.getItem(position).asInstanceOf[CanopyItem].toggleExpanded
    adapter.notifyDataSetChanged
  }

}
