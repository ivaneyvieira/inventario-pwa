package br.com.pintos.framework.viewmodel

import br.com.pintos.framework.model.Transaction

open class ViewModel(val view: IView) {
  private var inTransaction = false

  @Throws(EViewModel::class)
  fun <T> execValue(block: () -> T?): T? {
    return transaction {
      try {
        if (inTransaction)
          block()
        else {
          inTransaction = true
          view.updateModel()
          val ret = block()

          view.updateView()
          inTransaction = false
          ret
        }
      } catch (e: EViewModel) {
        view.updateView()
        throw e
      }
    }
  }

  @Throws(EViewModel::class)
  fun execString(block: () -> String): String {
    return execValue(block) ?: ""
  }

  @Throws(EViewModel::class)
  fun execInt(block: () -> Int): Int {
    return execValue(block) ?: 0
  }

  @Throws(EViewModel::class)
  fun exec(block: () -> Unit) {
    transaction {
      try {
        if (inTransaction)
          block()
        else {
          inTransaction = true
          view.updateModel()

          block()

          view.updateView()
          inTransaction = false
        }
      } catch (e: EViewModel) {
        view.updateView()
        throw e
      }
    }
  }

  @Throws(EViewModel::class)
  fun <T> execList(block: () -> List<T>): List<T> {
    return execValue(block).orEmpty()
  }

  private fun <T> transaction(block: () -> T): T? {
    return try {
      val ret = block()
      Transaction.commit()
      ret
    } catch (e: Throwable) {
      Transaction.rollback()
      view.showErro(e.message)
      null
    }
  }
}

class EViewModel(msg: String) : Exception(msg)

interface IView {
  fun updateView()

  fun updateModel()

  fun navigate(view: Class<*>)

  fun showErro(message: String?)
}

