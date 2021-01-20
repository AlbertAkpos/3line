package me.alberto.a3line.data.mapper

import me.alberto.a3line.data.domain.model.Address
import me.alberto.a3line.data.domain.model.Company
import me.alberto.a3line.data.domain.model.Geo
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.data.remote.model.UserDTO

fun UserEntity.toDomain(): User {
    return User(
        id, name, photoUrl, username, email, address, phone, website, company, color
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(id, name, username, email, address, phone, website, company, photoUrl, color)
}

fun UserDTO.toEntity(): UserEntity {
    val geo = Geo(  address.geo.lat.toDouble(), address.geo.lng.toDouble())
    val address = Address(
        street = address.street,
        city = address.city,
        suite = address.suite,
        geo = geo,
        zipcode = address.zipcode
    )
    val company = Company(company.name, company.catchPhrase, company.bs)
    return UserEntity(
        id = id,
        address = address,
        name = name,
        username = username,
        phone = phone,
        company = company,
        email = email,
        website = website,
        photoUrl = null
    )
}