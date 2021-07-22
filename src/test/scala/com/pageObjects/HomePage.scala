package com.pageObjects

import com.helper.ConstantsData.URLS.home_page
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object HomePage {

  val headers_home = Map (
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
  val headers_resources_1 = Map(
    "Referer" -> "https://blazedemo.com/",
    "sec-ch-ua" -> """ Not;A Brand";v="99", "Google Chrome";v="91", "Chromium";v="91""",
    "sec-ch-ua-mobile" ->"?0"
  )

  val headers_resources_2 = Map(
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

  val verifyHomePage = http("verify home page")
    .get(home_page)
    .headers(headers_home)
    .resources(http("resource_1")
      .get("/assets/bootstrap.min.js")
      .headers(headers_resources_1),
      http("resource_2")
        .get("/assets/bootstrap-table.js")
        .headers(headers_resources_1),
      http("resource_3")
        .get("/assets/bootstrap.min.css")
        .headers(headers_resources_1),
      http("resource_4")
        .get("/assets/bootstrap-table.css")
        .headers(headers_resources_1),
      http("resource_5")
        .get("/favicon.ico")
        .headers(headers_resources_2))
}
