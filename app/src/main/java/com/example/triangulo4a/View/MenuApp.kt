package com.example.triangulo4a.View

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triangulo4a.R


class MenuApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_app)

        val spinner: Spinner= findViewById<Spinner>(R.id.spnSelect)
        val btnIr=findViewById<Button>(R.id.btnIr)

        val opciones=arrayOf("Triangulo", "Rectangulo","Cuadrado","Circulo")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,opciones)
        spinner.adapter=adaptador


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnIr.setOnClickListener {
            when(spinner.selectedItem.toString()){
                "Triangulo"-> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                "Rectangulo"->{
                    val intent = Intent(this, MainActivityRectangulo::class.java)
                    startActivity(intent)
                }
                "Cuadrado"->{
                    val intent = Intent(this, MainActivityCuadrado::class.java)
                    startActivity(intent)
                }
                "Circulo"->{
                    val intent = Intent(this, MainActivityCirculo::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}