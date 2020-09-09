package RestAssured

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class RestAssured {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(RestAssured::class.java, *args)
        }
    }
}