package com.example.mediamonkstest.view.photodetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediamonkstest.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject


class PhotoDetailViewModel : ViewModel() {

    val state = MutableLiveData<PhotoDetailViewModelState>()
    val photoRepository: PhotoRepository by inject(PhotoRepository::class.java)

    fun loadPhotoById(photoId: Int) {
        viewModelScope.launch {
            try {
                val photo = withContext(Dispatchers.IO) {
                    photoRepository.getPhotoById(photoId)
                }
                val photoDetailItem = PhotoDetailItem(photo.title, photo.url)

                state.value = PhotoDetailViewModelState.DataReady(photoDetailItem)
            } catch (e: Exception) {
                state.value = PhotoDetailViewModelState.Error(e.message ?: "")
            }
        }
    }
}

sealed class PhotoDetailViewModelState {
    class Error(val message: String) : PhotoDetailViewModelState()
    class DataReady(val item: PhotoDetailItem) : PhotoDetailViewModelState()
}
