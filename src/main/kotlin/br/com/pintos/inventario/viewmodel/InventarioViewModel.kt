package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel
import br.com.pintos.inventario.model.Inventario

class InventarioViewModel(view: IView, val classInventarioView : Class<*>) : SubViewModel(view, classInventarioView ) {
  fun doConfirmar() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun doVoltar() {
    view.navigate(classInventarioView)
  }

  var inventario : Inventario? = null
  val inventariosAberto = Inventario.inventariosAberto()
}