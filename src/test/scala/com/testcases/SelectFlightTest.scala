package com.testcases

import com.pageObjects.BasePage.httpProtocol
import com.pageObjects._
import io.gatling.core.Predef._

class SelectFlightTest extends Simulation{

  val selectFlightScenario = scenario("Select Flight")
    .exec(HomePage.verifyHomePage)
    .pause(5)
    .exec(FindFlightPage.findFlight)
    .pause(10)
    .exec(SelectFlightPage.selectFlight)

  setUp(selectFlightScenario.inject(atOnceUsers(5))).protocols(httpProtocol)
}
