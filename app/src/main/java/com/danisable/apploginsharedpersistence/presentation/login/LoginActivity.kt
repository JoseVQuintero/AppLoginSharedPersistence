package com.danisable.apploginsharedpersistence.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.danisable.apploginsharedpersistence.MainActivity
import com.danisable.apploginsharedpersistence.R
import com.danisable.apploginsharedpersistence.utils.Constants
import com.danisable.apploginsharedpersistence.utils.Utils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(),LoginInteractor.View{

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this,this)

        val userId = Utils.getPreferencesAppData(this, Constants.PREF_IS_SESSION)

        if(userId=="101"){
            this.showMessage("User is Login")
        }

        btnLogin.setOnClickListener {
            Log.e("TAG","Entre")
            presenter.goToLogin(edtUsuario.text.toString(),edtPassword.text.toString())
        }
    }

    override  fun onStart(){
        super.onStart()
        if(Utils.getPreferencesAppData(this, Constants.PREF_IS_SESSION)!= Constants.PREF_DEFAULT){
            goToHome()
        }
    }

    override fun showError(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

    fun onSuccess(){
        goToHome()
    }

    override fun showResult() {

    }

    private fun goToHome(){
        startActivity(Intent(this, MainActivity::class.java))

    }


}