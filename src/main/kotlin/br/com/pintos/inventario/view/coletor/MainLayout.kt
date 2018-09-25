package br.com.pintos.inventario.view.coletor

import br.com.pintos.inventario.model.Inventario
import br.com.pintos.inventario.model.Usuario
import br.com.pintos.inventario.view.coletor.components.AppHeaderLayout
import br.com.pintos.inventario.view.coletor.components.appHeader
import br.com.pintos.inventario.view.coletor.components.appToolbar
import com.github.vok.karibudsl.flow.div
import com.vaadin.flow.component.HasElement
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.page.BodySize
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.router.RouterLayout
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo

@BodySize(width = "100vw", height = "100vh")
@HtmlImport("frontend://styles.html")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes")
@Theme(Lumo::class)
class MainLayout : AppHeaderLayout(), RouterLayout {
  private val content: Div
  init {
    appHeader {
      appToolbar {
        title.text = "Coletor"
      }
    }
    content = div {
      setSizeFull()
      classNames.add("app-content")
    }
  }

  override fun showRouterLayoutContent(content: HasElement) {
    this.content.element.appendChild(content.element)
  }
}

