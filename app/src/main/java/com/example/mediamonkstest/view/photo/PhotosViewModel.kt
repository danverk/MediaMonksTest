package com.example.mediamonkstest.view.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediamonkstest.domain.repository.PhotoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject


class PhotosViewModel : ViewModel() {

    val state = MutableLiveData<PhotosViewModelState>()
    val photoRepository: PhotoRepository by inject(PhotoRepository::class.java)

    fun loadPhotosByAlbumId(albumId: Int) {
        viewModelScope.launch {
            try {
                val photoList = withContext(Dispatchers.IO) {
                    photoRepository.getPhotosByAlbumId(albumId)
                }
                val photoItemList = photoList.map { PhotoItem(it.id, it.title, it.thumbnailUrl) }

                state.value = PhotosViewModelState.DataReady(photoItemList)
            } catch (e: Exception) {
                state.value = PhotosViewModelState.Error(e.message ?: "")
            }
        }
    }
}

sealed class PhotosViewModelState {
    class Error(val message: String) : PhotosViewModelState()
    class DataReady(val list: List<PhotoItem>) : PhotosViewModelState()
}
