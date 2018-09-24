package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.EViewModel
import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.ViewModel
import br.com.pintos.inventario.model.Usuario

class MatriculaViewModel(view: IView, val classInventarioView : Class<*>) : ViewModel(view) {
  var matricula: Int? = 0
  var senha: String? = ""
  var nome: String? = ""
  val usuario
    get() = Usuario.find(matricula)

  fun changeMatricula() = exec {
    nome = usuario?.nome ?: ""
  }

  fun doLogin() = exec {
    val user = usuario ?: throw  EViewModel("Usuário não encontrado")
    if(user.senha.trim() == senha?.trim())
      navigateToInventario()
    else
      throw EViewModel("Senha Incorreta")
  }

  private fun navigateToInventario() {
    view.navigate(classInventarioView)
  }
}