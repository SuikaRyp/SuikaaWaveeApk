package com.suikaawave.innertube.pages

import com.suikaawave.innertube.models.YTItem

data class ArtistItemsContinuationPage(
    val items: List<YTItem>,
    val continuation: String?,
)
