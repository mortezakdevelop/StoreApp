package com.example.storeappjetpack.ui.screen.home

sealed interface HomeEffect {
    data class OpenBanner(val type: String, val link: String) : HomeEffect

    data class OpenCategory(val id: Int): HomeEffect

    data class OpenAmazing(val id: Int) : HomeEffect
    data class ShowToast(val message: String) : HomeEffect
}