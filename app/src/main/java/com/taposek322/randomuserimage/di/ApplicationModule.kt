package com.taposek322.randomuserimage.di

import com.taposek322.randomuserimage.data.repository.RandomUserRepository
import com.taposek322.randomuserimage.data.repository.RandomUserRepositoryImpl
import com.taposek322.randomuserimage.data.rest_api.RemoteUserApi
import com.taposek322.randomuserimage.domain.repository.RemoteImageInteractor
import com.taposek322.randomuserimage.domain.repository.RemoteImageInteractorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ApplicationModule {

    @Binds
    @Singleton
    fun bindRandomUserRepository(randomUserRepositoryImpl: RandomUserRepositoryImpl): RandomUserRepository

    @Binds
    @Singleton
    fun bindRemoteImageInteractor(remoteImageInteractorImpl: RemoteImageInteractorImpl): RemoteImageInteractor

    companion object {
        @Provides
        @IoDispatcher
        @Singleton
        fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        @Singleton
        fun provideRemoteUserApi(): RemoteUserApi = Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RemoteUserApi::class.java)
    }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher