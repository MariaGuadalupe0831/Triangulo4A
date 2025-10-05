package com.example.triangulo4a.View

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triangulo4a.Contract.CuadradoContract
import com.example.triangulo4a.Presenter.CuadradoPresenter
import com.example.triangulo4a.R

class MainActivityCuadrado : AppCompatActivity(), CuadradoContract.CuadradoView {

    private lateinit var txtResultado: TextView;
    private lateinit var presentador: CuadradoContract.CuadradoPresenter;

    fun setPresentador(presentador: CuadradoContract.CuadradoPresenter){
        this.presentador=presentador;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_cuadrado)

        //Inicializamos elementos a utilizar
        val txtlado: EditText = findViewById<EditText>(R.id.edtRadio);
        val btnArea: Button = findViewById<Button>(R.id.btnArea);
        val btnPerimetro: Button = findViewById<Button>(R.id.btnPerimetro);
        txtResultado= findViewById<TextView>(R.id.txtRes);

        //definimos el presentador
        presentador = CuadradoPresenter(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //listener del boton para calcular el perimetro
        btnPerimetro.setOnClickListener {
            val lado = txtlado.text.toString().toFloat();
            presentador.CalcularPerimetro(lado);
        }

        //listener del boton para calcular el area
        btnArea.setOnClickListener {
            val lado = txtlado.text.toString().toFloat();
            presentador.CalcularArea(lado);
        }
    }

    override fun ShowArea(Area: Float) {
        txtResultado.text = "El area es ${Area}";
    }

    override fun ShowPerimetro(Perimetro: Float) {
        txtResultado.text = "El perimetro es ${Perimetro}";
    }

    override fun ShowError(msg: String) {
        txtResultado.text = msg;
    }
}