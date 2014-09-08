package com.aesthetikx.android.canopy.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.{FrameLayout, LinearLayout, RelativeLayout}

import com.aesthetikx.android.canopy.R

class CanopyRowView(
    var context: Context,
    var attrs: AttributeSet,
    var defStyleAttr: Integer)
    extends LinearLayout(context, attrs, defStyleAttr) {

  // Auxiliary Constructor
  def this(context: Context, attrs: AttributeSet) = this(context, attrs, 0)


  LayoutInflater.from(context).inflate(R.layout.canopy_row_view, this, true)

  private val spacer = findViewById(R.id.spacer).asInstanceOf[FrameLayout]
  private val colorBar = findViewById(R.id.color_bar).asInstanceOf[FrameLayout]
  private val content = findViewById(R.id.content).asInstanceOf[RelativeLayout]


  def getSpacer(): FrameLayout = spacer

  def getColorBar(): FrameLayout = colorBar

  def getContentLayout(): RelativeLayout = content

}
