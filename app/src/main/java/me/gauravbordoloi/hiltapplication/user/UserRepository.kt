package me.gauravbordoloi.hiltapplication.user

import me.gauravbordoloi.sdk.SDK
import me.gauravbordoloi.sdk.user.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val sdk: SDK) {

    private val userApi by lazy { sdk.getUserApi() }

    suspend fun getUsers(page: Int): List<User>? {
        return try {
            userApi.getUsers(page).data
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}