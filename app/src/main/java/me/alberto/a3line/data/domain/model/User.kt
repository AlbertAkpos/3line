package me.alberto.a3line.data.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class User(
    val id: Long,
    val name: String,
    var photoUrl: String?,
    val username: String,
    val email: String,
    val address: @RawValue Address,
    val phone: String,
    val website: String?,
    val company: @RawValue Company,
    val color: Int
) : Parcelable {
    companion object {
        const val USER_KEY = "user_parcelable"
    }
}
