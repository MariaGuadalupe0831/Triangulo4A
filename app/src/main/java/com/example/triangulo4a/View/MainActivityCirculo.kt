package com.example.triangulo4a.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triangulo4a.Contract.CirculoContract
import com.example.triangulo4a.Presenter.CirculoPresenter
import com.example.triangulo4a.R

class MainActivityCirculo : AppCompatActivity(), CirculoContract.CirculoVista {
    private lateinit var txtResultado: TextView;
    private lateinit var presentandor: CirculoContract.CirculoPresenter

    fun setPresentador(presentador: CirculoContract.CirculoPresenter){
        this.presentandor = presentador;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_circulo)

        //inicializamos elementos a utilizar
        val txtradio: EditText = findViewById<EditText>(R.id.edtRadio)
        val btnArea: Button = findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button = findViewById<Button>(R.id.btnPerimetro)
        val btnSalir: Button = findViewById<Button>(R.id.btnSalir)
        txtResultado = findViewById<TextView>(R.id.txtRes)

        //inicializamos el presentador
        presentandor= CirculoPresenter(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //listener del boton para calcular el perimetro
        btnPerimetro.setOnClickListener {
            val radioo= txtradio.text.toString().toFloat()
            presentandor.CalcularPerimetro(radioo)
        }

        btnArea.setOnClickListener {
            val radio = txtradio.text.toString().toFloat()
            presentandor.CalcularArea(radio)
        }
        btnSalir.setOnClickListener {
            val menu = Intent(this, MenuApp::class.java)
            startActivity(menu)
        }
    }

    override fun ShowArea(Area: Float) {
        txtResultado.text ="El area es: ${Area}"
    }

    override fun ShowPerimetro(Perimetro: Float) {
        txtResultado.text = "El permitro es: ${Perimetro}"
    }

    override fun ShowError(msg: String) {
        txtResultado.text= msg;
    }
}


