package api.routes.transacao

import BaseModelTest.Companion.baseUrl
import app.model.Transacao
import general.utils.DateUtils.Companion.getFirstMonthMoment
import general.utils.DateUtils.Companion.getLastMonthMoment
import general.utils.DateUtils.Companion.getRandomMonth
import general.utils.DateUtils.Companion.getRandomYear
import general.utils.HttpRequestUtils.Companion.get
import org.junit.jupiter.api.Test
import utils.RequestTestUtils.Companion.checkBadRequest
import kotlin.random.Random

class TransacaoListGetTest {
    private fun getTransacaoList(id: Int?, ano: Int?, mes: Int?): List<Transacao> = get("$baseUrl/$id/transacoes/$ano/$mes")

    private fun getRandomUserId() = Random.nextInt(1000, 100001)

    @Test
    fun `Check invalid url params 'id', rule, 'id' higher or equal to 1000 and lower or equal to 100000`() {
        intArrayOf(-100, 999, 100001).forEach {
            checkBadRequest("The param 'id' with the value '$it' should be invalid") {
                getTransacaoList(it, getRandomYear(), getRandomMonth())
            }
        }
    }

    @Test
    fun `Check invalid url params 'ano', rule, 'ano' higher or equal to 0`() {
        intArrayOf(-1000, -1).forEach {
            checkBadRequest("The param 'ano' with the value '$it' should be invalid") {
                getTransacaoList(getRandomUserId(), it, getRandomMonth())
            }
        }
    }

    @Test
    fun `Check invalid url params 'mes', rule, 'mes' higher or equal to 1 and month lower or equal to 12`() {
        intArrayOf(-1000, 0).forEach {
            checkBadRequest("The param 'mes' with the value '$it' should be invalid") {
                getTransacaoList(getRandomUserId(), getRandomYear(), it)
            }
        }
    }

    @Test
    fun `Check quantity transacoes received, rule, User's ID first digit times month is equal to the quantity`() {
        try {
            val id = getRandomUserId()
            val mes = getRandomMonth()

            val correctQuantity = id.toString().substring(0, 1).toInt() * mes
            val quantityReturned = getTransacaoList(id, getRandomYear(), mes).count()

            assert(quantityReturned == correctQuantity) {
                "The quantity is invalid. It should return $correctQuantity, but returned $quantityReturned"
            }
        } catch (e: Exception) {
            assert(false) { "Unexpected error. Error: ${e.message}" }
        }
    }

    @Test
    fun `Check transacoes's data respecting mes e ano`() {
        try {
            val mes = getRandomMonth()
            val ano = getRandomYear()

            val startDate = getFirstMonthMoment(mes, ano)
            val endDate = getLastMonthMoment(mes, ano)

            getTransacaoList(getRandomUserId(), ano, mes).forEach {
                assert(it.data.after(startDate) && it.data.before(endDate)) {
                    "The Transacao's data is out of range: $startDate and $endDate"
                }
            }
        } catch (e: Exception) {
            assert(false) { "Unexpected error. Error: ${e.message}" }
        }
    }

    @Test
    fun `Check size transacoes's descricao, rule, value size lower or equal to 60`() {
        try {
            getTransacaoList(getRandomUserId(), getRandomYear(), getRandomMonth()).forEach {
                assert(it.descricao.count() <= 60) {
                    "The Transacao's decricao needs to be lower than 60"
                }
            }
        } catch (e: Exception) {
            assert(false) { "Unexpected error. Error: ${e.message}" }
        }
    }

    @Test
    fun `Check value transacoes's valor, rule, 'valor' higher or equal to -9999999 and lower or equal to 9999999`() {
        try {
            getTransacaoList(getRandomUserId(), getRandomYear(), getRandomMonth()).forEach {
                assert(it.valor >= -9999999 && it.valor <= 9999999)
            }
        } catch (e: Exception) {
            assert(false) { "Unexpected error. Error: ${e.message}" }
        }
    }

    @Test
    fun `Check transacoes's valor is the same in 2 request with the same params`() {
        try {
            val userId = getRandomUserId()
            val mes = getRandomMonth()
            val ano = getRandomYear()

            val list1 = getTransacaoList(userId, ano, mes)
            val list2 = getTransacaoList(userId, ano, mes)

            list1.forEachIndexed { i, transacao ->
                assert(transacao.valor == list2[i].valor) {
                    "The transacoes's valor should always return the same value for the same url params"
                }
            }
        } catch (e: Exception) {
            assert(false) { "Unexpected error. Error: ${e.message}" }
        }
    }
}