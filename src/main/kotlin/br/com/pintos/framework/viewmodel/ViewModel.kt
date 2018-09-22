package br.com.pintos.framework.viewmodel

import br.com.pintos.framework.model.Transaction

abstract class ViewModel(val view: IView) {
  private var inExcection = false

  @Throws(EViewModel::class)
  fun <T> execValue(block: () -> T?): T? {
    return transaction {
      try {
        view.updateModel()
        block()
      } catch (e: EViewModel) {
        throw e
      } finally {
        view.updateView()
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
    return transaction {
      try {
        if (inExcection)
          block()
        else {
          inExcection = true
          view.updateModel()

          block()

          view.updateView()
          inExcection = false
        }
      } catch (e: EViewModel) {
        throw e
      } finally {
        view.updateView()
      }
    }
  }

  @Throws(EViewModel::class)
  fun <T> execList(block: () -> List<T>): List<T> {
    return execValue(block).orEmpty()
  }

  private fun <T> transaction(block: () -> T): T {
    return try {
      val ret = block()
      Transaction.commit()
      ret
    } catch (e: Throwable) {
      Transaction.rollback()
      throw e
    }
  }
}

class EViewModel(msg: String) : Exception(msg)

interface IView {
  val viewModel: ViewModel
  fun updateView()

  fun updateModel()
}

