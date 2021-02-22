package general.utils

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JacksonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

abstract class HttpRequestUtils {
    companion object {
        inline fun <reified T : Any> get(url: String): T {
            return runBlocking {
                val httpClient = HttpClient {
                    install(JsonFeature) { serializer = JacksonSerializer() }
                }

                httpClient.use { it.get<T>(url) }
            }
        }
    }
}