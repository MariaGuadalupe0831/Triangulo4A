package com.example.triangulo4a.Model
import com.example.triangulo4a.Contract.CuadradoContract
class CuadradoModel: CuadradoContract.CuadradoModel {
    override fun CalcularArea(lado: Float): Float {
        return lado * lado;
    }

    override fun CalcularPerimetro(lado: Float): Float {
        return 4 * lado;
    }
}