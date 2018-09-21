package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.inventario.view.coletor.MainLayout
import com.github.vok.karibudsl.flow.button
import com.github.vok.karibudsl.flow.h3
import com.github.vok.karibudsl.flow.setPrimary
import com.github.vok.karibudsl.flow.textField
import com.github.vok.karibudsl.flow.verticalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("", layout = MainLayout::class)
class MatriculaView : VerticalLayout() {
  init {
    h3("Login")
    verticalLayout {
      textField("Matrícula") {
        width="6em"
      }
      textField("Nome") {
        isEnabled = false
        width= "100%"
      }
      setSizeFull()
    }
    button("Login") {
      setPrimary()
    }
  }
}