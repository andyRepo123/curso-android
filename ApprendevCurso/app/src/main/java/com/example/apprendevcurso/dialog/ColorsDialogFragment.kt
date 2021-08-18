package com.example.apprendevcurso.dialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.apprendevcurso.R
import java.lang.IllegalStateException

class ColorsDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Colores")
                .setItems(
                    R.array.colors
                ) { dialog, colorId ->
                    Log.d(ColorsDialogFragment::class.java.simpleName, "colorId = $colorId")
                }
            builder.create()
        } ?: throw IllegalStateException("Está actividad no debería ser nula")
    }
}