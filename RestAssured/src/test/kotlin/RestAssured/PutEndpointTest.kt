package RestAssured

import org.junit.Assert
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import test.kotlin.AbstractRestAssured

@Profile("local")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PutEndpointTest: AbstractRestAssured() {

    @Test

    fun `Put Endpoint`() {
        //Your body can be any type of value, object, or type, does not need to be strict JSON
        val body = "This is the value I updated"

        val baseUri = "http://localhost:8080/restassured/api/update"

        //Preform your request here after declaring all parameters.
        val response = putRequestGenerator(baseUri, body)

        //Neatly Print out your responses.
        response.body.prettyPrint()

        //You can Preform many different assertion actions here.
        Assert.assertEquals("Request returns expected 202 OK.", 202, response.statusCode)
    }
}
