package app.dao.transacao

import app.model.Transacao
import general.utils.DateUtils.Companion.createRandomDate
import general.utils.StringGeneratorUtils.Companion.createPhrase

object TransacaoDaoRandomValues: ITransacaoDao {
    override fun getTransacaoList(id: Int, mes: Int, ano: Int): List<Transacao> {
        val quantityTransacoes = id.toString().substring(0, 1).toInt() * mes

        return (1..quantityTransacoes).map { i ->
            val value = calcValue(id, mes, i)

            val description = createPhrase()
            val date = createRandomDate(mes, ano)

            Transacao(date, description, value)
        }.toList()
    }

    private fun calcValue(id: Int, mes: Int, i: Int): Int {
        val negativeOrPositive = when {
            i % 5 == 0 -> 1
            else -> -1
        }

        return (id - mes + i) * negativeOrPositive
    }
}