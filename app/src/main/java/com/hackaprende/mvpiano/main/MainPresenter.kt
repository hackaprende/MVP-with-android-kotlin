package com.hackaprende.mvpiano.main

class MainPresenter(private val mainView: MainContract.View,
                    private val mainApi: MainContract.Api) : MainContract.Presenter {
    override fun getSongs() {
        mainApi.downloadSongs({
            songList ->
            mainView.showSongs(songList)
        }, {
            errorMessage ->
            mainView.showError(errorMessage)
        })
    }
}