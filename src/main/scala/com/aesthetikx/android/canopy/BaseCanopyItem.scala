package com.aesthetikx.android.canopy

import java.util.List;

import scala.collection.JavaConversions._

abstract class BaseCanopyItem(
    private var expanded: Boolean,
    private var visible: Boolean,
    private val depth: Int,
    private val children: List[CanopyItem]
  ) extends CanopyItem {

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

}
