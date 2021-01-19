package me.alberto.a3line.data.local.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.alberto.a3line.data.domain.model.Address
import me.alberto.a3line.data.domain.model.Company

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun fromAddress(address: Address): String {
        val type = object : TypeToken<Address>(){}.type
        return gson.toJson(address, type)
    }

    @TypeConverter
    fun toAddress(address: String): Address {
        val type = object : TypeToken<Address>(){}.type
        return gson.fromJson(address, type)
    }

    @TypeConverter
    fun fromCompany(company: Company): String {
        val type = object : TypeToken<Company>(){}.type
        return gson.toJson(company, type)
    }
}