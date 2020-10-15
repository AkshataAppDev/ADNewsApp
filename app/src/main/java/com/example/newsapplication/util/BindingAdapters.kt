package com.example.newsapplication.util

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapplication.R
import com.example.newsapplication.adapters.NewsAdapter
import com.example.newsapplication.network.NewsAPIStatus
import com.example.newsapplication.network.NewsItem


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<NewsItem>?) {

//    using binding adapter automatically observes live data for news items list
    val adapter = recyclerView.adapter as NewsAdapter
    if(data != null) {
        adapter.submitList(data)
    }
}

@BindingAdapter("urlToImage")
fun bindImage(imgView: ImageView, imgUrl: String?) {

    // Use of Glide library for efficiently downloading and displaying images in imageview.
    imgUrl?.let {
        val imageUri = imgUrl.toUri().buildUpon().scheme("https").build()

        //TODO : Use Glide dependency here.
        Glide.with(imgView.context)
            .load(imageUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}

@BindingAdapter("newsApiStatus")
fun bindStatus(statusImageView: ImageView, status: NewsAPIStatus) {

    // to show status to user in case of data being downloaded/ offline/ error
    when (status) {
        NewsAPIStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        NewsAPIStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }

        NewsAPIStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_broken_image)
        }
    }
}