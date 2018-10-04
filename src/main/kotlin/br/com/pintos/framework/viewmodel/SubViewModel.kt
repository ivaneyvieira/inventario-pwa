package br.com.pintos.framework.viewmodel

import kotlin.reflect.KClass

open class SubViewModel(view: IView, private val classView : KClass<*>) : ViewModel(view) {
  fun doVoltar() = exec {
    view.navigate(classView)
  }
}