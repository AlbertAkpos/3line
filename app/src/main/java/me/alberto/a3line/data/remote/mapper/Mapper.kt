package me.alberto.a3line.data.remote

import me.alberto.a3line.data.domain.model.Address
import me.alberto.a3line.data.domain.model.Company
import me.alberto.a3line.data.domain.model.Geo
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.remote.model.UserDTO

fun UserDTO.toDomain(): User {
    val geo = Geo(address.geo.lat.toLong(), address.geo.lng.toLong())
    val address = Address(
        street = address.street,
        city = address.city,
        suite = address.suite,
        geo = geo,
        zipcode = address.zipcode
    )
    val company = Company(company.name, company.catchPhrase, company.bs)
    return User(
        id = id,
        address = address,
        name = name,
        username = username,
        phone = phone,
        company = company,
        email = email,
        website = website
    )
}