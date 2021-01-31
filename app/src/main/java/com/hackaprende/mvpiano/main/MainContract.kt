package com.hackaprende.mvpiano.main

import com.hackaprende.mvpiano.Song

interface MainContract {

    interface View {
        fun showSongs(songList: MutableList<Song>)
        fun showError(message: String)
    }

    interface Presenter {
        fun getSongs()
    }

    interface Api {
        fun downloadSongs(successListener: (MutableList<Song>) -> Unit,
                          errorListener: (String) -> Unit)
    }
}