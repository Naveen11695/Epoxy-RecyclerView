package com.example.epoxy_recyclerview.helper

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView

object ImageLoader {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: RoundedImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(view.context).load(url).into(view)
        }
    }
}