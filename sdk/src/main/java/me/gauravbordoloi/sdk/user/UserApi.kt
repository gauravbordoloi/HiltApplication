package me.gauravbordoloi.sdk.user

import me.gauravbordoloi.sdk.network.BaseResponse

interface UserApi {

    suspend fun getUsers(page: Int): BaseResponse<List<User>>

}