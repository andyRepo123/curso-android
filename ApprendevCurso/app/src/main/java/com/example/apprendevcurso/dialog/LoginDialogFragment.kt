package com.example.apprendevcurso.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.apprendevcurso.R
import java.lang.IllegalStateException

class LoginDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.login_view, null))

            builder.create()
        } ?: throw  IllegalStateException("Está actividad no debería ser nula")
    }
}