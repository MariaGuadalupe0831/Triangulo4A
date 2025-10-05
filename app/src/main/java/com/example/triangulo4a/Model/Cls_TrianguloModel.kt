package com.example.triangulo4a.Model
import com.example.triangulo4a.Contract.TrianguloContract
import kotlin.math.sqrt
class Cls_TrianguloModel: TrianguloContract.TrianguloModel {
    override fun CalcularArea(
        lado1: Float,
        lado2: Float,
        lado3: Float
    ): Float {
        val s: Float=(lado1+lado2+lado3)/2
        val area: Float= sqrt(s*(s-lado1)*(s-lado2)*(s-lado3))
        return area
    }

    override fun CalcualrPerimetro(
        lado1: Float,
        lado2: Float,
        lado3: Float
    ): Float {
        return lado1+lado2+lado3
    }

    override fun VerificarTriangulo(
        lado1: Float,
        lado2: Float,
        lado3: Float
    ): Boolean {
        if(lado1+lado2>lado3 && lado1+lado3>lado2 && lado3+lado2>lado1)
            return true
        else
            return false
    }

    override fun CalcularTipoTriangulo(
        lado1: Float,
        lado2: Float,
        lado3: Float
    ): String {
        if(lado1==lado2 && lado2==lado3)
            return "Equilatero..."
        else if(lado1!=lado2 && lado2!=lado3)
            return "Escaleno..."
        else
            return "Isoceles..."
    }
}