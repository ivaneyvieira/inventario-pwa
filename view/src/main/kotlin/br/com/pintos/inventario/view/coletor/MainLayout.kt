package br.com.pintos.inventario.view.coletor

import br.com.astrosoft.framework.ui.PWALayout
import br.com.pintos.inventario.view.coletor.pages.ViewEmpty
import com.vaadin.flow.component.icon.VaadinIcon.ABACUS
import com.vaadin.flow.component.page.Push
import com.vaadin.flow.component.page.Viewport
import com.vaadin.flow.server.PWA
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import javax.servlet.annotation.WebListener

@Push
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@Theme(Lumo::class, variant = Lumo.DARK)
@PWA(name = "Inventários Pintos", shortName = "Inventário", iconPath = "icons/logo.png", enableInstallPrompt = true)
class MainLayout: PWALayout() {
  init {
    init("Inventário") {
      appMenu {
        iconHeader("icons/logo.png")
        item("Teste", ABACUS, ViewEmpty::class.java)
        item("Teste 2", ABACUS, ViewEmpty::class.java)
      }
    }
  }
}

@WebListener
class Bootstrap: ServletContextListener {
  override fun contextDestroyed(sce: ServletContextEvent?) {
  }

  override fun contextInitialized(sce: ServletContextEvent?) {
    val home = System.getenv("HOME")
    val fileName = System.getenv("EBEAN_PROPS") ?: "$home/ebean.col.properties"
    System.setProperty("ebean.props.file", fileName)
    println("##################### $fileName")
  }
}
