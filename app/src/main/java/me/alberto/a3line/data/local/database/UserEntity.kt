package me.alberto.a3line.data.local.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.alberto.a3line.data.domain.model.Address
import me.alberto.a3line.data.domain.model.Company
import me.alberto.a3line.util.USER_TABLE
import me.alberto.a3line.util.getRandomColor

@Entity(tableName = USER_TABLE)
data class UserEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "address")
    val address: Address,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "website")
    val website: String?,
    @ColumnInfo(name = "company")
    val company: Company,
    @ColumnInfo(name = "photo_url")
    var photoUrl: String? = null,
    @ColumnInfo(name = "color")
    val color: Int = getRandomColor()
)
