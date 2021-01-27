package com.hackaprende.mvpiano

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hackaprende.mvpiano.databinding.SongListItemBinding

class SongAdapter : ListAdapter<Song, SongAdapter.ViewHolder>(
    DiffCallback
) {

    companion object DiffCallback : DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private lateinit var onItemClickListener: ((earthquake: Song) -> Unit)

    fun setOnItemClickListener(onItemClickListener: (earthquake: Song) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SongListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = getItem(position)
        holder.bind(song)
    }

    inner class ViewHolder(private val binding: SongListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Song) {
            val context = binding.songNameAuthorText.context
            binding.songNameAuthorText.text = context.getString(R.string.song_name_author_format,
                song.name, song.author)

            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(song)
                }
            }
        }
    }
}