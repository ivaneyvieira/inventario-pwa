package br.com.pintos.inventario.view.coletor

import br.com.pintos.inventario.view.coletor.components.AppHeaderLayout
import br.com.pintos.inventario.view.coletor.components.appDrawer
import br.com.pintos.inventario.view.coletor.components.appHeader
import br.com.pintos.inventario.view.coletor.components.appToolbar
import br.com.pintos.inventario.view.coletor.components.navMenuItem
import br.com.pintos.inventario.view.coletor.components.paperIconButton
import com.github.vok.karibudsl.flow.div
import com.github.vok.karibudsl.flow.label
import com.github.vok.karibudsl.flow.textField
import com.vaadin.flow.component.HasElement
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.notification.Notification
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.page.BodySize
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLayout
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import javax.management.Query.div

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
      setSizeFull(); classNames.add("app-content")
    }
  }

  override fun showRouterLayoutContent(content: HasElement) {
    this.content.element.appendChild(content.element)
  }
}
