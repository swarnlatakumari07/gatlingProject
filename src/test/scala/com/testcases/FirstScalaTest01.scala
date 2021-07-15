package com.testcases

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class FirstScalaTest01 extends Simulation {

  val httpProtocol = http.baseUrl("https://blazedemo.com/")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")

  val headers_home = Map(
    "accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  "accept-encoding" -> "gzip, deflate, br",
  "accept-language" -> "en-US,en;q=0.9",
    "cache-control" -> "max-age=0",
  "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
  "sec-ch-ua-mobile" -> "?0",
  "sec-fetch-dest" -> "document",
  "sec-fetch-mode" -> "navigate",
  "sec-fetch-site" -> "none",
  "sec-fetch-user" -> "?1",
  "upgrade-insecure-requests" -> "1"
  )

  val headers_1 = Map(
    "Referer" -> "https://blazedemo.com/",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" ->"?0"
  )

  val headers_2 = Map(
    "accept" -> "image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-US,en;q=0.9",
    "pragma" -> "no-cache",
    "referer" -> "https://blazedemo.com/",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "image",
    "sec-fetch-mode" -> "no-cors",
    "sec-fetch-site" -> "same-origin"
  )

  val headers_find_flight = Map(
    "accept" -> " text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "accept-encoding" -> "gzip, deflate, br",
    "accept-language" -> "en-US,en;q=0.9",
    "cache-control" -> "max-age=0",
    "content-length" -> "34",
    "content-type" -> "application/x-www-form-urlencoded",
    "origin" -> "https://blazedemo.com",
    "referer" -> "https://blazedemo.com/",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" -> "?0",
    "sec-fetch-dest" -> "document",
    "sec-fetch-mode" -> "navigate",
    "sec-fetch-site" -> "same-origin",
    "sec-fetch-user" -> "?1",
    "upgrade-insecure-requests" -> "1"
  )

  val headers_3 = Map(
    "Referer" -> "https://blazedemo.com/reserve.php",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" -> "?0")

  val headers_select_flight = Map(
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

  val headers_4 = Map(
    "Referer" -> "https://blazedemo.com/purchase.php",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" -> "?0")

  val flightSelectionScenario = scenario("GatlingFirstTestcase")
    .exec(http("HomePageReq")
      .get("/")
      .headers(headers_home)
      .resources(http("req_1")
          .get("/assets/bootstrap.min.js")
          .headers(headers_1),
        http("req_2")
            .get("/assets/bootstrap-table.js")
            .headers(headers_1),
        http("req_3")
            .get("/assets/bootstrap.min.css")
            .headers(headers_1),
        http("req_4")
            .get("/assets/bootstrap-table.css")
            .headers(headers_1),
        http("req_5")
        .get("/favicon.ico")
        .headers(headers_2))
      .check(status.is(200)))
    .pause(5)
    .exec(http("FindFlightReq")
        .post("/reserve.php")
        .headers(headers_find_flight)
        .formParam("fromPort", "Philadelphia")
        .formParam("toPort", "Berlin")
        .resources(http("req_6")
          .get("/assets/bootstrap.min.js")
          .headers(headers_3),
          http("req_7")
          .get("/assets/bootstrap-table.js")
          .headers(headers_3),
          http("req_8")
            .get("/assets/bootstrap.min.css")
            .headers(headers_3),
          http("req_9")
            .get("/assets/bootstrap-table.css")
            .headers(headers_3),
          http("req_10")
            .get("/favicon.ico")
            .headers(headers_3))
        .check(status.is(200))
        .check(css("input[name='flight']", "value").saveAs("inputFlight"))
        .check(css("input[name='price']", "value").saveAs("inputPrice"))
        .check(css("input[name='airline']", "value").saveAs("inputAirline"))
        .check(css("input[name='fromPort']", "value").saveAs("inputFromPort"))
        .check(css("input[name='toPort']", "value").saveAs("inputToPort")))
    .pause(10)
    .exec(http("selectFlightReq")
      .post("/purchase.php")
      .headers(headers_select_flight)
      .formParam("flight","inputFlight")
      .formParam("price", "inputPrice")
      .formParam("airline","inputAirline")
      .formParam("fromPort", "inputFromPort")
      .formParam("toPort", "inputToPort")
      .resources(http("req_11")
          .get("/assets/bootstrap.min.js")
          .headers(headers_4),
        http("req_12")
          .get("/assets/bootstrap-table.js")
          .headers(headers_4),
        http("req_13")
          .get("/assets/bootstrap.min.css")
          .headers(headers_4),
        http("req_14")
          .get("/assets/bootstrap-table.css")
          .headers(headers_4),
        http("req_15")
          .get("/favicon.ico")
          .headers(headers_4)
      )
      .check(status.is(200))
      .check(css("h2:contains('Your flight')").exists))
  setUp(flightSelectionScenario.inject(atOnceUsers(5))).protocols(httpProtocol)

}
