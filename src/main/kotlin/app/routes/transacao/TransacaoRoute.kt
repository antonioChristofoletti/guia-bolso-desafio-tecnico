package app.routes.transacao

import app.controller.TransacaoController
import general.utils.ParamsValidatorUtils.Companion.checkMonth
import general.utils.ParamsValidatorUtils.Companion.checkRange
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.EndpointGroup

object TransacaoRoute : EndpointGroup {
    override fun addEndpoints() {
        get(":id/transacoes/:ano/:mes") { ctx ->
            val id = ctx.pathParam<Int>("id").checkRange(1000, 100000).get()
            val mes = ctx.pathParam<Int>("mes").checkMonth().get()
            val ano = ctx.pathParam<Int>("ano").checkRange(0).get()

            val transacaoList = TransacaoController.getTransacaoList(id, mes, ano)

            ctx.json(transacaoList)
        }
    }
}