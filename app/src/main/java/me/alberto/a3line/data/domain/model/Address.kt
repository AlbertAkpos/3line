package me.alberto.a3line.data.domain.model

import kotlinx.android.parcel.RawValue
import java.io.Serializable

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: @RawValue Geo?
): Serializable
