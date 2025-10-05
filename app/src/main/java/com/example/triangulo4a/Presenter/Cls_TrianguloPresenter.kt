package com.example.triangulo4a.Presenter
import com.example.triangulo4a.Contract.TrianguloContract
import com.example.triangulo4a.Model.Cls_TrianguloModel
class Cls_TrianguloPresenter(private  val vista: TrianguloContract.TrianguloVista): TrianguloContract.TrianguloPresenter {
    private val modelo: TrianguloContract.TrianguloModel= Cls_TrianguloModel()

    override fun CalculaArea(lado1: Float, lado2: Float, lado3: Float) {
        if(modelo.VerificarTriangulo(lado1,lado2,lado3)){
            val a=modelo.CalcularArea(lado1,lado2,lado3)
            vista.ShowArea(a)
        }else{
            vista.ShowError("Datos incorrectos")
        }
    }

    override fun CalculaPerimetro(lado1: Float, lado2: Float, lado3: Float) {
        if(modelo.VerificarTriangulo(lado1,lado2,lado3)){
            val p=modelo.CalcualrPerimetro(lado1,lado2,lado3)
            vista.ShowPerimetro(p)
        }else{
            vista.ShowError("Datos incorrectos")
        }
    }

    override fun CalcularTipoTriangulo(
        lado1: Float,
        lado2: Float,
        lado3: Float
    ) {
        if(modelo.VerificarTriangulo(lado1,lado2,lado3)){
            val t=modelo.CalcularTipoTriangulo(lado1,lado2,lado3)
            vista.ShowTipo(t)
        }else{
            vista.ShowError("Datos incorrectos")
        }
    }
}