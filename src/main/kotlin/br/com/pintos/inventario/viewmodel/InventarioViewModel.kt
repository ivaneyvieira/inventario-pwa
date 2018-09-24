package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel
import br.com.pintos.inventario.model.Inventario

class InventarioViewModel(view: IView,  classView : Class<*>) : SubViewModel(view, classView ) {
  fun doConfirmar() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun doVoltar() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var inventario : Inventario? = null
  val inventariosAberto = Inventario.inventariosAberto()
}