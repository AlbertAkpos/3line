package me.alberto.a3line.data.remote.model

import com.google.gson.annotations.SerializedName

data class CompanyDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("bs")
    val bs: String
)