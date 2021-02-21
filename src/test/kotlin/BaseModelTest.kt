import general.config.ConfigLoader
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
class BaseModelTest {
    companion object {
        @Container
        val port = ConfigLoader.findConfigValue("test.port").toInt()

        @Container
        val baseUrl = "${ConfigLoader.findConfigValue("test.baseUrl")}:$port"

        @Container
        val apiManager = JavalinApp().apply {
            this.start(port)
            println("\n\n")
        }
    }
}