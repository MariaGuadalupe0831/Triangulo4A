package com.example.triangulo4a.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triangulo4a.Contract.RectanguloContract
import com.example.triangulo4a.Presenter.Cls_RectanguloPresenter
import com.example.triangulo4a.R

class MainActivityRectangulo : AppCompatActivity(), RectanguloContract.RectanguloView {
    private lateinit var txtResultado: TextView
    private lateinit var presentador : RectanguloContract.RectanguloPresenter

    fun setPresenter(presentador: RectanguloContract.RectanguloPresenter){
        this.presentador =presentador
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_rectangulo)

        //inicializamos elemento a visualizar
        val txtBase: EditText= findViewById<EditText>(R.id.edtBase)
        val txtAltura: EditText=findViewById<EditText>(R.id.edtAltura)
        val btnArea: Button = findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button = findViewById<Button>(R.id.btnPerimetro)
        val btnSalir: Button = findViewById<Button>(R.id.btnSalir)
        txtResultado = findViewById<TextView>(R.id.txtRes)

        //definimos el presentador
        presentador = Cls_RectanguloPresenter(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //listener del boton para calcular el perimetro
        btnPerimetro.setOnClickListener {
            val base = txtBase.text.toString().toFloat()
            val altura = txtAltura.text.toString().toFloat()
            presentador.calcularPerimetro(base,altura)
        }

        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val base =txtBase.text.toString().toFloat()
            val altura = txtAltura.text.toString().toFloat()
            presentador.calcularArea(base,altura)
        }
        btnSalir.setOnClickListener {
            val menu = Intent(this, MenuApp::class.java)
            startActivity(menu)
        }
    }

    override fun ShowArea(Area: Float) {
        txtResultado.text = "El area es ${Area}"
    }

    override fun ShowPerimetro(Perimetro: Float) {
        txtResultado.text = "El perimetro es ${Perimetro}"
    }

    override fun ShowError(mensaje: String) {
        txtResultado.text=mensaje
    }
}