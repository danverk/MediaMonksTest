package com.example.mediamonkstest.view.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediamonkstest.domain.repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject


class AlbumsViewModel : ViewModel() {

    val state = MutableLiveData<AlbumsViewModelState>()
    val albumRepository: AlbumRepository by inject(AlbumRepository::class.java)

    fun loadAlbums() {
        viewModelScope.launch {
            try {
                val albumList = withContext(Dispatchers.IO) {
                    albumRepository.getAlbums()
                }
                val albumItemList = albumList.map { AlbumItem(it.id, it.title) }

                state.value = AlbumsViewModelState.DataReady(albumItemList)
            } catch (e: Exception) {
                state.value = AlbumsViewModelState.Error(e.message ?: "")
            }
        }
    }
}

sealed class AlbumsViewModelState {
    class Error(val message: String) : AlbumsViewModelState()
    class DataReady(val list: List<AlbumItem>) : AlbumsViewModelState()
}
