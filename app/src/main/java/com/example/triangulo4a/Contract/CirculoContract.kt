package com.example.triangulo4a.Contract

interface CirculoContract {
    interface CirculoModel {
        fun CalcularArea(radio: Float): Float
        fun CalcularPerimetro(radio: Float): Float
    }

    interface CirculoPresenter{
        fun CalcularArea(radio: Float)
        fun CalcularPerimetro(radio: Float)
    }

    interface CirculoVista{
        fun ShowArea(Area: Float)
        fun ShowPerimetro(Perimetro: Float)
        fun ShowError(msg: String)
    }
}