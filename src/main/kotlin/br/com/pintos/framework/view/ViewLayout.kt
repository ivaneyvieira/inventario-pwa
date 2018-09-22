package br.com.pintos.framework.view

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.ViewModel
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.data.binder.Binder

abstract class ViewLayout<VM : ViewModel>(classViewModel : Class<VM>) : IView, VerticalLayout() {
  abstract override val viewModel: VM
  val binder = Binder<VM>(classViewModel)

  override fun updateView() {
    binder.readBean(viewModel)
  }

  override fun updateModel() {
    binder.writeBean(viewModel)
  }
}