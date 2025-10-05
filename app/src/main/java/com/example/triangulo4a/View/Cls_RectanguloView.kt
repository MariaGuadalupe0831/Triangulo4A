package com.example.triangulo4a.View
import com.example.triangulo4a.Contract.RectanguloContract
class Cls_RectanguloView:RectanguloContract.RectanguloView{
    private lateinit var presenter : RectanguloContract.RectanguloPresenter

    fun setPresenter(presentador: RectanguloContract.RectanguloPresenter){
        presenter=presentador
    }

    fun inicio(){
        println("--- Calculadora de Rectangulo ---")
        println("Captura el largo del rectangulo")
        val l1 =readln().toFloat()
        println("Captura el ancho del rectangulo")
        val l2 =readln().toFloat()


        println("--- Menu de opciones...")
        println("[1]    Calcular el Area...")
        println("[2]    Calcular el Perimetro...")
        println("Elije una opcion...")
        val op=readln().toString()

        when(op){
            "1"->presenter.calcularArea(l1,l2)
            "2"->presenter.calcularPerimetro(l1,l2)
        }
    }

    override fun ShowArea(Area: Float) {
        println("El area del rectangulo es : ${Area} m2");
    }

    override fun ShowPerimetro(Perimetro: Float) {
        println("El perimetro del rectangulo es : ${Perimetro}");
    }

    override fun ShowError(mensaje: String) {
        println(mensaje);
    }
}