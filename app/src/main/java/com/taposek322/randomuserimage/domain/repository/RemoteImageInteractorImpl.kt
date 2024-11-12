package com.taposek322.randomuserimage.domain.repository

import com.taposek322.randomuserimage.data.repository.RandomUserRepository
import com.taposek322.randomuserimage.domain.utils.Resource
import javax.inject.Inject

class RemoteImageInteractorImpl @Inject constructor(
    private val imageRepository: RandomUserRepository
): RemoteImageInteractor {
    override suspend fun getImageLink(): Resource<String> = imageRepository.getImageLink()
}