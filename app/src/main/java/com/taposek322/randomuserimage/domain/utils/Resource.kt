package com.taposek322.randomuserimage.domain.utils

import com.taposek322.randomuserimage.presentation.utils.UiText

sealed class Resource<T>(val data: T? = null, val message: UiText? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: UiText?, data: T? = null) : Resource<T>(data, message)
}
