package com.taposek322.randomuserimage.data.repository

import com.taposek322.randomuserimage.data.rest_api.RemoteUserApi
import com.taposek322.randomuserimage.di.IoDispatcher
import com.taposek322.randomuserimage.domain.utils.Resource
import com.taposek322.randomuserimage.presentation.utils.UiText
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomUserRepositoryImpl @Inject constructor(
    private val api: RemoteUserApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher

): RandomUserRepository {
    override suspend fun getImageLink(): Resource<String> = withContext(ioDispatcher) {
        return@withContext try {
            val data = api.getImageLink()
            Resource.Success(data = data.results.first().picture.large)
        } catch (ex: Throwable) {
            Resource.Error(UiText.DynamicString(ex.message!!))
        }
    }
}