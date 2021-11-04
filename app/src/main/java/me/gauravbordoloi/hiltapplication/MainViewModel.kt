package me.gauravbordoloi.hiltapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.gauravbordoloi.hiltapplication.user.UserRepository
import me.gauravbordoloi.sdk.user.User
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    private val usersLiveData = MutableLiveData<List<User>?>()

    fun getUsersLiveData(): LiveData<List<User>?> {
        return usersLiveData
    }

    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            usersLiveData.postValue(userRepository.getUsers(0))
        }
    }

}