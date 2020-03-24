package com.sundaydavid.aboutme

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.sundaydavid.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyNAme = MyNAme("Kingsley John", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName = myName
//        findViewById<Button>(R.id.done_button).setOnClickListener {

        //}
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){

        binding.apply {
           myName?.nickname = nickNameEdit.text.toString()
           binding.nickNameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            binding.nickNameText.visibility = View.VISIBLE

            val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inm.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}
