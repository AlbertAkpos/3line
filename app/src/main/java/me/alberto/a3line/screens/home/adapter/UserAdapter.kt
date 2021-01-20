package me.alberto.a3line.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.databinding.UserItemBinding
import me.alberto.a3line.util.extension.loadImageFromUrl

class UserAdapter(private val clickCallback: (User) -> Unit) :
    ListAdapter<User, RecyclerView.ViewHolder>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind(getItem(position), clickCallback)
        }
    }

    class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, clickCallback: (User) -> Unit) {
            binding.user = user
            binding.decor.setBackgroundColor(user.color)
            binding.circleImageView.circleBackgroundColor = user.color
            binding.root.setOnClickListener { clickCallback(user) }
            binding.circleImageView.loadImageFromUrl(user.photoUrl)
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val view =
                    UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return UserViewHolder(view)
            }
        }
    }
}