package br.com.pintos.inventario.viewmodel

import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.model.Inventario

class InventarioViewModel(view: IView): ViewModel(view) {
  fun doConfirmar() = exec {
    inventario?.let {
      userInformation.inventario = inventario
      //TODO view.navigate(classLoteView)
    }
  }

  var usuarioApelido = userInformation.usuarioApelido
  var inventario: Inventario? = null
  val inventariosAberto = Inventario.inventariosAberto()

  init {
    userInformation.inventario = null
  }
}