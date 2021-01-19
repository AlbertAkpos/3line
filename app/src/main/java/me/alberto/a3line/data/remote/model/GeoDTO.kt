package me.alberto.a3line.data.remote.model

import com.google.gson.annotations.SerializedName

data class GeoDTO(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)
