package br.com.pintos.inventario.viewmodel

import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.Usuario

class UserInformation {
  fun initColeta(){
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var usuario: Usuario? = null
  var inventario: Inventario? = null
  var lote: Lote? = null
  val usuarioApelido
    get() = userInformation.usuario?.apelido
  val inventarioLoja
    get() = userInformation.inventario?.loja?.nome
  val coleta: Coleta? = null
  val quantidade: Int?
    get() = coleta?.quantidadeLeitura()
  val loteColeta
    get() = "${lote?.numero?.padStart(3, '0')}/${coleta?.numleitura?.toString()?.padStart(2, '0')}"
}

val userInformation = UserInformation()