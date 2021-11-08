package me.gauravbordoloi.sdk


import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.gauravbordoloi.sdk.network.NetworkModule
import me.gauravbordoloi.sdk.user.UserModule
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, UserModule::class])
@Singleton
interface SdkComponent {

    fun inject(sdk: SDK)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun build(): SdkComponent
    }

}
