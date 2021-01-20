package me.alberto.a3line.screens.newuser.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.theartofdev.edmodo.cropper.CropImage
import me.alberto.a3line.App
import me.alberto.a3line.R
import me.alberto.a3line.databinding.ActivityNewUserBinding
import me.alberto.a3line.screens.newuser.viewmodel.NewUserViewModel
import me.alberto.a3line.util.extension.hideKeyboard
import me.alberto.a3line.util.extension.loadImageFromUrl
import me.alberto.a3line.util.extension.removeError
import javax.inject.Inject

class NewUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewUserBinding

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel: NewUserViewModel by viewModels { factory }
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.photoUrlError.observe(this) {
            it ?: return@observe
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        viewModel.success.observe(this) {
            it ?: return@observe
            if (it == true) {
                showMessage(getString(R.string.save_msg))
                finish()
            }
        }
    }

    private fun showMessage(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
    }


    private fun setup() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        //Toolbar
        binding.toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.back_icon)
        binding.toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.nameField.addTextChangedListener { binding.nameInput.removeError() }
        binding.usernameField.addTextChangedListener { binding.usernameInput.removeError() }
        binding.emailField.addTextChangedListener { binding.emailInput.removeError() }
        binding.addressField.addTextChangedListener { binding.addressInput.removeError() }
        binding.companyField.addTextChangedListener { binding.companyInput.removeError() }
        binding.phoneNumberField.addTextChangedListener { binding.phoneNumberInput.removeError() }
        binding.saveUser.setOnClickListener {
            viewModel.addUser()
            binding.root.hideKeyboard()
        }

        binding.camera.setOnClickListener { CropImage.activity().setAspectRatio(1, 1).start(this) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE
            && resultCode == Activity.RESULT_OK
            && data != null
        ) {
            val imageUrl = CropImage.getActivityResult(data).uri.toString()
            binding.profileImg.loadImageFromUrl(imageUrl)
            viewModel.setPhotoUrl(imageUrl)
        }
    }
}