package com.montabe.runways

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class RunwaySpec extends AnyFlatSpec with Matchers {
  "Runway.fromCSV" should "correctly parse a CSV line" in {
    val line = "269408,6523,\"00A\",80,80,\"ASPH-G\",1,0,\"H1\",,,,,,,,,,,"
    val runway = Runway.fromCSV(line)
    runway shouldBe Runway(269408, 6523, "00A", 80, 80, "ASPH-G", true, false, "H1", 0.0, 0.0, 0, 0.0, 0, "", 0.0, 0.0, 0, 0.0, 0)
  }
}
