package app.controller

import app.dao.transacao.ITransacaoDao
import app.dao.transacao.TransacaoDaoRandomValues

object TransacaoController {
    val transacaoDao: ITransacaoDao = TransacaoDaoRandomValues

    fun getTransacaoList(id: Int, mes: Int, ano: Int) = transacaoDao.getTransacaoList(id, mes, ano)
}