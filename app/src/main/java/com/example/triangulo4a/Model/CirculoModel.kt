package com.example.triangulo4a.Model
import com.example.triangulo4a.Contract.CirculoContract
import kotlin.math.pow
import kotlin.math.PI
class CirculoModel: CirculoContract.CirculoModel {
    override fun CalcularArea(radio: Float): Float {
        return (PI * radio.pow(2)).toFloat()
    }

    override fun CalcularPerimetro(radio: Float): Float {
        return (2 * PI * radio).toFloat()
    }


}