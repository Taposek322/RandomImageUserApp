package com.taposek322.randomuserimage.domain.repository

import com.taposek322.randomuserimage.domain.utils.Resource

interface RemoteImageInteractor {
    suspend fun getImageLink(): Resource<String>
}