package com.example.triangulo4a.View

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triangulo4a.Contract.TrianguloContract
import com.example.triangulo4a.Presenter.Cls_TrianguloPresenter
import com.example.triangulo4a.R
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), TrianguloContract.TrianguloVista {
    private lateinit var txvResultado: TextView
    private lateinit var presentador: TrianguloContract.TrianguloPresenter

    fun setPresentador(presentador : TrianguloContract.TrianguloPresenter){
        this.presentador=presentador
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //inicializamos elemento a utilizar
        val txtl1: EditText =findViewById<EditText>(R.id.edtL1)
        val txtl2: EditText =findViewById<EditText>(R.id.edtL2)
        val txtl3: EditText =findViewById<EditText>(R.id.edtL3)
        val btnArea: Button =findViewById<Button>(R.id.btnArea)
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro)
        val btnTipo: Button =findViewById<Button>(R.id.btnTipo)
        txvResultado = findViewById<TextView>(R.id.txtRes)

        //definimos el presentador
        presentador = Cls_TrianguloPresenter(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //listener del boton para calcular el perimetro
        btnPerimetro.setOnClickListener{
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.CalculaPerimetro(l1,l2,l3)
        }

        //listener del boton para definir el tipo de triangulo
        btnTipo.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.CalcularTipoTriangulo(l1,l2,l3)
        }

        //listener del boton para calcular el area llamando a una funcion
        btnArea.setOnClickListener {
            val l1=txtl1.text.toString().toFloat()
            val l2=txtl2.text.toString().toFloat()
            val l3=txtl3.text.toString().toFloat()
            presentador.CalculaArea(l1,l2,l3)
        }
    }

    override fun ShowArea(Area: Float) {
        txvResultado.text="El area es ${Area}"
    }

    override fun ShowPerimetro(Perimetro: Float) {
        txvResultado.text="El perimetro es ${Perimetro}"
    }

    override fun ShowTipo(Tipo: String) {
        txvResultado.text="El tipo es ${Tipo}"
    }

    override fun ShowError(msg: String) {
        txvResultado.text=msg
    }
}