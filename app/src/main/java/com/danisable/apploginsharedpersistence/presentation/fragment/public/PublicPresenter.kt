package com.danisable.apploginsharedpersistence.presentation.fragment.public

import android.content.Context
import com.danisable.apploginsharedpersistence.data.local.PersistenceDatabase

class PublicPresenter(private val context: Context) {

    private val database = PersistenceDatabase(context)

}