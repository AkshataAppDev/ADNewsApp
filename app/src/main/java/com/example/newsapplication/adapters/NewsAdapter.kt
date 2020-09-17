package com.example.newsapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.databinding.ListviewItemBinding
import com.example.newsapplication.listeners.NewsItemClickListener
import com.example.newsapplication.network.NewsItem

// adapter class for recycler view of news items
// Use of databinding with recycler view to eliminate findByViewId calls.

class NewsAdapter(val clickListener: NewsItemClickListener) :
    ListAdapter<NewsItem, NewsAdapter.NewsItemViewHolder>(
        DiffCallback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder(
            ListviewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val newsItem = getItem(position)
        holder.bind(newsItem, clickListener)
    }

    class NewsItemViewHolder(private var binding: ListviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            newsItem: NewsItem,
            clickListener: NewsItemClickListener
        ) {
            binding.newsItem = newsItem
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    //Use of DiffUtil to manage differences in the old and new list when data changes
    companion object DiffCallback : DiffUtil.ItemCallback<NewsItem>() {
        override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem.title == newItem.title
        }
    }
}