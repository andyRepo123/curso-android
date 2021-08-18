package com.example.apprendevcurso.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.apprendevcurso.R
import java.lang.IllegalStateException

class SingleColorsDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Selección única de colores")
                .setSingleChoiceItems(
                    R.array.colors,
                    1
                ) { dialog, colorId ->
                }
                .setPositiveButton("Aceptar") { dialog, colorId ->
                }
                .setNegativeButton("Cancelar") { dialog, colorId -> }
            builder.create()
        } ?: throw IllegalStateException("Está actividad no debería ser nula")
    }
}