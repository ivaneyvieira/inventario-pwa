package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel
import br.com.pintos.inventario.model.Inventario
import kotlin.reflect.KClass

class InventarioViewModel(view: IView, classMatriculaView: KClass<*>, val classLoteView: KClass<*>) :
  SubViewModel(view, classMatriculaView) {
  fun doConfirmar() = exec {
    inventario?.let {
      userInformation.inventario = inventario
      view.navigate(classLoteView)
    }
  }

  var usuarioApelido = userInformation.usuarioApelido
  var inventario: Inventario? = null
  val inventariosAberto = Inventario.inventariosAberto()

  init {
    userInformation.inventario = null
  }
}