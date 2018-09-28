package br.com.pintos.inventario.viewmodel

import br.com.pintos.inventario.model.Coleta
import br.com.pintos.inventario.model.EStatusColeta.ABERTO
import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.Lote
import br.com.pintos.inventario.model.Usuario

class UserInformation {
  fun initColeta() {
    coleta = Coleta.findColetaAberta(inventario, lote, usuario) ?: novaColeta()
  }

  private fun novaColeta(): Coleta? {
    val inv = inventario ?: return null
    val lot = lote ?: return null
    val usu = usuario ?: return null
    return Coleta(
      numleitura = Coleta.novoNumero(inv, lot),
      inventario = inv,
      lote = lot,
      usuario = usu,
      coletor = 0,
      status = ABERTO
    )
  }

  var usuario: Usuario? = null
  var inventario: Inventario? = null
  var lote: Lote? = null
  val usuarioApelido
    get() = userInformation.usuario?.apelido
  val inventarioLoja
    get() = userInformation.inventario?.loja?.nome
  var coleta: Coleta? = null
  val quantidade: Int?
    get() = coleta?.quantidadeLeitura()
  val loteColeta
    get() = "${lote?.numero?.padStart(3, '0')}/${coleta?.numleitura?.toString()?.padStart(2, '0')}"
}

val userInformation = UserInformation()