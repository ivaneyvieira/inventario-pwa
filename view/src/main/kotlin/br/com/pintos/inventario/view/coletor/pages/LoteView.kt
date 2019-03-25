package br.com.pintos.inventario.view.coletor.pages

import br.com.astrosoft.framework.ui.view.LayoutView
import br.com.astrosoft.framework.viewmodel.ViewModel
import br.com.pintos.inventario.view.coletor.MainLayout
import br.com.pintos.inventario.viewmodel.LoteViewModel
import com.vaadin.flow.router.BeforeLeaveEvent
import com.vaadin.flow.router.Route

@Route(layout = MainLayout::class)
class LoteView : LayoutView<LoteViewModel>() {
  override val viewModel: LoteViewModel
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