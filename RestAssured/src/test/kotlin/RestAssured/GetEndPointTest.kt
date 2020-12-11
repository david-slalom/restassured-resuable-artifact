package RestAssured

import org.junit.Assert
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import test.kotlin.AbstractRestAssured

@Profile("local")
class GetEndPointTest: AbstractRestAssured() {

    @Test
    @Throws(Exception::class)
    fun `Get Endpoint`() {

        val baseUri = "http://localhost:8080/restassured/api/get"

        //Preform your request here after declaring all parameters.
        val response = getRequestGenerator(baseUri)

        //Neatly Print out your responses.
        response.body.prettyPrint()

        //You can Preform many different assertion actions here.
        Assert.assertEquals("Request returns expected 200 OK.", 200, response.statusCode)
    }
}
