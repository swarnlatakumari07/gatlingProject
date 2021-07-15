package blazemeter

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BlazemeterPricing extends Simulation {

	val httpProtocol = http.baseUrl("http://www.demoblaze.com")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("vi,en-US;q=0.9,en;q=0.8")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Accept" -> "*/*",
		"Origin" -> "http://www.demoblaze.com")

	val headers_2 = Map("Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8")

	val uri1 = "https://ajax.googleapis.com/ajax/libs/jquery"
	val uri2 = "https://unpkg.com"
	val uri3 = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"

	val scn = scenario("BlazemeterPricing")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
				.get("/css/fonts/Lato-Regular.woff2")
				.headers(headers_1),
				http("request_2")
					.get("/imgs/front.jpg")
					.headers(headers_2)))
		.pause(8)
		.exec(http("request_3")
			.get("/cart.html")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)

}