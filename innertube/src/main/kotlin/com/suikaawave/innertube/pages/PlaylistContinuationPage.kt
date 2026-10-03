package com.suikaawave.innertube.pages

import com.suikaawave.innertube.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)
