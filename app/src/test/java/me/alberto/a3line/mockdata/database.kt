package me.alberto.a3line.mockdata

import me.alberto.a3line.data.domain.model.Address
import me.alberto.a3line.data.domain.model.Company
import me.alberto.a3line.data.domain.model.Geo
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.local.database.UserEntity

val database = arrayListOf<UserEntity>()

fun getUser(): User = User(
    23,
    "John Doe",
    "url",
    "username",
    "email",
    Address("street", "suit", "city", "10203", Geo(12.34, 23.5)),
    "019304044",
    "my website",
    Company("big name", "catch", "line"),
    0
)