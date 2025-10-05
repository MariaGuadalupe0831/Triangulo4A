package com.example.triangulo4a.Model
import com.example.triangulo4a.Contract.RectanguloContract

class Cls_RectanguloModel: RectanguloContract.RectanguloModel {
    override fun CalcularArea(largo: Float, ancho: Float): Float {
        return largo * ancho;
    }

    override fun CalcularPerimetro(largo: Float, ancho: Float): Float {
        return 2*(largo+ancho);
    }

    override fun esRectangulo(largo: Float, ancho: Float): Boolean {
        return largo != ancho
    }

}