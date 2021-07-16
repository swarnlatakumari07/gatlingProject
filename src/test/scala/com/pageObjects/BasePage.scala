package com.pageObjects

import com.helper.ConstantsData.{base_url, user_agent_header}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object BasePage {

  val httpProtocol = http.baseUrl(base_url)
    .inferHtmlResources()
    .userAgentHeader(user_agent_header)
}
