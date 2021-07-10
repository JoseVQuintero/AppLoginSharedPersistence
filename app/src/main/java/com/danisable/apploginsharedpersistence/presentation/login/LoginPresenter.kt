package com.danisable.apploginsharedpersistence.presentation.login

import android.content.Context
import com.danisable.apploginsharedpersistence.utils.Utils
import com.danisable.apploginsharedpersistence.utils.Constants


class LoginPresenter(private val context: Context, private val view: LoginActivity): LoginInteractor.Presenter{

    private val userId = "101"
    private val email = "p"
    private val password = "p"
    //login
    //evaluacion de error

    override fun validateMessage(message: String) {
        if(message.equals("")) {
            view.showMessage("Is Empty")
        }else if (!message.equals("")){
            view.showMessage("Is Valid")
        }
    }

    fun goToLogin(email: String, password: String){
        if(email.isEmpty() || password.isEmpty()){
            view.showError("Alguno de los campos es vacio")
        }else{
            //Success to login
            if(this.email == email && this.password == password){
                    Utils.setPreferencesAppData(context, Constants.PREF_IS_SESSION, userId)
                    view.onSuccess()
            }else{
                view.showMessage("The account not is valid")
            }
        }
    }

}