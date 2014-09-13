package com.aesthetikx.android.canopy.view

import android.graphics.Color

object DefaultColorProvider extends ColorProvider {

  val colors: List[Integer] = List(
      Color.rgb(201, 94, 94),
      Color.rgb(201, 139, 94),
      Color.rgb(200, 184, 91),
      Color.rgb(143, 206, 80),
      Color.rgb(87, 199, 167),
      Color.rgb(91, 140, 200),
      Color.rgb(143, 87, 199)
    )

  override def getColor(depth: Integer): Integer = colors(depth % colors.size)

}
