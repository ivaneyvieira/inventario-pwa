package br.com.astrosoft.framework.ui.view

import br.com.astrosoft.framework.viewmodel.CrudViewModel
import br.com.astrosoft.framework.viewmodel.EntityVo

abstract class CrudLayoutView<C: EntityVo<*>, V: CrudViewModel<*, *, C>>: LayoutView<V>() {}