package me.alberto.a3line.screens.newuser.adapter

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:error")
fun TextInputLayout.setError(error: String?) {
    error?.let {
        if (this.error != error) {
            this.error = error
        }
    }
}