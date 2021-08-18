package com.example.apprendevcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apprendevcurso.dialog.*

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        /*val questionDialogFragment = QuestionDialogFragment()
        questionDialogFragment.show(
            supportFragmentManager,
            QuestionDialogFragment::class.java.simpleName
        )*/

        /*val colorsDialogFragment = ColorsDialogFragment()
        colorsDialogFragment.show(
            supportFragmentManager,
            ColorsDialogFragment::class.java.simpleName
        )*/

        /*val multiColorsDialogFragment = MultiColorsDialogFragment()
        multiColorsDialogFragment.show(
            supportFragmentManager,
            MultiColorsDialogFragment::class.java.simpleName
        )*/

        /*val singleColorsDialogFragment = SingleColorsDialogFragment()
        singleColorsDialogFragment.show(
            supportFragmentManager,
            SingleColorsDialogFragment::class.java.simpleName
        )*/

        val loginDialogFragment = LoginDialogFragment()
        loginDialogFragment.show(supportFragmentManager, LoginDialogFragment::class.java.simpleName)
    }
}