package com.pageObjects

import com.helper.ConstantsData.URLS.select_flight
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object SelectFlightPage {
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

  val headers_resource = Map(
    "Referer" -> "https://blazedemo.com/purchase.php",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" -> "?0")

  val selectFlight = http("selectFlightReq")
    .post(select_flight)
    .headers(headers_select_flight)
    .formParamSeq(
      Seq(
        ("flight","inputFlight"),
        ("price", "inputPrice"),
        ("airline","inputAirline"),
        ("fromPort", "inputFromPort"),
        ("toPort", "inputToPort")
      ))
    .resources(http("resource_11")
      .get("/assets/bootstrap.min.js")
      .headers(headers_resource),
      http("resource_12")
        .get("/assets/bootstrap-table.js")
        .headers(headers_resource),
      http("resource_13")
        .get("/assets/bootstrap.min.css")
        .headers(headers_resource),
      http("resource_14")
        .get("/assets/bootstrap-table.css")
        .headers(headers_resource),
      http("resource_15")
        .get("/favicon.ico")
        .headers(headers_resource)
    )
    .check(status.is(200))
    .check(css("h2:contains('Your flight')").exists)
}
