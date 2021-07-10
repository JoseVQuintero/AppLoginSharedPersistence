package com.danisable.apploginsharedpersistence.domain.model

import java.io.Serializable

data class Note (
    val id: String,
    val title: String,
    val message: String,
    val date: String,
    val category: Int
    ):Serializable