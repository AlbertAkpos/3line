package me.alberto.a3line.screens.home.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import me.alberto.a3line.App
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.domain.model.User.Companion.USER_KEY
import me.alberto.a3line.databinding.ActivityHomeBinding
import me.alberto.a3line.screens.details.view.DetailsActivity
import me.alberto.a3line.screens.home.adapter.UserAdapter
import me.alberto.a3line.screens.home.viewmodel.HomeViewModel
import me.alberto.a3line.util.State
import me.alberto.a3line.util.extension.beGone
import me.alberto.a3line.util.extension.beVisible
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
        startObserve()
    }

    private fun setup() {
        binding.userList.adapter = UserAdapter { navigateToDetails(it) }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun startObserve() {
        viewModel.state.observe(this) { state ->
            state ?: return@observe
            when (state) {
                is State.Loading -> {
                    binding.userList.beGone()
                    binding.progressBar.beVisible()
                }

                is State.Error -> {
                    showError(state.message)
                    binding.progressBar.beGone()
                    binding.userList.beVisible()
                }

                is State.Done -> {
                    binding.progressBar.beGone()
                    binding.userList.beVisible()
                }


            }
        }
    }

    private fun showError(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_INDEFINITE).show()
    }

    private fun navigateToDetails(user: User) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(USER_KEY, user)
        }
        startActivity(intent)
    }
}