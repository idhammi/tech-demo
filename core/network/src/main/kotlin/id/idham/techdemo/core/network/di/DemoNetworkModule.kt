package id.idham.techdemo.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.idham.techdemo.core.network.BuildConfig
import id.idham.techdemo.core.network.endpoint.DemoApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DemoNetworkModule {

    @Provides
    @Singleton
    fun provideDemoApiService(
        moshiConverter: MoshiConverterFactory
    ): DemoApiService {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(moshiConverter)
            .build()
            .create(DemoApiService::class.java)
    }
}
