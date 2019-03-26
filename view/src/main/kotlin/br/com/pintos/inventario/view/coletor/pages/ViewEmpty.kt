package br.com.pintos.inventario.view.coletor.pages

import br.com.pintos.inventario.view.coletor.MainLayout
import com.vaadin.flow.component.html.Label
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.router.Route

//@Route("", layout = MainLayout::class)
class ViewEmpty: HorizontalLayout() {
  init {
    val layout = HorizontalLayout()
    layout.setSizeFull()
    layout.isMargin = false
    layout.add(Label("< Teste >"))
    layout.alignItems = FlexComponent.Alignment.CENTER
    layout.justifyContentMode = JustifyContentMode.CENTER

    add(layout)
    isMargin = false
    setSizeFull()
    element.style.set("overflow", "auto")
  }
}