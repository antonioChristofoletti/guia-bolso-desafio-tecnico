package api.routes.general

import BaseModelTest.Companion.baseUrl
import general.utils.HttpRequestUtils
import org.junit.jupiter.api.Test
import utils.RequestTestUtils.Companion.checkNotFound

class UnavailableEndPointsTest {
    @Test
    fun `Check response for unavailable end-point`() {
        checkNotFound { HttpRequestUtils.get<String>("$baseUrl/transacao/1000") }
    }
}