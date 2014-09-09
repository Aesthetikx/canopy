package com.aesthetikx.android.canopy

import android.view.{LayoutInflater, View, ViewGroup}

trait CanopyItem {

  // Expansion

  def setExpanded(expanded: Boolean) : Unit

  def toggleExpanded() : Unit

  def isExpanded() : Boolean

  def parentToggled(parentExpanded: Boolean, parentVisible: Boolean) : Unit


  // Visibility

  def setVisible(visible: Boolean) : Unit

  def isVisible() : Boolean


  // Tree

  def getDepth() : Integer

  def getChildCount() : Integer


  // Views

  def getExpandedView(inflater: LayoutInflater, parent: ViewGroup) : View

  def getCollapsedView(inflater: LayoutInflater, parent: ViewGroup) : View

}
