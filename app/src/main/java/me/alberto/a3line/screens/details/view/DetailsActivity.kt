package me.alberto.a3line.screens.details.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.theartofdev.edmodo.cropper.CropImage
import me.alberto.a3line.App
import me.alberto.a3line.R
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.databinding.ActivityDetailsBinding
import me.alberto.a3line.screens.details.viewmodel.DetailsViewModel
import me.alberto.a3line.util.extension.loadImageFromUrl
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val user: User? by lazy { intent?.getParcelableExtra(User.USER_KEY) }

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: DetailsViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setupViews()
        setContentView(binding.root)
        setClickListeners()
        setObservers()

    }

    private fun setObservers() {
        viewModel.message.observe(this) {
            it ?: return@observe
            showMessage(it)
        }
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun setClickListeners() {
        binding.camera.setOnClickListener { CropImage.activity().setAspectRatio(1, 1).start(this) }
    }

    private fun setupViews() {
        binding.dToolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.back_icon)
        binding.dToolbar.setNavigationOnClickListener { onBackPressed() }
        user?.let {
            binding.user = user
            binding.header.setCardBackgroundColor(it.color)
            binding.dToolbar.setBackgroundColor(it.color)
            binding.profileImg.loadImageFromUrl(user?.photoUrl)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE
            && resultCode == Activity.RESULT_OK
            && data != null
        ) {
            val imageUrl = CropImage.getActivityResult(data).uri.toString()
            binding.profileImg.loadImageFromUrl(imageUrl)
            user?.let {
                it.photoUrl = imageUrl
                viewModel.updateUser(it)
            }


        }
    }
}