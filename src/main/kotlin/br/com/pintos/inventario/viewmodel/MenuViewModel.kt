package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel
import br.com.pintos.inventario.view.coletor.pages.ColetaView
import br.com.pintos.inventario.view.coletor.pages.LoteView
import kotlin.reflect.KClass

class MenuViewModel(
  view: IView,
  classMatriculaView: KClass<*>,
  val classLoteView: KClass<LoteView>,
  val classColetaView: KClass<ColetaView>
) :
  SubViewModel(view, classMatriculaView) {
  fun doLote() {
    view.navigate(classLoteView)
  }

  fun doColeta() {
    view.navigate(classColetaView)
  }

  fun doApaga() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var inventarioLoja = userInformation.inventarioLoja
  var usuarioApelido = userInformation.usuarioApelido
  var loteColeta = userInformation.loteColeta
  var quantidade: Int? = null
}