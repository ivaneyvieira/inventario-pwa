package br.com.pintos.inventario.viewmodel

import br.com.astrosoft.framework.viewmodel.EViewModel
import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.Leitura
import br.com.pintos.inventario.model.Loja
import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.Usuario
import br.com.pintos.inventario.viewmodel.TipoLeitura.COLETA
import br.com.pintos.inventario.viewmodel.TipoLeitura.INVENTARIO
import br.com.pintos.inventario.viewmodel.TipoLeitura.LOTE
import br.com.pintos.inventario.viewmodel.TipoLeitura.MATRICULA


class ViewModelColetor(view : IView) : ViewModel(view){
  fun lojas(): List<Loja> {
    return Loja.all()
  }

  var inventario: Inventario? = null
  var usuario: Usuario? = null
  var coleta: Coleta? = null

  val tipoLeitura: TipoLeitura
    get() = when {
      inventario == null -> INVENTARIO
      usuario == null    -> MATRICULA
      coleta == null       -> LOTE
      else               -> COLETA
    }
  val labelField: String
    get() = when(tipoLeitura) {
      MATRICULA  -> "Matrícula do usuário"
      INVENTARIO -> "Número do inventário"
      LOTE       -> "Número do lote"
      COLETA     -> "Código de barras"
    }
  val leituras : List<Leitura>
  get() = Leitura.findLeituras(coleta)

  init {
    val inventariosAbertos = Inventario.inventariosAberto()
    if(inventariosAbertos.size == 1)
      inventario = inventariosAbertos[0]
    else
      inventario = null
  }

  fun processaLeitura(value: String) = exec {
    when(tipoLeitura) {
      MATRICULA  -> processaMatricula(value)
      INVENTARIO -> processaInventario(value)
      LOTE       -> processaLote(value)
      COLETA     -> processaColeta(value)
    }
  }

  private fun processaColeta(value: String) {
    val coletaLeitura = coleta ?: throw EViewModel("Coleta não definida")
    Leitura.addLeitura(coletaLeitura, value)
  }

  private fun processaLote(value: String) {
    inventario ?: throw EViewModel("Inventário não definido")
    usuario ?: throw EViewModel("Usuário não logado")
    val loja = inventario?.loja ?: throw EViewModel("Loja não identificada no iventário")
    val lote = Lote.findNumLote(value, loja) ?: throw EViewModel("Lote não encontrado")
    coleta = Coleta.findColetaAberta(inventario, lote, usuario)
    if(coleta == null)
      coleta = Coleta.novaColetaAberta(inventario, lote, usuario)
    else
      throw EViewModel("Já existe uma coleta aberta")
  }

  private fun processaInventario(value: String) {
    val numero = value.toIntOrNull() ?: throw EViewModel("O número do inventário é inválido")
    val inventariosAberto = Inventario.inventariosAberto()
    if(inventariosAberto.isEmpty()) throw EViewModel("Não existe nenhum inventário aberto")
    this.inventario = inventariosAberto.firstOrNull {it.numero == numero} ?: throw EViewModel(
      "Nenum ivnetnario aberto encontrado com este número")
  }

  private fun processaMatricula(value: String) {
    val matricula = value.toIntOrNull() ?: throw EViewModel("Matrícula inválida")
    this.usuario = Usuario.find(matricula) ?: throw EViewModel("Matrícula não encontrada")
  }
}


enum class TipoLeitura {
  MATRICULA, INVENTARIO, LOTE, COLETA
}