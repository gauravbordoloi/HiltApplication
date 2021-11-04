package me.gauravbordoloi.sdk.user

import me.gauravbordoloi.sdk.network.BaseResponse
import javax.inject.Inject

class UserApiImpl @Inject constructor(
    private val userReceiver: UserReceiver
): UserApi {

    override suspend fun getUsers(page: Int): BaseResponse<List<User>> {
        return userReceiver.getUsers(page)
    }

}