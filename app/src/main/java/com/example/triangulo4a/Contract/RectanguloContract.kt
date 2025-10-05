package com.example.triangulo4a.Contract

interface RectanguloContract {
    interface RectanguloModel {
        fun CalcularArea(largo: Float, ancho: Float): Float
        fun CalcularPerimetro(largo: Float, ancho: Float): Float
        fun esRectangulo(largo: Float, ancho: Float): Boolean
    }

    interface RectanguloPresenter {
        fun calcularArea(largo: Float, ancho: Float)
        fun calcularPerimetro(largo: Float, ancho: Float)
    }

    interface RectanguloView {
        fun ShowArea(Area: Float)
        fun ShowPerimetro(Perimetro: Float)
        fun ShowError(mensaje: String)
    }
}