package com.example.apprendevcurso.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.lang.IllegalStateException

class QuestionDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Te gustaría programar en Android")
                .setPositiveButton("Sí") { _, _ ->
                }
                .setNegativeButton("No") { _, _ ->
                }
            builder.create()
        } ?: throw IllegalStateException("La actividad no puede ser nula")
    }
}