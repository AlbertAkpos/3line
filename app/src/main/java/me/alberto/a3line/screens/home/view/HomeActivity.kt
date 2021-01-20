package me.alberto.a3line.screens.home.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import me.alberto.a3line.App
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.databinding.ActivityHomeBinding
import me.alberto.a3line.screens.home.adapter.UserAdapter
import me.alberto.a3line.screens.home.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by viewModels { factory }
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        binding.userList.adapter = UserAdapter{ navigateToDetails(it) }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun navigateToDetails(user: User) {
        
    }
}