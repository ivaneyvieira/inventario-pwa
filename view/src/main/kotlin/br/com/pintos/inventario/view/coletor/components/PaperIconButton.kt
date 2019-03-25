package br.com.pintos.inventario.view.coletor.components

import com.github.mvysny.karibudsl.v10.VaadinDsl
import com.github.mvysny.karibudsl.v10.init
import com.vaadin.flow.component.ClickNotifier
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.Tag
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.icon.VaadinIcon

@Tag("paper-icon-button")
@HtmlImport("frontend://bower_components/paper-icon-button/paper-icon-button.html")
class PaperIconButton(collection: String, icon: String): Component(), ClickNotifier<PaperIconButton> {
  /**
   * Creates an icon component that displays given Vaadin [icon].
   */
  constructor(icon: VaadinIcon): this("vaadin", icon.name.toLowerCase().replace('_', '-'))

  init {
    element.setAttribute("icon", "$collection:$icon")
  }
}

fun (@VaadinDsl HasComponents).paperIconButton(icon: VaadinIcon, block: (@VaadinDsl PaperIconButton).() -> Unit = {}) =
  init(PaperIconButton(icon), block)
