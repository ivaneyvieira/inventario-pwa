package br.com.pintos.inventario.viewmodel

import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.model.Lote

class LoteViewModel(view: IView): ViewModel(view) {
  fun doConfirmar() = exec {
    lote?.let {lote ->
      userInformation.lote = lote
      userInformation.initColeta()
      //TODO view.navigate(classColetaView)
    }
  }

  var inventarioLoja = userInformation.inventarioLoja
  var usuarioApelido = userInformation.usuarioApelido
  var numLote: String? = ""
  val lote: Lote?
    get() {
      val loja = userInformation.inventario?.loja ?: return null
      return numLote?.let {num ->
        Lote.findNumLote(num, loja)
      }
    }

  init {
    userInformation.lote = null
  }
}