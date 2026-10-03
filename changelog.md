---v13.7.0
# KMP status update
SuikaaWave-KMP remains in alpha, but tester feedback has been very positive. To try it, join our Discord and donate at least $1 to support development.

## Highlights
- Migrated networking to InnerTubeX with automatic client fallback (@mangyaanz)
- Reduced memory use and background work in large libraries, History, Cache, Android Auto, and audio processing (@makro17 @mangyaanz)
- Repaired older-version upgrades, Android Auto browsing, artist metadata, and YouTube channel switching (@mangyaanz)
- Improved login, account loading, uploads, downloads, caching, metadata editing, and playlist sync (@mangyaanz)
- Restored the classic app icon (@mangyaanz)

## New features
- Choose whether songs are added to the start or end of playlists (@mangyaanz)
- Added Zemer lyrics for Jewish music (@mangyaanz)
- Added detailed, copyable playback error reports (@mangyaanz)
- Added a unified update prompt for standalone and KMP releases (@mangyaanz)
- Added Inception AI models and improved lyric translation output (@mangyaanz)
- Restored universal x86 and x86_64 support (@mangyaanz)

## Fixes and improvements
- Fixed missing or cropped artwork and improved timed and Cyrillic lyrics (@RizkLee @GameOn223 @Cocoa2219 @mangyaanz)
- Preserved manual metadata edits during refreshes and corrected Cache Playlist contents (@mangyaanz)
- Fixed repeat and shuffle with crossfade, Listen Together stutter, and paused queues restarting at the end (@mangyaanz)
- Fixed per-song volume normalization and improved playback recovery (@mangyaanz)
- Fixed dismissed media controls reappearing and several startup crashes (@mangyaanz)
- Protected local likes from incomplete sync responses and improved uploaded-song handling (@mangyaanz)
- Updated dependencies and CI (@mangyaanz)

