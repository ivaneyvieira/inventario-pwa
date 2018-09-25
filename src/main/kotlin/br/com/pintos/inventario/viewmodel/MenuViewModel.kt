package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel

class MenuViewModel(view: IView, classMatriculaView: Class<*>) : SubViewModel(view, classMatriculaView) {
  fun doLote() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun doColeta() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  fun doApaga() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var inventarioLoja = userInformation.inventarioLoja
  var usuarioApelido = userInformation.usuarioApelido
  var loteColeta = userInformation.loteColeta
  var quantidade: Int? = null
}