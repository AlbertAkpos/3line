package me.alberto.a3line.util.extension

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout

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


fun TextInputLayout.removeError() {
    error = null
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}