New contributors: @RizkLee (#4277), @GameOn223 (#4269), and @makro17 (#4270)

**Full changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.6.3...v13.7.0

---v13.6.3

This is a hotfix release to fix borked lyrics and media controller. We apologize for the inconvenience.  

~ SuikaaWaveGroup

---v13.6.2
# THE FUTURE OF SUIKAAWAVE
SuikaaWave KMP is almost ready. We are ironing out the remaining bugs and preparing for release, but it is still at least a couple of weeks away.

# Major changes
- Fixed playback issues caused by changes that also broke official apps (@mangyaanz)
- Fixed playlist sync duplication and out-of-memory crashes (@mangyaanz)
- Improved automatic player configuration updates for future YouTube changes (@suikaalyangpratasa @mangyaanz)

## Notable new features
- Added handling for KMP updates and migrations (@mangyaanz)

## Other improvements
- Improved Android Auto voice search matching and radio queue generation (@FireLion137)
- Added an Android Auto search limit and optimized local searches to prevent out-of-memory crashes (@FireLion137)
- Fixed podcast playback errors (@mangyaanz)
- Fixed crossfade timing at non-default playback speeds (@mangyaanz)
- Fixed the app lingering in the background after it was closed (@mangyaanz)
- Fixed sleep timer dialog layouts and menus containing long translated text (@mangyaanz)
- Fixed the persistent shuffle setting not working (@SimoneFelici)
- Dimmed the repeat button when repeat is disabled (@arpitagarwal1301)
- Rounded the corners of exported lyrics images (@arpitagarwal1301)
- Updated dependencies (@mangyaanz)

## New Contributors
* @SimoneFelici made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/4102
* @arpitagarwal1301 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/4178

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.6.1...v13.6.2

---v13.6.1
# THE FUTURE OF SUIKAAWAVE
The new Kotlin Multiplatform version of SuikaaWave is now in a good state, and we are aiming to release it within the next month. Until then, the current app will remain in maintenance mode and receive bug fixes and minor improvements.

# Major changes
- Improved playback reliability and recovery from YouTube player failures (@mangyaanz @mangyaanz @mangyaanz @suikaalyangpratasa @mangyaanz)
- Fixed black screens, startup crashes, and playback freezes (@mangyaanz @suikaalyangpratasa @mangyaanz)
- Improved Listen Together synchronization (@mangyaanz)

## Notable new features
- Added refreshed branding and an optional dynamic app icon (@suikaalyangpratasa)
- Added predictive back support and improved landscape scaling (@HansHolz09 @mangyaanz)

## Other improvements
- Fixed login, logout, and backup restoration issues (@suikaalyangpratasa @mangyaanz @mangyaanz)
- Fixed incorrect artist names, song durations, podcast metadata, and missing artwork (@mangyaanz @mangyaanz @suikaalyangpratasa @mangyaanz)
- Fixed Android Auto freezes and playback delays (@mangyaanz)
- Fixed foreground service ANRs and multiple other crashes (@mangyaanz @suikaalyangpratasa)
- Fixed sleep timer crashes and restored saved defaults (@mangyaanz @suikaalyangpratasa)
- Improved library sync performance and YouTube player compatibility (@suikaalyangpratasa @mangyaanz)

## New Contributors
* @HansHolz09 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3837

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.6.0...v13.6.1

---v13.5.0
# MAINTENANCE MODE
SuikaaWave is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Rewrote the Discord RPC integration again (@mangyaanz @mangyaanz)
- Fixed random playback issues and pauses (@DanielSchmerber @isotjs)
- Fixed liked songs, playlists, albums, search results, etc. not displaying properly (@mangyaanz @mangyaanz)

## Notable new features
- Added a toggle for automatic radio queue generation (@FireLion137)
- Added automatic tablet UI scaling (@mangyaanz)
- Toggle from repeat(1) to repeat(all) after song change (@sunjeetkajla)

## Other improvements
- Fixe covers not loading sometimes (@Arjuanto)
- Artist names are now split properly, and are now clickable (@mangyaanz)
- Fixed multiple crashes (@mangyaanz @mangyaanz)
- Improved audio normalization (@mangyaanz)
- Fixed search results not being combined properly (@mangyaanz)
- Fixed 'High quality' option not choosing the highest quality option (@mangyaanz)
- Fixed history sync not working (@mangyaanz)

## New Contributors
- @DanielSchmerber made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3777
- @Arjuanto made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3780

---v13.4.3
# MAINTENANCE MODE
SuikaaWave is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Rewrote the Discord RPC integration (@mangyaanz)
- Improved the look of playlist screens (@mangyaanz)
- Added a new playlist widget (@David-2765 @AntonioDionisio05)

## Notable new features
- Added proper apple music lyrics support (@mangyaanz)
- Added a normalization level selector (@Jeff0945)
- Added the ability to hide monthly/weekly most playlists (@isotjs)

## Other improvements
- Improve overall performance and stability (@mangyaanz @mangyaanz)
- Fixed devnagari lyrics not being displayed properly (@cloud-zip)
- Improve lyrics fetching speed (@mangyaanz)
- Fixed crashes and some memory leaks (@mangyaanz)
- Fixed images being low resolution for some users (@mangyaanz)
- Handle playlist paging properly (@mangyaanz)
- Multiple smaller improvements by @mangyaanz <3

## New Contributors
- @Jeff0945 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3358

---v13.4.2
# MAINTENANCE MODE
SuikaaWave is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Fixed random crashes and some memory leaks (@mangyaanz)
- Fixed issues with uploading songs to YouTube (@mangyaanz)
- Fixed playback for uploaded songs (@punkscience)

## Notable new features
- EQ screen redesign and guided AutoEQ profile import (@ndellagrotte)
- Automatically create database backups before updates (@mangyaanz)

## Other improvements
- Improved support for Android Auto (@cmeka)
- Brought back the copy lyrics button for experimental lyrics (@mangyaanz)
- Fixed the re-sync button for experimental lyrics (@mangyaanz)
- Fixed listen together not working (@mangyaanz)
- Added back support for choosing an account upon login (@mangyaanz)
- Implemented concurrent fetching, fix lyrics fetch ordering, and optimize LyricsPlus server selection (@ibratabian17)
- Corrected the play-next shuffle order (@mangyaanz)
- Improved the Android Auto icon (@ThatOneCalculator)

## New Contributors
- @ndellagrotte made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3487
- @cmeka made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3534
- @punkscience made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3517

---v13.4.1
# MAINTENANCE MODE
SuikaaWave is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

# Major changes
- Fixed cached songs showing up in the downloads playlist (@mangyaanz)
- Fixed multiple playback issues and prepared for YouTube's player changes (@suikaalyangpratasa @mangyaanz)

## Notable new features
- Added the ability to paste URLs to the search to play them directly (@mangyaanz)
- Added a search bar to the Library screen (@isotjs)
- Added a setting to bind pitch and speed together (@sasha-melech)
- Added support for Gemini voice playback (@FireLion137)
- Added an option choose the highest possible audio quality (@mangyaanz @mangyaanz)
- Added a button to create a playlist from the Library screen (@SunjeetKajla)

## Other improvements
- Moved the resync button to the lyrics menu (@mangyaanz)
- Properly reset player on IO errors (@mangyaanz)
- Multiple improvements to lyrics fetching and parsing (@mangyaanz @mangyaanz @ibratabian17)
- Made autoplay disablable from the settings (@mangyaanz)
- Fixed foreground/background service crashes (@mangyaanz)
- Fixed Play next not working (@mangyaanz)
- Properly handle database updates on download removal (@mangyaanz)
- Use lyricsplus caching to lower server load (@binimum)
- Performance optimizations (@stopper2408)
- Prefetch lyrics for the next song if currently viewing lyrics (@mangyaanz)
- Fixed multiple issues with Listen Together (@mangyaanz)
- Fixed multiple issues with the experimental lyrics (@mangyaanz)
- Fixed pause music on task clear not working (@mangyaanz)

## New Contributors
* @ibratabian17 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3474
* @sasha-melech made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3301
* @FireLion137 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3500
* @binimum made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3493
* @stopper2408 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3506
* @SunjeetKajla made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3505

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.4.0...v13.4.1
---v13.4.0
# MAINTENANCE MODE
SuikaaWave is currently in maintenance mode. This means we will only be fixing bugs and making minor improvements. Please do not submit PRs for new features or major changes, as they will not be accepted.

No, this is not an April Fools joke, even though this update is being released on April 1st.

We are working on something big for the future of SuikaaWave - this is not the end of the project.

# Major changes
- Multiple playback fixes and reliability improvements (@mangyaanz)
- Revamped the entire Lyrics engine, improving lyric accuracy and usability (@mangyaanz)
- Fixed multiple crash issues (@mangyaanz, @mangyaanz)
- Multiple improvements to Android Auto support (@andker87)
- Fixed multiple grammar and text inconsistency issues in the project (@TheRebo)

## Notable new features
- Added support for treating cached songs as offline songs (@mangyaanz)
- Added music alarm scheduling (@0xarchit)
- Added miniplayer styles (@mangyaanz)
- Added a button to copy all song lyrics to the clipboard (@mangyaanz)
- Added a time transfer feature to move listening time between songs in the stats page (@finley-webber)
- Added customization support for the AI prompt used for translations (@mangyaanz)
- Added a notification-based music recognition for the QS tile shortcut (@isotjs)

## Other improvements
- Fixed incorrect artist order for multi-artist songs (@AntonioDionisio05)
- Fixed playtime in the stats page not being fully visible (@David-2765)
- Improved radio to start seamlessly when initiated from the currently playing track (@luigiwwmf)
- Improved the UI for tablets (@mangyaanz)
- Improved the About Screen layout (@mangyaanz)
- Fixed ghost adds on playlists (@mangyaanz)
- Improved search focus and navigation behavior (@saivijaychandan)
- Added album navigation on song title click regardless of play source (@gergesh)
- Prevented UI state reset when switching apps (@suikaalyangpratasa)
- Restored the Daily Discover title in the Home screen (@suikaalyangpratasa)
- Fixed listen together audio choppiness (@mangyaanz)
- Redesigned romanization and account settings (@omardotdev)
- Improved the design of the sleep timer dialog (@mangyaanz)
- Redesigned some components to use Material 3 Expressive (@mangyaanz)
- Fixed links in the README (@Lolen10 @mangyaanz)

## New Contributors
* @AntonioDionisio05 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3255
* @David-2765 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3271
* @luigiwwmf made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3293
* @gergesh made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3300
* @Lolen10 made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3328

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.3.0...v13.3.1
---v13.3.0
# Major changes
- Implemented song upload and delete functionality (@mangyaanz)
- Multiple playback fixes and reliability improvements (@mangyaanz, @suikaalyangpratasa)
- Fixed proguard rules causing issues with Reproducible Builds (@mangyaanz)
- Fixed proguard rules removing Listen Together protobuf classes (@suikaalyangpratasa)
- Added a playlist export option to the playlist context menu (@mangyaanz)

## Notable new features
- Added a Play all action for the stats page (@isotjs)
- Added a quick settings tile for recognizing music (@mangyaanz)
- Added automatic sleep timer options and integrated fade-out volume handling (@isotjs)
- Added a profile search filter (@mangyaanz)
- Added channel subscriptions for podcasts and artists (@mangyaanz)

## Other improvements
- Fixed cached images not clearing properly and cached covers not showing when offline (@mangyaanz)
- Removed useless and stale strings from the codebase (@mangyaanz)
- Refined the song details view (@omardotdev)
- Added support for Mistral AI models (@mangyaanz)
- Redesigned the lastfm integration settings (@omardotdev)
- Fixed importing csv files crashing the app (@mangyaanz)
- Prevent guest playback while in listen together (@mangyaanz)
- Fixed podcasts not working for logged-out users (@mangyaanz)
- Updated dependencies (@mangyaanz)

## New Contributors
* @isotjs made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/3090

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.2.1...v13.3.0
---v13.2.1
>[!WARNING]
>Listen Together doesn't work in v13.2.1! Use v13.2.0 if you need it.

## Hot Fixes
- Fix interface lag issue
- Fix navigate local playlists pinned in speed dial
- Removed "cache songs only after playback has started" option

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.2.0...v13.2.1
---v13.2.0
# Major changes
- Fixed playback breaking due to YouTube's February 2026 n-transform changes (@mangyaanz)
- Added full podcast library support (@suikaalyangpratasa & @mangyaanz)
- Redesigned loading, Changelog, and About screens (@mangyaanz)
- Improved app startup time via parallelized home screen loading (@suikaalyangpratasa)

## Notable new features
- Added an option to cache songs only after playback has started (@mangyaanz)
- Added a music recognizer home screen widget (@suikaalyangpratasa)
- Rewrote music recognizer in pure Kotlin, removing NDK dependency and reducing APK size (@suikaalyangpratasa)
- Overhauled lyrics: added LyricsPlus provider, AI lyric fixes, untranslation support, and provider priority settings (@mangyaanz)
- Changed listen together to use protobuf, lowering latency and improving reliability (@mangyaanz)
- Added auto-approve setting for listen together song requests (@mangyaanz)
- Added an option to persist the sleep timer default value (@mangyaanz)
- Added a dialog on logout to keep or clear library data (@mangyaanz)

## Other improvements
- Fixed backup restore causing playback errors due to stale auth credentials (@mangyaanz)
- The CSV import dialog is now scrollable (@mangyaanz)
- Fixed Android 15 foreground service crashes (@mangyaanz)
- Fixed a crash on the About screen on some devices (@suikaalyangpratasa)
- Fixed home screen playlist navigation routing to wrong screen (@suikaalyangpratasa)
- Fixed crash when creating local playlists (@suikaalyangpratasa)

## New Contributors
* @mangyaanz made their first contribution in https://github.com/MetrolistGroup/Metrolist/pull/2991

**Full Changelog**: https://github.com/MetrolistGroup/Metrolist/compare/v13.1.1...v13.2.0
