package me.gauravbordoloi.hiltapplication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.gauravbordoloi.sdk.SDK
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object SdkModule {

    @Singleton
    @Provides
    fun provideSdk(): SDK {
        return SDK.getInstance()
    }

}