package me.gauravbordoloi.sdk.user

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.gauravbordoloi.sdk.network.RetrofitStore
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UserModule {

    @Provides
    @Singleton
    fun provideUserModule(@RetrofitStore retrofit: Retrofit): UserNetworkApi {
        return retrofit.create(UserNetworkApi::class.java)
    }

}