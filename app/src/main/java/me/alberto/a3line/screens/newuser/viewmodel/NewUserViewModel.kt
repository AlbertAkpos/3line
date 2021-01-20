package me.alberto.a3line.screens.newuser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.alberto.a3line.data.domain.model.Address
import me.alberto.a3line.data.domain.model.Company
import me.alberto.a3line.data.domain.model.Geo
import me.alberto.a3line.data.domain.model.User
import me.alberto.a3line.data.domain.repository.IRepository
import me.alberto.a3line.util.getRandomColor
import javax.inject.Inject

class NewUserViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {

    val name = MutableLiveData<String>()
    val username = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val address = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()
    val photoUrl = MutableLiveData<String>()

    val nameError = MutableLiveData<String>()
    val usernameError = MutableLiveData<String>()
    val emailError = MutableLiveData<String>()
    val addressError = MutableLiveData<String>()
    val phoneNumberError = MutableLiveData<String>()
    val companyError = MutableLiveData<String>()
    val photoUrlError = MutableLiveData<String>()

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success


    private fun isValid(): Boolean {
        if (!name.value.isNullOrEmpty() &&
            !username.value.isNullOrEmpty() &&
            !email.value.isNullOrEmpty() &&
            !company.value.isNullOrEmpty() &&
            !address.value.isNullOrEmpty() &&
            !phoneNumber.value.isNullOrEmpty() &&
            !photoUrl.value.isNullOrEmpty()
        ) {
            return true
        }

        if (name.value.isNullOrEmpty()) nameError.postValue("Name is empty")
        if (username.value.isNullOrEmpty()) usernameError.postValue("Username is empty")
        if (email.value.isNullOrEmpty()) emailError.postValue("Email is empty")
        if (address.value.isNullOrEmpty()) addressError.postValue("Address is empty")
        if (phoneNumber.value.isNullOrEmpty()) phoneNumberError.postValue("Phone number is empty")
        if (photoUrl.value.isNullOrEmpty()) photoUrlError.postValue("Please pick an image")
        if (company.value.isNullOrEmpty()) companyError.postValue("Company name is empty")

        return false
    }


    fun addUser() {
        if (isValid()) {
            //Essentially, google places api should be used to get user location, But time won't allow to add that
            val geo = Geo(0.0, 0.0)
            val address = Address(this.address.value.toString(), "", "", "", geo)
            val company = Company(this.company.value.toString(), "", "")
            val user = User(
                0,
                name = name.value.toString(),
                photoUrl = photoUrl.value.toString(),
                username = username.value.toString(),
                email = email.value.toString(),
                address = address,
                color = getRandomColor(),
                company = company,
                phone = phoneNumber.value.toString(),
                website = ""
            )
            viewModelScope.launch {
                try {
                    repository.addUser(user)
                    _success.postValue(true)
                } catch (exp: Exception) {
                }
            }

        }
    }

    fun setPhotoUrl(string: String) {
        photoUrl.postValue(string)
    }


}