package com.example.fitapp.feature.login

import java.lang.ref.WeakReference

class MainPresenter(view: MainView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

    fun onLoginBtnClicked() = view?.navigateTologin()
}