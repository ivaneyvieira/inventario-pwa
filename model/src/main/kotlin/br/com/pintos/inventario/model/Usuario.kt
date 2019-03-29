package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.finder.UsuarioFinder
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "usuario")
class Usuario(
  var matricula: Int,
  var nome: String,
  var senha: String,
  var apelido: String
) : SimpleBaseModel() {
  companion object Find : UsuarioFinder() {
    fun find(matricula: Int?): Usuario? {
      matricula ?: return null
      return where().matricula.eq(matricula).findOne()
    }
  }
}
