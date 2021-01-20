package me.alberto.a3line.data.domain.model

import java.io.Serializable

data class Company(
    val name: String,
    val catchPhrase: String?,
    val catchLine: String?
): Serializable
