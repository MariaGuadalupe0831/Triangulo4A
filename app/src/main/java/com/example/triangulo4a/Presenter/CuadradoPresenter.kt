package com.example.triangulo4a.Presenter
import com.example.triangulo4a.Contract.CuadradoContract
import com.example.triangulo4a.Model.CuadradoModel
class CuadradoPresenter(private val vista: CuadradoContract.CuadradoView): CuadradoContract.CuadradoPresenter {
    private val modelo: CuadradoContract.CuadradoModel = CuadradoModel()

    override fun CalcularArea(lado: Float) {
        if (lado<=0){
            vista.ShowError("Las medidas deben ser mayores a 0")
        }else{
            val a=modelo.CalcularArea(lado)
            vista.ShowArea(a)
        }
    }

    override fun CalcularPerimetro(lado: Float) {
        if (lado<=0){
            vista.ShowError("Las medidas deben ser mayores a 0")
        }else{
            val a=modelo.CalcularPerimetro(lado)
            vista.ShowPerimetro(a)
        }
    }
}