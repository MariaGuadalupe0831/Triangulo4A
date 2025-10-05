package com.example.triangulo4a.Contract

interface CuadradoContract {
    interface CuadradoModel{
        fun CalcularArea(lado: Float): Float
        fun CalcularPerimetro(lado: Float): Float
    }
    interface CuadradoPresenter{
        fun CalcularArea(lado: Float)
        fun CalcularPerimetro(lado: Float)
    }
    interface CuadradoView{
        fun ShowArea(Area: Float)
        fun ShowPerimetro(Perimetro: Float)
        fun ShowError(msg: String)
    }
}