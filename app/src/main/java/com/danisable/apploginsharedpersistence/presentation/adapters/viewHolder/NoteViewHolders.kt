package com.danisable.apploginsharedpersistence.presentation.adapters.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danisable.apploginsharedpersistence.R

class NoteViewHolders(private val view: View): RecyclerView.ViewHolder(view) {
    val tvTitle = view.findViewById(R.id.tvTitle) as TextView
    val imgTask = view.findViewById(R.id.imgTask) as ImageView
    val tvMessage = view.findViewById(R.id.tvMessage) as TextView
}