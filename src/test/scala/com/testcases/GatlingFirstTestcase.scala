package gatlingTestPackage

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GatlingFirstTestcase extends Simulation {

	val httpProtocol = http
		.baseUrl("https://blazedemo.com")
		.inferHtmlResources()
		.disableAutoReferer
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")

	val headers_0 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-US,en;q=0.9",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "none",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_1 = Map(
		"Referer" -> "https://blazedemo.com/",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_5 = Map(
		"accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-US,en;q=0.9",
		"pragma" -> "no-cache",
		"referer" -> "https://blazedemo.com/",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "image",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "same-origin")

	val headers_6 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-US,en;q=0.9",
		"origin" -> "https://blazedemo.com",
		"referer" -> "https://blazedemo.com/",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_7 = Map(
		"Referer" -> "https://blazedemo.com/reserve.php",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_12 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-US,en;q=0.9",
		"origin" -> "https://blazedemo.com",
		"referer" -> "https://blazedemo.com/reserve.php",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_13 = Map(
		"Referer" -> "https://blazedemo.com/purchase.php",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_18 = Map(
		"accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "en-US,en;q=0.9",
		"origin" -> "https://blazedemo.com",
		"referer" -> "https://blazedemo.com/purchase.php",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1",
		"upgrade-insecure-requests" -> "1")

	val headers_19 = Map(
		"Referer" -> "https://blazedemo.com/confirmation.php",
		"sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
		"sec-ch-ua-mobile" -> "?0")



	val scn = scenario("GatlingFirstTestcase")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/assets/bootstrap.min.js")
			.headers(headers_1),
            http("request_2")
			.get("/assets/bootstrap-table.js")
			.headers(headers_1),
            http("request_3")
			.get("/assets/bootstrap.min.css")
			.headers(headers_1),
            http("request_4")
			.get("/assets/bootstrap-table.css")
			.headers(headers_1),
            http("request_5")
			.get("/favicon.ico")
			.headers(headers_5)))
		.pause(27)
		.exec(http("request_6")
			.post("/reserve.php")
			.headers(headers_6)
			.formParam("fromPort", "Paris")
			.formParam("toPort", "Buenos Aires")
			.resources(http("request_7")
			.get("/assets/bootstrap.min.js")
			.headers(headers_7),
            http("request_8")
			.get("/assets/bootstrap-table.js")
			.headers(headers_7),
            http("request_9")
			.get("/assets/bootstrap.min.css")
			.headers(headers_7),
            http("request_10")
			.get("/assets/bootstrap-table.css")
			.headers(headers_7),
            http("request_11")
			.get("/favicon.ico")
			.headers(headers_7)))
		.pause(2)
		.exec(http("request_12")
			.post("/purchase.php")
			.headers(headers_12)
			.formParam("flight", "43")
			.formParam("price", "472.56")
			.formParam("airline", "Virgin America")
			.formParam("fromPort", "Paris")
			.formParam("toPort", "Buenos Aires")
			.resources(http("request_13")
			.get("/assets/bootstrap.min.js")
			.headers(headers_13),
            http("request_14")
			.get("/assets/bootstrap-table.js")
			.headers(headers_13),
            http("request_15")
			.get("/assets/bootstrap.min.css")
			.headers(headers_13),
            http("request_16")
			.get("/assets/bootstrap-table.css")
			.headers(headers_13),
            http("request_17")
			.get("/favicon.ico")
			.headers(headers_13)))
		.pause(21)
		.exec(http("request_18")
			.post("/confirmation.php")
			.headers(headers_18)
			.formParam("_token", "")
			.formParam("inputName", "abd")
			.formParam("address", "179 diving ct")
			.formParam("city", "arnold")
			.formParam("state", "md")
			.formParam("zipCode", "21012")
			.formParam("cardType", "visa")
			.formParam("creditCardNumber", "")
			.formParam("creditCardMonth", "11")
			.formParam("creditCardYear", "2017")
			.formParam("nameOnCard", "jdkjd")
			.resources(http("request_19")
			.get("/favicon.ico")
			.headers(headers_19)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}