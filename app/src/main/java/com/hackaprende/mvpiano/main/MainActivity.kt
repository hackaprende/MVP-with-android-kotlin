package com.hackaprende.mvpiano.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hackaprende.mvpiano.Song
import com.hackaprende.mvpiano.SongAdapter
import com.hackaprende.mvpiano.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.songRecycler
        recycler.layoutManager = LinearLayoutManager(this)
        adapter = SongAdapter()
        adapter.setOnItemClickListener {
            Toast.makeText(this, it.chords, Toast.LENGTH_SHORT).show()
        }

        recycler.adapter = adapter

        val mainPresenter = MainPresenter(this, MainApi())
        mainPresenter.getSongs()
    }

    override fun showSongs(songList: MutableList<Song>) {
        adapter.submitList(songList)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}