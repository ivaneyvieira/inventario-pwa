package br.com.pintos.inventario.view.coletor.pages


import br.com.astrosoft.framework.ui.view.LayoutView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.ColetaViewModel
import com.github.mvysny.karibudsl.v10.bind
import com.github.mvysny.karibudsl.v10.button
import com.github.mvysny.karibudsl.v10.flexGrow
import com.github.mvysny.karibudsl.v10.horizontalLayout
import com.github.mvysny.karibudsl.v10.textField
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.data.converter.StringToIntegerConverter
import com.vaadin.flow.router.BeforeLeaveEvent
import com.vaadin.flow.router.Route

@Route(layout = MainLayout::class)
class ColetaView : LayoutView<ColetaViewModel>() {
  override val viewModel: ColetaViewModel
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

  override fun beforeLeave(event: BeforeLeaveEvent) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun updateView(viewModel: ViewModel) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun updateModel() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}