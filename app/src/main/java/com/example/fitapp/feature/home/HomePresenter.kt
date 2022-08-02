package com.example.fitapp.feature.home

import java.lang.ref.WeakReference


class HomePresenter(view: HomeView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

}