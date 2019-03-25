package br.com.pintos.inventario.viewmodel

import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel

class MenuViewModel(view: IView): ViewModel(view) {
  fun doLote() {
    //TODO view.navigate(classLoteView)
  }

  fun doColeta() {
    //TODO view.navigate(classColetaView)
  }

  fun doApaga() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var inventarioLoja = userInformation.inventarioLoja
  var usuarioApelido = userInformation.usuarioApelido
  var loteColeta = userInformation.loteColeta
  var quantidade: Int? = null
}