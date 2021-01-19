package me.alberto.a3line.data.remote.model

import com.google.gson.annotations.SerializedName


typealias UsersResponse = List<UserDTO>

data class UserDTO(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("address")
    val address: AddressDTO,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("company")
    val company: CompanyDTO
)