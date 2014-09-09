package com.aesthetikx.android.canopy

import android.util.TypedValue
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.{FrameLayout, RelativeLayout}

import com.aesthetikx.android.canopy.view.CanopyRowView

import java.util.List;

import scala.collection.JavaConversions._

abstract class BaseCanopyItem(
    private var expanded: Boolean,
    private var visible: Boolean,
    private val depth: Int,
    private val children: List[CanopyItem])
    extends CanopyItem {

  // Auxiliary constructor
  def this(depth: Int, children: List[CanopyItem]) = this(true, true, depth, children)


  // Expansion

  override def setExpanded(expanded: Boolean) : Unit = {
    this.expanded = expanded
  }

  override def toggleExpanded() : Unit = {
    expanded = !expanded
  }

  override def isExpanded() : Boolean = expanded

  override def parentToggled(parentExpanded: Boolean, parentVisible: Boolean) : Unit = {
    setVisible(parentExpanded && parentVisible)
    children.toList.foreach { child => child.parentToggled(isExpanded, isVisible) }
  }


  // Visibility

  override def setVisible(visible: Boolean) : Unit = {
    this.visible = visible
  }

  override def isVisible() : Boolean = visible


  // Tree

  override def getDepth() : Integer = depth

  override def getChildCount() : Integer = {
    children.toList.foldLeft(0) { (count, child) => count + (child.getChildCount + 1) }
  }


  // Views

  private def getDefaultCanopyRowView(inflater: LayoutInflater, parent: ViewGroup): View = {
    val view: View = inflater.inflate(R.layout.canopy_row_view, parent, false)

    val fiveDpi: Integer = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, inflater.getContext.getResources.getDisplayMetrics).asInstanceOf[Integer]

    view.asInstanceOf[CanopyRowView].getSpacer.setLayoutParams(new RelativeLayout.LayoutParams(fiveDpi * getDepth, ViewGroup.LayoutParams.MATCH_PARENT))

    view
  }

  override def getExpandedView(inflater: LayoutInflater, parent: ViewGroup): View = getDefaultCanopyRowView(inflater, parent)

  override def getCollapsedView(inflater: LayoutInflater, parent: ViewGroup): View = getDefaultCanopyRowView(inflater, parent)

}
