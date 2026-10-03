package com.suikaawave.innertube.pages

import com.suikaawave.innertube.models.Album
import com.suikaawave.innertube.models.AlbumItem
import com.suikaawave.innertube.models.Artist
import com.suikaawave.innertube.models.ArtistItem
import com.suikaawave.innertube.models.EpisodeItem
import com.suikaawave.innertube.models.MusicResponsiveListItemRenderer
import com.suikaawave.innertube.models.PlaylistItem
import com.suikaawave.innertube.models.PodcastItem
import com.suikaawave.innertube.models.SongItem
import com.suikaawave.innertube.models.YTItem
import com.suikaawave.innertube.models.oddElements
import com.suikaawave.innertube.models.splitBySeparator
import com.suikaawave.innertube.utils.parseTime

object SearchSuggestionPage {
    fun fromMusicResponsiveListItemRenderer(renderer: MusicResponsiveListItemRenderer): YTItem? {
        return when {
            renderer.isPodcast -> {
                val secondaryLine =
                    renderer.flexColumns
                        .getOrNull(1)
                        ?.musicResponsiveListItemFlexColumnRenderer
                        ?.text
                        ?.runs
                        ?.splitBySeparator()
                PodcastItem(
                    id = renderer.navigationEndpoint?.browseEndpoint?.browseId ?: return null,
                    title =
                        renderer.flexColumns
                            .firstOrNull()
                            ?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.text ?: return null,
                    author = secondaryLine?.getOrNull(0)?.firstOrNull()?.let {
                        Artist(
                            name = it.text,
                            id = it.navigationEndpoint?.browseEndpoint?.browseId,
                        )
                    },
                    episodeCountText = secondaryLine?.lastOrNull()?.firstOrNull()?.text,
                    thumbnail = renderer.thumbnail?.getThumbnailUrl() ?: return null,
                    playEndpoint = renderer.overlay
                        ?.musicItemThumbnailOverlayRenderer
                        ?.content
                        ?.musicPlayButtonRenderer
                        ?.playNavigationEndpoint
                        ?.watchPlaylistEndpoint,
                    shuffleEndpoint = renderer.menu
                        ?.menuRenderer
                        ?.items
                        ?.find { it.menuNavigationItemRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                        ?.menuNavigationItemRenderer
                        ?.navigationEndpoint
                        ?.watchPlaylistEndpoint,
                )
            }
            renderer.isEpisode -> {
                val secondaryLine =
                    renderer.flexColumns
                        .getOrNull(1)
                        ?.musicResponsiveListItemFlexColumnRenderer
                        ?.text
                        ?.runs
                        ?.splitBySeparator()
                val firstSubtitle = secondaryLine?.getOrNull(0)?.firstOrNull()?.text
                val isUnfilteredSearch = firstSubtitle == "Episode"
                val dateIndex = if (isUnfilteredSearch) 1 else 0
                val podcastIndex = if (isUnfilteredSearch) 2 else 1
                EpisodeItem(
                    id = renderer.videoId ?: return null,
                    title =
                        renderer.flexColumns
                            .firstOrNull()
                            ?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.text ?: return null,
                    author = null,
                    podcast = secondaryLine?.getOrNull(podcastIndex)?.firstOrNull()?.takeIf {
                        it.navigationEndpoint?.browseEndpoint != null
                    }?.let {
                        Album(
                            name = it.text,
                            id = it.navigationEndpoint?.browseEndpoint?.browseId!!,
                        )
                    },
                    duration = secondaryLine?.lastOrNull()?.firstOrNull()?.text?.parseTime(),
                    publishDateText = secondaryLine?.getOrNull(dateIndex)?.firstOrNull()?.text,
                    thumbnail = renderer.thumbnail?.getThumbnailUrl() ?: return null,
                    endpoint = renderer.overlay
                        ?.musicItemThumbnailOverlayRenderer
                        ?.content
                        ?.musicPlayButtonRenderer
                        ?.playNavigationEndpoint
                        ?.watchEndpoint,
                    libraryAddToken = null,
                    libraryRemoveToken = null,
                )
            }
            renderer.isPlaylist -> {
                val secondaryLine =
                    renderer.flexColumns
                        .getOrNull(1)
                        ?.musicResponsiveListItemFlexColumnRenderer
                        ?.text
                        ?.runs
                        ?.splitBySeparator()
                PlaylistItem(
                    id = renderer.navigationEndpoint?.browseEndpoint?.browseId
                        ?.removePrefix("VL") ?: return null,
                    title =
                        renderer.flexColumns
                            .firstOrNull()
                            ?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.text ?: return null,
                    author = secondaryLine?.firstOrNull()?.firstOrNull()?.let {
                        Artist(
                            name = it.text,
                            id = it.navigationEndpoint?.browseEndpoint?.browseId,
                        )
                    } ?: return null,
                    songCountText = secondaryLine.lastOrNull()?.firstOrNull()?.text,
                    thumbnail = renderer.thumbnail?.getThumbnailUrl() ?: return null,
                    playEndpoint = renderer.overlay
                        ?.musicItemThumbnailOverlayRenderer
                        ?.content
                        ?.musicPlayButtonRenderer
                        ?.playNavigationEndpoint
                        ?.watchPlaylistEndpoint ?: return null,
                    shuffleEndpoint = renderer.menu
                        ?.menuRenderer
                        ?.items
                        ?.find { it.menuNavigationItemRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                        ?.menuNavigationItemRenderer
                        ?.navigationEndpoint
                        ?.watchPlaylistEndpoint ?: return null,
                    radioEndpoint = renderer.menu.menuRenderer.items
                        .find { it.menuNavigationItemRenderer?.icon?.iconType == "MIX" }
                        ?.menuNavigationItemRenderer
                        ?.navigationEndpoint
                        ?.watchPlaylistEndpoint ?: return null,
                )
            }
            renderer.isSong -> {
                val metadataRuns = renderer.flexColumns
                    .drop(1)
                    .flatMap { it.musicResponsiveListItemFlexColumnRenderer.text?.runs.orEmpty() }
                val artists = PageHelper.extractArtists(metadataRuns)
                SongItem(
                    id = renderer.videoId ?: return null,
                    title =
                        renderer.flexColumns
                            .firstOrNull()
                            ?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.text ?: return null,
                    artists = artists.ifEmpty { return null },
                    album =
                        renderer.flexColumns
                            .getOrNull(
                                2,
                            )?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.let {
                                Album(
                                    name = it.text,
                                    id = it.navigationEndpoint?.browseEndpoint?.browseId ?: return null,
                                )
                            },
                    duration = PageHelper.extractDuration(metadataRuns),
                    musicVideoType = renderer.musicVideoType,
                    thumbnail = renderer.thumbnail?.getThumbnailUrl() ?: return null,
                    explicit =
                        renderer.badges?.find {
                            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                        } != null,
                )
            }
            renderer.isArtist -> {
                ArtistItem(
                    id = renderer.navigationEndpoint?.browseEndpoint?.browseId ?: return null,
                    title =
                        renderer.flexColumns
                            .firstOrNull()
                            ?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.text
                            ?: return null,
                    thumbnail = renderer.thumbnail?.getThumbnailUrl() ?: return null,
                    shuffleEndpoint =
                        renderer.menu
                            ?.menuRenderer
                            ?.items
                            ?.find { it.menuNavigationItemRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                            ?.menuNavigationItemRenderer
                            ?.navigationEndpoint
                            ?.watchPlaylistEndpoint,
                    radioEndpoint =
                        renderer.menu
                            ?.menuRenderer
                            ?.items
                            ?.find { it.menuNavigationItemRenderer?.icon?.iconType == "MIX" }
                            ?.menuNavigationItemRenderer
                            ?.navigationEndpoint
                            ?.watchPlaylistEndpoint,
                )
            }
            renderer.isUserChannel -> {
                ArtistItem(
                    id = renderer.navigationEndpoint?.browseEndpoint?.browseId ?: return null,
                    title =
                        renderer.flexColumns
                            .firstOrNull()
                            ?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.text
                            ?: return null,
                    thumbnail = renderer.thumbnail?.getThumbnailUrl() ?: return null,
                    shuffleEndpoint = renderer.menu
                        ?.menuRenderer
                        ?.items
                        ?.find { it.menuNavigationItemRenderer?.icon?.iconType == "MUSIC_SHUFFLE" }
                        ?.menuNavigationItemRenderer
                        ?.navigationEndpoint
                        ?.watchPlaylistEndpoint,
                    radioEndpoint = renderer.menu
                        ?.menuRenderer
                        ?.items
                        ?.find { it.menuNavigationItemRenderer?.icon?.iconType == "MIX" }
                        ?.menuNavigationItemRenderer
                        ?.navigationEndpoint
                        ?.watchPlaylistEndpoint,
                )
            }
            renderer.isAlbum -> {
                val secondaryLine =
                    renderer.flexColumns
                        .getOrNull(1)
                        ?.musicResponsiveListItemFlexColumnRenderer
                        ?.text
                        ?.runs
                        ?.splitBySeparator() ?: return null
                AlbumItem(
                    browseId = renderer.navigationEndpoint?.browseEndpoint?.browseId ?: return null,
                    playlistId =
                        renderer.menu
                            ?.menuRenderer
                            ?.items
                            ?.find {
                                it.menuNavigationItemRenderer?.icon?.iconType == "MUSIC_SHUFFLE"
                            }?.menuNavigationItemRenderer
                            ?.navigationEndpoint
                            ?.watchPlaylistEndpoint
                            ?.playlistId ?: return null,
                    title =
                        renderer.flexColumns
                            .firstOrNull()
                            ?.musicResponsiveListItemFlexColumnRenderer
                            ?.text
                            ?.runs
                            ?.firstOrNull()
                            ?.text ?: return null,
                    artists =
                        secondaryLine.getOrNull(1)?.oddElements()?.map {
                            Artist(
                                name = it.text,
                                id = it.navigationEndpoint?.browseEndpoint?.browseId,
                            )
                        } ?: return null,
                    year =
                        secondaryLine
                            .lastOrNull()
                            ?.firstOrNull()
                            ?.text
                            ?.toIntOrNull(),
                    thumbnail = renderer.thumbnail?.getThumbnailUrl() ?: return null,
                    explicit =
                        renderer.badges?.find {
                            it.musicInlineBadgeRenderer?.icon?.iconType == "MUSIC_EXPLICIT_BADGE"
                        } != null,
                )
            }
            else -> null
        }
    }
}
