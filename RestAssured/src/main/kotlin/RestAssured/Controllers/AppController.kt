package RestAssured.Controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AppController {

    @GetMapping("/get")
    fun getHelloWorld(): ResponseEntity<*> {
        return ResponseEntity.ok("Hello, World! - from Microservice <3")
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun postInput(@RequestBody String: String): String{
        return String
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun putUpdate(@RequestBody String: String): String{
        return String
    }

}