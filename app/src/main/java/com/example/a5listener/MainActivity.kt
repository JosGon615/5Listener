package com.example.a5listener

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.a5listener.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //añadir editText2 a editText1 cuando se pulse el boton sin borrar lo que haya en editText1
        binding.button.setOnClickListener {
            binding.name1.setText(binding.name1.text.toString() + binding.name2.text.toString())
            binding.name2.text.clear()
        }


        //desactivar el boton si el editText1 y editText2 estan vacios
        binding.name1.addTextChangedListener {
            binding.button.isEnabled = binding.name1.text.toString().isNotEmpty() && binding.name2.text.toString()
                .isNotEmpty()
        }
        binding.name2.addTextChangedListener {
            binding.button.isEnabled = binding.name1.text.toString().isNotEmpty() && binding.name2.text.toString()
                .isNotEmpty()
        }

        //mostrar el tag en textView

        binding.name1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textView.text = binding.name1.tag.toString()
            } else {
                binding.textView.text = ""
            }
        }
        binding.name2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textView.text = binding.name2.tag.toString()
            } else {
                binding.textView.text = ""
            }
        }

        binding.button.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textView.text = binding.button.tag.toString()
            } else {
                binding.textView.text = ""
            }
        }



    }








}

