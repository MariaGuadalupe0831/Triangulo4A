package com.example.triangulo4a.Presenter
import com.example.triangulo4a.Contract.CirculoContract
import com.example.triangulo4a.Model.CirculoModel

class CirculoPresenter(private val vista: CirculoContract.CirculoVista): CirculoContract.CirculoPresenter {
    private val modelo: CirculoContract.CirculoModel = CirculoModel();

    override fun CalcularArea(radio: Float) {
        if (radio <= 0) {
            vista.ShowError("El radio debe ser mayor que 0");
        } else {
            val area = modelo.CalcularArea(radio);
            vista.ShowArea(area)
        }
    }

    override fun CalcularPerimetro(radio: Float) {
        if (radio <= 0) {
            vista.ShowError("El radio debe ser mayor que 0");
        } else {
            val perimetro = modelo.CalcularPerimetro(radio)
            vista.ShowPerimetro(perimetro)
        }
    }
}