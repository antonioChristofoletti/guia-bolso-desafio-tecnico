import app.routes.transacao.TransacaoRoute
import general.config.ConfigLoader
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder

class JavalinApp {
    val javalinInstance by lazy { Javalin.create() }

    fun start(port: Int = ConfigLoader.findConfigValue("api.port").toInt()) {
        if(javalinInstance.server()?.started != true) {
            javalinInstance.start(port).routes { configRoutes() }
        }
    }

    private fun configRoutes() {
        ApiBuilder.path("", TransacaoRoute)
    }

    fun stop() {
        if(javalinInstance.server()?.started != false) {
            javalinInstance.stop()
        }
    }
}

fun main() {
    val cloudServerPort: Int? = System.getenv("PORT")?.toIntOrNull()
    if(cloudServerPort != null) {
        JavalinApp().start(cloudServerPort)
    } else {
        JavalinApp().start()
    }
}