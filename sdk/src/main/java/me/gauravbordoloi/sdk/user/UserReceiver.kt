package me.gauravbordoloi.sdk.user

import me.gauravbordoloi.sdk.network.BaseResponse
import javax.inject.Inject

class UserReceiver @Inject constructor(private val userNetworkApi: UserNetworkApi) {

    suspend fun getUsers(page: Int): BaseResponse<List<User>> {
        return userNetworkApi.getUsers(page)
    }

}