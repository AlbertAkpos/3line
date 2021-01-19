package me.alberto.a3line.data.remote.model

import com.google.gson.annotations.SerializedName

data class AddressDTO(
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("zipcode")
    val zipcode: String,
    @SerializedName("geo")
    val geo: GeoDTO
)
