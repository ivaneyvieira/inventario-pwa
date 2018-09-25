package br.com.pintos.framework.viewmodel

open class SubViewModel(view: IView, private val classView : Class<*>) : ViewModel(view) {
  fun doVoltar() = exec {
    view.navigate(classView)
  }
}