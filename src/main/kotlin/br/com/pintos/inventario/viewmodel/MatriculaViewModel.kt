package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.EViewModel
import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.ViewModel
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.Usuario
import kotlin.reflect.KClass

class MatriculaViewModel(view: IView, val classInventarioView: KClass<*>, val classLoteView : KClass<*>) : ViewModel(view) {
  var matricula: Int? = null
  var senha: String? = ""
  var nome: String? = ""
  val usuario
    get() = Usuario.find(matricula)

  fun changeMatricula() = exec {
    nome = usuario?.nome ?: ""
  }

  fun doLogin() = exec {
    val user = usuario ?: throw  EViewModel("Usuário não encontrado")
    if (user.senha.trim() == senha?.trim()) {
      userInformation.usuario = user
      navigateToInventario()
    } else
      throw EViewModel("Senha Incorreta")
  }

  private fun navigateToInventario() {
    if (Inventario.inventariosAberto().isEmpty())
      throw EViewModel("Não existe nenhum inventário aberto")
    else
      if (Inventario.inventariosAberto().size == 1) {
        userInformation.inventario = Inventario.inventariosAberto().firstOrNull() ?:
                throw EViewModel("Não existe nenhum inventário aberto")
        view.navigate(classLoteView)
      }
    view.navigate(classInventarioView)
  }

  init {
    userInformation.usuario = null
  }
}