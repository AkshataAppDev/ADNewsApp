package com.example.newsapplication.util//package com.example.newsapplication
//
//import android.widget.ImageView
//import androidx.databinding.BindingAdapter
//import com.bumptech.glide.RequestManager
//import com.bumptech.glide.request.RequestOptions
//
//class ImageBindingAdapter (val requestManager: RequestManager) {
//
//    @BindingAdapter("urlToImage")
//    fun loadImage(imgView: ImageView, url: String) {
//        requestManager.load(url)
//            .into(imgView)
//            .apply {
//                RequestOptions()
//                    .error(R.drawable.ic_broken_image)
//                    .placeholder(R.drawable.loading_animation)
//            }
//    }
//}