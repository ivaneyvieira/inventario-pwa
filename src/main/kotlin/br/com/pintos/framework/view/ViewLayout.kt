package br.com.pintos.framework.view

import br.com.pintos.framework.viewmodel.IView
import br.com.pintos.framework.viewmodel.ViewModel
import com.github.vok.karibudsl.flow.formLayout
import com.github.vok.karibudsl.flow.horizontalLayout
import com.github.vok.karibudsl.flow.label
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.formlayout.FormLayout
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.data.binder.Binder
import org.claspina.confirmdialog.ConfirmDialog

abstract class ViewLayout<VM : ViewModel>(classViewModel: Class<VM>) : IView, VerticalLayout() {
  val viewModel: VM = createViewModel()

  abstract fun createViewModel(): VM

  val binder = Binder<VM>(classViewModel)
  abstract val title: String

  abstract fun FormLayout.initForm()

  abstract fun HorizontalLayout.initButton()

  init {
    label(title)
    formLayout {
      this.initForm()
    }
    horizontalLayout {
      this.initButton()
    }
  }

  override fun updateView() {
    binder.readBean(viewModel)
  }

  override fun updateModel() {
    binder.writeBean(viewModel)
  }

  override fun navigate(view: Class<*>) {
    ui.ifPresent { ui ->
      @Suppress("UNCHECKED_CAST")
      val viewClass = view as? Class<Component>
      viewClass?.let {
        ui.navigate(viewClass)
      }
    }
  }

  override fun showErro(message: String?) {
    ConfirmDialog
            .createWarning()
            .withCaption("Aviso")
            .withMessage(message)
            .open()
  }
}



