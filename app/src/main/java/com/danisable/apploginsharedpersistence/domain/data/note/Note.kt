package com.danisable.apploginsharedpersistence.domain.data.note
import com.danisable.apploginsharedpersistence.domain.model.Note

object Note {
    fun getNote(): ArrayList<Note> {
        return arrayListOf(
                    Note("0",
                        "Nota 0",
                        "Task 0, for intent",
                        "08/07/2021 09:50",
                        0),
                    Note("1",
                        "Nota 1",
                        "Task 1, for intent",
                        "08/07/2021 09:50",
                        1),
                    Note("2",
                        "Nota 2",
                        "Task 2, for intent",
                        "08/07/2021 09:50",
                        2),
        )
    }
}