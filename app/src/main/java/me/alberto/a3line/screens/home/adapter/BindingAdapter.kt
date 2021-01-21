package me.alberto.a3line.screens.home.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import me.alberto.a3line.data.local.database.UserEntity
import me.alberto.a3line.data.mapper.toDomain

@BindingAdapter("app:users")
fun RecyclerView.setUsers(users: List<UserEntity>?) {
    users?.let {
        val adapter = adapter as UserAdapter
        val domainUsers = users.map { it.toDomain() }.sortedByDescending { it.id }
        adapter.submitList(domainUsers)
    }
}