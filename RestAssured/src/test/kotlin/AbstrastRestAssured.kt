package test.kotlin

import com.jayway.restassured.RestAssured
import com.jayway.restassured.http.ContentType
import com.jayway.restassured.response.Cookie
import com.jayway.restassured.response.Response
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.authentication.TestingAuthenticationToken
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
abstract class AbstractRestAssured {
0
    @Before
    fun setUp() {
        /*
            Set up a port for your rest assured tests to run off of here, to avoid errors during runtime. 
            The setUp method can also be used to clear databases or run any sort of setup before running your tests, 
            The @Before tag runs before EACH Test, not before the class. 
        */
        RestAssured.port = 9000
    }
    }

    @After
    fun cleanUp() {
        /*
            Use this method to perfome any clean up before after your test Classes, 
            The @After annotation perfomes after EVERY test case.    
        */
    }

    //Preform A GET request
    protected fun getRequestGenerator(token: String, params: HashMap<String, String>, cookie: Cookie, baseUri: String): Response {
        return RestAssured.given()
            .headers(
                "Authorization",
                "Bearer $token",
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
            .queryParam(params.keys.first(), params.values.first())
            .cookie(cookie)
            .baseUri(baseUri)
            .get()
    }

    //Preform a POST request
    protected fun postRequestGenerator(token: String, params: HashMap<String, String>, cookie: Cookie, baseUri: String, payload: Any): Response {
        return RestAssured.given()
            .headers(
                "Authorization",
                "Bearer $token",
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
            .queryParam(params.keys.first(), params.values.first())
            .cookie(cookie)
            .baseUri(baseUri)
            .body(payload)
            .post()
    }

    //Preform a PUT Request
    protected fun putRequestGenerator(token: String, params: HashMap<String, String>, cookie: Cookie, baseUri: String, payload: Any): Response {
        return RestAssured.given()
            .headers(
                "Authorization",
                "Bearer $token",
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON)
            .queryParam(params.keys.first(), params.values.first())
            .cookie(cookie)
            .baseUri(baseUri)
            .body(payload)
            .put()
    }
}
