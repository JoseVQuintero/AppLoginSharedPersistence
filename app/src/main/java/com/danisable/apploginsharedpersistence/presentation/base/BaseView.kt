package com.danisable.apploginsharedpersistence.presentation.base

interface BaseView {
    fun showError(msg:String)
    fun showMessage(message: String)
    fun showResult()
}