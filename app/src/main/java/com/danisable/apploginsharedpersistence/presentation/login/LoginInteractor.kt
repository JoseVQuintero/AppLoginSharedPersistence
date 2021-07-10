package com.danisable.apploginsharedpersistence.presentation.login
import com.danisable.apploginsharedpersistence.presentation.base.BaseView

interface LoginInteractor {
    //capa de negocio
    //controler
    interface Presenter {
        fun validateMessage(message: String)
    }
    //capa de vista
    //vista
    interface View: BaseView {

    }

}