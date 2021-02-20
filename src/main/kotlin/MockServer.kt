import app.routes.transacao.TransacaoRoute
import general.config.ConfigLoader
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.path

fun main() {
    val port = ConfigLoader.findConfigValue("api.port").toInt()

    Javalin.create().start(port).routes {
        path("", TransacaoRoute)
    }
}