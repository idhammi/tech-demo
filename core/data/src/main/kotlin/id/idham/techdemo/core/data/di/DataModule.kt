package id.idham.techdemo.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.idham.techdemo.core.data.repository.DefaultDemoRepository
import id.idham.techdemo.core.data.repository.DemoRepository
import id.idham.techdemo.core.data.utils.ConnectivityManagerNetworkMonitor
import id.idham.techdemo.core.data.utils.NetworkMonitor

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsDemoRepository(
        repository: DefaultDemoRepository
    ): DemoRepository

    @Binds
    internal abstract fun provideNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor
    ): NetworkMonitor
}
