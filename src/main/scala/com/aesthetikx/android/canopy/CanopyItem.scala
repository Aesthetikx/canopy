package com.aesthetikx.android.canopy

import android.view.{LayoutInflater, View, ViewGroup}

trait TreeListItem {

  // Expansion

  def setExpanded(expanded: Boolean) : Unit

  def toggleExpanded() : Unit

  def isExpanded() : Boolean


  // Visibility

  def setVisible(visible: Boolean) : Unit

  def isVisible() : Boolean


  // Tree

  def getDepth() : Integer

  def getChildCound() : Integer


  // Views

  def getExpandedView(inflater: LayoutInflater, parent: ViewGroup) : View

  def getCollapsedView(inflater: LayoutInflater, parent: ViewGroup) : View

}
