package utils

import io.ktor.client.features.ClientRequestException
import io.ktor.http.HttpStatusCode

abstract class RequestTestUtils {
    companion object {
        fun checkStatus(goodRequestMessage: String = "The param should be invalid", httpStatusCode: HttpStatusCode, request: () -> Any?) {
            try {
                request()
                assert(false) { goodRequestMessage }
            } catch (e: ClientRequestException) {
                assert(e.response.status == httpStatusCode) { "Unexpected error. Error: ${e.message}" }
            } catch (e: Exception) {
                assert(false) { "Unexpected error. Error: ${e.message}" }
            }
        }

        fun checkBadRequest(goodRequestMessage: String = "The param should not be valid", request: () -> Any?) {
            checkStatus(goodRequestMessage, HttpStatusCode.BadRequest, request)
        }

        fun checkNotFound(goodRequestMessage: String = "The URL should not be found", request: () -> Any?) {
            checkStatus(goodRequestMessage, HttpStatusCode.NotFound, request)
        }
    }
}