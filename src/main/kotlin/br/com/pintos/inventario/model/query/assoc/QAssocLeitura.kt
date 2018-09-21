package br.com.pintos.inventario.model.query.assoc

import br.com.pintos.inventario.model.EStatusLeitura
import br.com.pintos.inventario.model.Leitura
import io.ebean.typequery.PEnum
import io.ebean.typequery.PInteger
import io.ebean.typequery.PLocalTime
import io.ebean.typequery.PLong
import io.ebean.typequery.PString
import io.ebean.typequery.TQAssocBean
import io.ebean.typequery.TypeQueryBean

/**
 * Association query bean for AssocLeitura.
 *
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@TypeQueryBean
class QAssocLeitura<R>(name: String, root: R) : TQAssocBean<Leitura, R>(name, root) {
    lateinit var id: PLong<R>
    lateinit var version: PInteger<R>
    lateinit var hora: PLocalTime<R>
    lateinit var leitura: PString<R>
    lateinit var observacao: PString<R>
    lateinit var quant: PInteger<R>
    lateinit var status: PEnum<R, EStatusLeitura>
    lateinit var coleta: QAssocColeta<R>
    lateinit var produto: QAssocProduto<R>
    lateinit var saldo: PInteger<R>
    // type safe fetch(properties) using varargs not supported yet ...
}
