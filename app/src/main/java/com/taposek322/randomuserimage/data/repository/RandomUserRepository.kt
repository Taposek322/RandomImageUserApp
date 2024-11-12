package com.taposek322.randomuserimage.data.repository

import com.taposek322.randomuserimage.domain.utils.Resource

interface RandomUserRepository {
    suspend fun getImageLink(): Resource<String>
}