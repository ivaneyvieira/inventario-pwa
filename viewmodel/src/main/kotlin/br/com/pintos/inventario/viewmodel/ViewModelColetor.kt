package br.com.pintos.inventario.viewmodel

import br.com.astrosoft.framework.viewmodel.IView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.Inventario
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
  var lote: Lote? = null
  var coleta: Coleta? = null
  val tipoLeitura: TipoLeitura
    get() = when {
      inventario == null -> INVENTARIO
      usuario == null    -> MATRICULA
      lote == null       -> LOTE
      else               -> COLETA
    }
  val labelField: String
    get() = when(tipoLeitura) {
      MATRICULA  -> "Matrícula do usuário"
      INVENTARIO -> "Número do inventário"
      LOTE       -> "Número do lote"
      COLETA     -> "Código de barras"
    }
}

enum class TipoLeitura {
  MATRICULA, INVENTARIO, LOTE, COLETA
}