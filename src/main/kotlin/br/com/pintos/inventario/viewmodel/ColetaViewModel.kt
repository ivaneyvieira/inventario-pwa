package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel
import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.Lote.Find
import br.com.pintos.inventario.model.Produto

class ColetaViewModel(view: IView, classMenuView: Class<*>) : SubViewModel(view, classMenuView) {
  fun doLeitura() = exec {
    leitura?.let { leitura ->
      val lote = Lote.findNumLote(leitura, userInformation.inventario?.loja)
      if (lote != null)
        doMudarLote(lote)
      else {
        val produto = Produto.findLeitura(leitura)
        produto?.let { produto ->
          codigo = produto.codigo
          grade = produto.grade
          descricao = produto.descricao
          quantidade = userInformation.quantidade
          doLeitura(produto)
        }
      }
    }
  }

  private fun doLeitura(produto: Produto) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  private fun doMudarLote(lote: Lote) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var inventarioLoja = userInformation.inventarioLoja
  var usuarioApelido = userInformation.usuarioApelido
  var loteColeta = userInformation.loteColeta
  var leitura: String? = null
  var codigo: String? = null
  var grade: String? = null
  var descricao: String? = null
  var quantidade: Int? = null
}