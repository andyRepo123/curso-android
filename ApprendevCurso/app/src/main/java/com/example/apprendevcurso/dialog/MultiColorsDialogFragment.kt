package com.example.apprendevcurso.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.apprendevcurso.R
import java.lang.IllegalStateException

class MultiColorsDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedColors = mutableListOf<Int>()
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Selección de colores multiples")
                .setMultiChoiceItems(
                    R.array.colors,
                    null
                ) { dialog, colorId, isChecked ->
                    if (isChecked) {
                        selectedColors.add(colorId)
                    } else if (selectedColors.contains(colorId)) {
                        selectedColors.remove(colorId)
                    }
                    Log.d(
                        MultiColorsDialogFragment::class.java.simpleName,
                        "selectedColors size = ${selectedColors.size}"
                    )
                }
                .setPositiveButton("Acepto") { _, _ ->

                }
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener { _, _ ->

                })
            builder.create()
        } ?: throw IllegalStateException("La actividad no debe ser nula")
    }
}