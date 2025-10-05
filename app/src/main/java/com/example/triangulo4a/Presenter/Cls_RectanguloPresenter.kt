package com.example.triangulo4a.Presenter
import com.example.triangulo4a.Contract.RectanguloContract
import com.example.triangulo4a.Model.Cls_RectanguloModel
class Cls_RectanguloPresenter(private  val vista: RectanguloContract.RectanguloView): RectanguloContract.RectanguloPresenter {
    private val modelo: RectanguloContract.RectanguloModel = Cls_RectanguloModel();
    override fun calcularArea(largo: Float, ancho: Float) {
        if (largo<=0 || ancho<=0){
            vista.ShowError("Las medidas deben ser mayores a 0")
        }else{
            val a=modelo.CalcularArea(largo,ancho)
            vista.ShowArea(a)
        }
    }

    override fun calcularPerimetro(largo: Float, ancho: Float) {
        if (largo<=0 || ancho<=0){
            vista.ShowError("Las medidas deben ser mayores a 0")
            return
        }else if(largo==ancho){
            vista.ShowError("Las medidas corresponden a un cuadrado")
            return
        }else{
            val p=modelo.CalcularPerimetro(largo,ancho)
            vista.ShowPerimetro(p)
        }
    }
}