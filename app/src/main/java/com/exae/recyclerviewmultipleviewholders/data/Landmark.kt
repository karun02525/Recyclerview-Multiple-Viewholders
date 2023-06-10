package com.exae.recyclerviewmultipleviewholders.data

import com.exae.recyclerviewmultipleviewholders.HasImage

data class Landmark(
    val title: String,
    val desc: String,
    var resource: Int?,
    val hasImage: HasImage
)