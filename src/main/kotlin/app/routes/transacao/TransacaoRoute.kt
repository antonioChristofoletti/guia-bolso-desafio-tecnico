package app.routes.transacao

import app.controller.TransacaoController
import general.utils.ParamsValidator.Companion.checkParamIntMonth
import general.utils.ParamsValidator.Companion.checkParamIntRange
import io.javalin.apibuilder.EndpointGroup
import io.javalin.apibuilder.ApiBuilder.get

object TransacaoRoute : EndpointGroup {
    override fun addEndpoints() {
        get(":id/transacoes/:ano/:mes") { ctx ->
            val id = ctx.pathParam<Int>("id").apply { checkParamIntRange(this, 1000, 100000) }.get()

            val mes = ctx.pathParam<Int>("mes").apply { checkParamIntMonth(this) }.get()

            val ano = ctx.pathParam<Int>("ano").apply { checkParamIntRange(this, 0) }.get()

            val transacaoList = TransacaoController.getTransacaoList(id, mes, ano)

            ctx.json(transacaoList)
        }
    }
}