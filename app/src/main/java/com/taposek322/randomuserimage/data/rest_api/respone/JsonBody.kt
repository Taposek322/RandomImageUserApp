package com.taposek322.randomuserimage.data.rest_api.respone

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonBody(
    val picture: Picture
)