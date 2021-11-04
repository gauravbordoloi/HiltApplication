package me.gauravbordoloi.sdk.network

import android.content.Context
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideOkHttpClientBuilder(client: OkHttpClient): OkHttpClient.Builder {
        return client.newBuilder()
            .readTimeout(30L, TimeUnit.SECONDS)
            .connectTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
    }

    @Singleton
    @Provides
    fun provideBaseOkHttpClient(chuckInterceptor: ChuckInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(chuckInterceptor)
        }.build()
    }

    @Singleton
    @Provides
    fun provideChuckInterceptor(context: Context): ChuckInterceptor {
        return ChuckInterceptor(context)
    }

    @Provides
    @RetrofitStore
    fun provideRetrofit(
        clientBuilder: OkHttpClient.Builder,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .client(clientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RetrofitStore