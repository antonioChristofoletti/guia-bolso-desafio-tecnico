package general.config

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.javalin.http.InternalServerErrorResponse

object ConfigLoader {
    private val jsonNodeConfig: JsonNode by lazy {
        val configFile = javaClass.classLoader.getResource("config/config.json")
        ObjectMapper().readTree(configFile)
    }

    private fun findNodeValue(jsonNode: JsonNode, pathList: List<String>): String? {
        val foundNode = jsonNode[pathList.first()] ?: return null

        return if (pathList.size == 1) {
            foundNode.asText()
        } else {
            findNodeValue(foundNode, pathList.subList(1, pathList.size))
        }
    }

    fun findConfigValue(path: String): String {
        return findNodeValue(jsonNodeConfig, path.split(".")) ?: throw InternalServerErrorResponse()
    }
}