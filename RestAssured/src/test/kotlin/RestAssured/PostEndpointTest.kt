package RestAssured

import org.junit.Assert
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import test.kotlin.AbstractRestAssured

@Profile("local")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PostEndpointTest: AbstractRestAssured() {

    @Test
    fun `Post Endpoint`() {
        //Your body can be any type of value, object, or type, does not need to be strict JSON
        val body = "This is the value I created."

        val baseUri = "http://localhost:8080/restassured/api/create"

        //Preform your request here after declaring all parameters.
        val response = postRequestGenerator(baseUri, body)

        //Neatly Print out your responses.
        response.body.prettyPrint()

        //You can Preform many different assertion actions here.
        Assert.assertEquals("Request returns expected 201 OK.", 201, response.statusCode)
    }
}