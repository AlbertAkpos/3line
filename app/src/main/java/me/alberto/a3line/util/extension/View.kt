package me.alberto.a3line.util.extension

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.beGone() {
    visibility = View.GONE
}

fun View.beVisible() {
    visibility = View.VISIBLE
}

fun ImageView.loadImageFromUrl(url: String?) {
    url?.let {
        Glide.with(context)
            .load(url)
            .into(this)
    }
}