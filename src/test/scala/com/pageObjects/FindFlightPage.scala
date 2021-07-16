package com.pageObjects

import com.helper.ConstantsData.URLS.find_flight
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object FindFlightPage {
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

  val headers_resources = Map(
    "Referer" -> "https://blazedemo.com/reserve.php",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" -> "?0")

  val findFlight = http("FindFlightReq")
    .post(find_flight)
    .headers(headers_find_flight)
    .formParam("fromPort", "Philadelphia")
    .formParam("toPort", "Berlin")
    .resources(http("req_6")
      .get("/assets/bootstrap.min.js")
      .headers(headers_resources),
      http("req_7")
        .get("/assets/bootstrap-table.js")
        .headers(headers_resources),
      http("req_8")
        .get("/assets/bootstrap.min.css")
        .headers(headers_resources),
      http("req_9")
        .get("/assets/bootstrap-table.css")
        .headers(headers_resources),
      http("req_10")
        .get("/favicon.ico")
        .headers(headers_resources))
    .check(status.is(200))
    .check(css("input[name='flight']", "value").saveAs("inputFlight"))
    .check(css("input[name='price']", "value").saveAs("inputPrice"))
    .check(css("input[name='airline']", "value").saveAs("inputAirline"))
    .check(css("input[name='fromPort']", "value").saveAs("inputFromPort"))
    .check(css("input[name='toPort']", "value").saveAs("inputToPort"))
}
