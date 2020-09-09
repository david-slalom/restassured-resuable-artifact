package test.kotlin

import com.jayway.restassured.RestAssured
import com.jayway.restassured.http.ContentType
import com.jayway.restassured.response.Cookie
import com.jayway.restassured.response.Response
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
abstract class AbstractRestAssured {

    @Before
    fun setUp() {
        /*
            Set up a port for your rest assured tests to run off of here, to avoid errors during runtime. 
            The setUp method can also be used to clear databases or run any sort of setup before running your tests, 
            The @Before tag runs before EACH Test, not before the class. 
        */
        RestAssured.port = 9000
    }

/*
    fun cleanUp() {
        /*
            Use this method to perform any clean up before after your test Classes,
            The @After annotation performs after EVERY test case.
        */
    }

 */

    //Preform A GET request
    protected fun getRequestGenerator(baseUri: String): Response {
        return RestAssured.given()
            .headers(
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
            .baseUri(baseUri)
            .get()
    }

    //Preform a POST request
    protected fun postRequestGenerator(baseUri: String, payload: Any): Response {
        return RestAssured.given()
            .headers(
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
            .baseUri(baseUri)
            .body(payload)
            .post()
    }

    //Preform a PUT Request
    protected fun putRequestGenerator(baseUri: String, payload: Any): Response {
        return RestAssured.given()
            .headers(
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
            .baseUri(baseUri)
            .body(payload)
            .put()
    }
}
