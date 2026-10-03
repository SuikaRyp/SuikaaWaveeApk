package com.suikaawave.innertube.pages

import com.suikaawave.innertube.models.YTItem

data class LibraryContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
