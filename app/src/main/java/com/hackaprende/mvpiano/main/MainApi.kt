package com.hackaprende.mvpiano.main

import com.hackaprende.mvpiano.Song
import kotlin.random.Random

class MainApi: MainContract.Api {

    override fun downloadSongs(successListener: (MutableList<Song>) -> Unit,
    errorListener: (String) -> Unit) {
        val random = (0..10).random()

        val songList = mutableListOf<Song>()

        songList.add(Song(1, "Für Elise", "Ludwig Van Bethoven", "Do re mi fa sol"))
        songList.add(Song(2, "Spring", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(3, "Summer", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(4, "Autumn", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(5, "Winter", "Vivaldi", "Do re mi fa sol"))
        songList.add(Song(6, "Canon in D", "Pachelbel", "Do re mi fa sol"))
        songList.add(Song(7, "Claire de lune", "Debussy", "Do re mi fa sol"))
        songList.add(Song(8, "Moonlight sonata", "Ludwig Van Bethoven", "Do re mi fa sol"))

        if (random < 3) {
            errorListener("There was an error :(")
        } else {
            successListener(songList)
        }
    }
}