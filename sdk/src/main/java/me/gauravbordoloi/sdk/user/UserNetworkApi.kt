package me.gauravbordoloi.sdk.user

import me.gauravbordoloi.sdk.network.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserNetworkApi {

    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): BaseResponse<List<User>>

}