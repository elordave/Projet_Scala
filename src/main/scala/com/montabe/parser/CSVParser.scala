package com.montabe.parser

import com.montabe.airports.Airport
import com.montabe.countries.Country
import com.montabe.runways.Runway

import scala.io.Source

object CSVParser {
  def parseAirports(file: String): Seq[Airport] = {
    val lines = Source.fromFile(file).getLines().drop(1)
    lines.map(Airport.fromCSV).toSeq
  }

  def parseCountries(file: String): Seq[Country] = {
    val lines = Source.fromFile(file).getLines().drop(1)
    lines.map(Country.fromCSV).toSeq
  }

  def parseRunways(file: String): Seq[Runway] = {
    val lines = Source.fromFile(file).getLines().drop(1)
    lines.map(Runway.fromCSV).toSeq
  }
}
