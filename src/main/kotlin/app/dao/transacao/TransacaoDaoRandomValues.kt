package app.dao.transacao

import app.model.Transacao
import general.utils.DateUtils
import general.utils.WordGeneratorUtils

object TransacaoDaoRandomValues: ITransacaoDao {
    override fun getTransacaoList(id: Int, mes: Int, ano: Int): List<Transacao> {
        val quantityTrancoes = id.toString().first().toInt() * mes

        return (0..quantityTrancoes).asSequence().map { i ->
            val value = id + mes + i
            val description = WordGeneratorUtils.createPhrase()
            val date = DateUtils.createRandomDate(mes, ano)

            println(date.toString())

            Transacao(date, description, value)
        }.toList()
    }
}