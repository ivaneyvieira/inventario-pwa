package br.com.pintos.inventario.viewmodel

import br.com.pintos.framework.viewmodel.EViewModel
import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.SubViewModel
import br.com.pintos.inventario.model.EStatusLeitura.ERRO
import br.com.pintos.inventario.model.EStatusLeitura.SUCESSO
import br.com.pintos.inventario.model.Leitura
import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.Produto
import kotlin.reflect.KClass

class ColetaViewModel(view: IView, classMenuView: KClass<*>, private val classLoteView: KClass<*>) :
  SubViewModel(view, classMenuView) {
  fun doLeitura() = exec {
    leitura?.let { leitura ->
      val loja = userInformation.inventario?.loja
      val lote = Lote.findNumLote(leitura, loja)
      if (lote != null)
        doMudarLote(lote)
      else {
        doLeitura(leitura)
        quantidade = userInformation.quantidade
      }
    }
  }

  private fun doLeitura(leitura: String) {
    val produto = Produto.findLeitura(leitura)
    codigo = produto?.codigo
    grade = produto?.grade
    descricao = produto?.descricao
    val coleta = userInformation.coleta ?: throw EViewModel("Coleta não encontrada")
    Leitura(
      leitura = leitura,
      observacao = "",
      quant = if (produto == null) 0 else 1,
      status = if (produto == null) ERRO else SUCESSO,
      coleta = coleta,
      produto = produto,
      saldo = null
    ).insert()
  }

  private fun doMudarLote(lote: Lote) {
    userInformation.lote = lote
    userInformation.coleta = null
    view.navigate(classLoteView)
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