package me.alberto.a3line.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import me.alberto.a3line.data.domain.model.Address
import me.alberto.a3line.data.domain.model.Company
import me.alberto.a3line.data.domain.model.Geo
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.data.remote.model.UserDTO
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(o: T?) {
            data = o
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }

    this.observeForever(observer)

    // Don't wait indefinitely if the LiveData is not set.
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("LiveData value was never set.")
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}


fun ArrayList<UserEntity>.updateUser(userEntity: UserEntity) {
    val toRemove = find { it.id == userEntity.id }
    toRemove?.let {
        val index = indexOf(toRemove)
        remove(toRemove)
        add(index, userEntity)
    }
}

fun UserDTO.entity(): UserEntity {
    val geo = Geo(address.geo.lat.toDouble(), address.geo.lng.toDouble())
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
        photoUrl = null,
        color = 0
    )
}