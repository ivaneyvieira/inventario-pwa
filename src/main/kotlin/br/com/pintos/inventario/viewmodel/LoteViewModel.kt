package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel
import br.com.pintos.inventario.model.Lote
import kotlin.reflect.KClass

class LoteViewModel(view: IView, classInventarioView: KClass<*>, val classColetaView: KClass<*>) :
  SubViewModel(view, classInventarioView) {
  fun doConfirmar() = exec {
    lote?.let { lote ->
      userInformation.lote = lote
      userInformation.initColeta()
      view.navigate(classColetaView)
    }
  }

  var inventarioLoja = userInformation.inventarioLoja
  var usuarioApelido = userInformation.usuarioApelido
  var numLote: String? = ""
  val lote: Lote?
    get() {
      val loja = userInformation.inventario?.loja ?: return null
      return numLote?.let { num ->
        Lote.findNumLote(num, loja)
      }
    }

  init {
    userInformation.lote = null
  }
}