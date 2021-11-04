package me.gauravbordoloi.sdk.network

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: T?
)