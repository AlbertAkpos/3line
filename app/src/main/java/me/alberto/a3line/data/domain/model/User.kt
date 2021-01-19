package me.alberto.a3line.data.domain.model

data class User(
    val id: Long,
    val name: String,
    val photoUrl: String?,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String?,
    val company: Company
)
