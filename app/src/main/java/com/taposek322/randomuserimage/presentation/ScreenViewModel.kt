package com.taposek322.randomuserimage.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taposek322.randomuserimage.domain.repository.RemoteImageInteractor
import com.taposek322.randomuserimage.domain.utils.Resource
import com.taposek322.randomuserimage.presentation.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor(
    private val interactor: RemoteImageInteractor
): ViewModel() {
    private var _imageLink = MutableStateFlow("")
    val imageLink = _imageLink.asStateFlow()

    private var _error = MutableStateFlow<UiText?>(null)
    val error = _error.asStateFlow()


    init {
        viewModelScope.launch {
            when (val result = interactor.getImageLink()) {
                is Resource.Success -> _imageLink.update { result.data!! }
                is Resource.Error -> _error.update { result.message }
            }
        }
    }
}