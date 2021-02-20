package app.dao.transacao

import app.model.Transacao

interface ITransacaoDao {
    fun getTransacaoList(id: Int, mes: Int, ano: Int): List<Transacao>
}