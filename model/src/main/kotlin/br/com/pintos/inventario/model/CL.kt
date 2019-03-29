package br.com.pintos.inventario.model

import br.com.astrosoft.framework.model.SimpleBaseModel
import br.com.pintos.inventario.model.finder.CLFinder
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "cl")
class CL(var clno: Int, var departamento: String, var grupo: String, val secao: String): SimpleBaseModel() {
  companion object Find: CLFinder()
}
