package com.danisable.apploginsharedpersistence.presentation.fragment.notes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.danisable.apploginsharedpersistence.R
import com.danisable.apploginsharedpersistence.domain.model.Note
import kotlinx.android.synthetic.main.fragment_notes_details.*

class DetailsFragment: Fragment(), View.OnClickListener, DetailsInteractor.View {
    private var presenter: DetailsPresenter? = null
    private var note: Note? =null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notes_details,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        note = arguments?.getSerializable("note") as Note
        etTitle.setText(note?.title)
        etDescription.setText(note?.description)

        presenter = DetailsPresenter(requireContext(),this)

        fdDelete.setOnClickListener(this)
        fdUpdate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fdDelete -> {
                presenter?.deleteNote(note!!)
            }
            R.id.fdUpdate -> {
                updateNote()
            }
        }
    }

    fun updateNote(){
        if(etTitle.text.toString().isEmpty()||etDescription.text.toString().isEmpty()) {
            Toast.makeText(requireContext(),"Field empty", Toast.LENGTH_SHORT).show()
        }
        else{
            note?.title = etTitle.text.toString()
            note?.description = etDescription.text.toString()
            presenter?.updateNote(note!!)
        }
    }

    override fun onSuccess() {
        Toast.makeText(requireContext(),"Delete note success", Toast.LENGTH_SHORT).show()
        activity?.supportFragmentManager?.popBackStack()
    }


}