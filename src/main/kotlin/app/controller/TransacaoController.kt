package app.controller

import app.dao.transacao.TransacaoDaoRandomValues

object TransacaoController {
    val transacaoDao = TransacaoDaoRandomValues

    fun getTransacaoList(id: Int, mes: Int, ano: Int) = transacaoDao.getTransacaoList(id, mes, ano)
}