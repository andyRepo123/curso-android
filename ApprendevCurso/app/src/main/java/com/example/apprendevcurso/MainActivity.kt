package com.example.apprendevcurso

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tituloTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tituloTextView = findViewById(R.id.titulo)
        val button: Button = findViewById(R.id.btnRegistro)
        button.isEnabled = true
    }

    fun registro(view: View) {
        val mensaje = "Registro completo"
        val duracion = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, mensaje, duracion)
        toast.show()
    }

    fun registroCompleto(view: View) {
        mostrarMensaje("Registro completado", Toast.LENGTH_LONG, view.context)
    }

    fun mostrarMensaje(mensaje: String, duracion: Int, context: Context) {
        Toast.makeText(context, mensaje, duracion).show()
    }

    fun radioButtonClick(view: View) {
        if (view is RadioButton) {
            val seleccionado = view.isChecked

            when (view.id) {
                R.id.opcion1 -> {
                    if (seleccionado) {
                        mostrarMensaje("Información aceptada", Toast.LENGTH_LONG, view.context)
                    }
                }
                R.id.opcion2 -> {
                    if (seleccionado) {
                        mostrarMensaje("Información rechazada", Toast.LENGTH_LONG, view.context)
                    }
                }
            }
        }
    }
}