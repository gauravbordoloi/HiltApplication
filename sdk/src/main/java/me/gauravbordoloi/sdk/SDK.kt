package me.gauravbordoloi.sdk

import android.content.Context
import me.gauravbordoloi.sdk.user.UserApi
import me.gauravbordoloi.sdk.user.UserApiImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SDK {

    @Inject
    lateinit var userApiImpl: UserApiImpl

    companion object {
        private var sdk: SDK? = null

        @JvmStatic
        fun getInstance(): SDK {
            if (sdk == null) {
                sdk = SDK()
            }
            return sdk!!
        }
    }

    fun init(context: Context) {
        DaggerSdkComponent.builder().context(context).build().inject(this)
    }

    fun getUserApi(): UserApi {
        return userApiImpl
    }

}