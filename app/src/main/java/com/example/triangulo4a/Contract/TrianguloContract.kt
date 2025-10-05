package com.example.triangulo4a.Contract

interface TrianguloContract {
    interface TrianguloModel{
        fun CalcularArea(lado1: Float, lado2:Float,lado3: Float): Float
        fun CalcualrPerimetro(lado1: Float,lado2: Float,lado3: Float): Float
        fun VerificarTriangulo(lado1: Float,lado2: Float,lado3: Float): Boolean
        fun CalcularTipoTriangulo(lado1: Float, lado2: Float,lado3: Float): String
    }
    interface TrianguloPresenter{
        fun CalculaArea(lado1: Float,lado2: Float,lado3: Float)
        fun CalculaPerimetro(lado1: Float, lado2: Float,lado3: Float)
        fun CalcularTipoTriangulo(lado1: Float,lado2: Float,lado3: Float)
    }
    interface TrianguloVista{
        //fun ShowMenu()
        fun ShowArea(Area: Float)
        fun ShowPerimetro(Perimetro: Float)
        fun ShowTipo(Tipo: String)
        fun ShowError(msg: String)
    }
}