package com.taposek322.randomuserimage.data.rest_api

import com.taposek322.randomuserimage.data.rest_api.respone.ApiResult
import retrofit2.http.GET

interface RemoteUserApi {
    @GET("/api/")
    suspend fun getImageLink(): ApiResult
}