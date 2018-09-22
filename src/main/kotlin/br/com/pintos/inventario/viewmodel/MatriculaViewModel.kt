package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.ViewModel
import br.com.pintos.inventario.model.Usuario

class MatriculaViewModel(view: IView) : ViewModel(view) {
  var matricula: Int? = 0
  var senha: String? = ""
  var nome: String? = ""

  fun changeMatricula() = exec {
    nome = Usuario.find(matricula)?.nome ?: ""
  }
}