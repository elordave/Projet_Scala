package com.montabe.runways

case class Runway(
                   id: Long,
                   airportRef: Long,
                   airportIdent: String,
                   lengthFt: Int,
                   widthFt: Int,
                   surface: String,
                   lighted: Boolean,
                   closed: Boolean,
                   leIdent: String,
                   leLatitudeDeg: Double,
                   leLongitudeDeg: Double,
                   leElevationFt: Int,
                   leHeadingDegT: Double,
                   leDisplacedThresholdFt: Int,
                   heIdent: String,
                   heLatitudeDeg: Double,
                   heLongitudeDeg: Double,
                   heElevationFt: Int,
                   heHeadingDegT: Double,
                   heDisplacedThresholdFt: Int
                 )

object Runway {
  def fromCSV(line: String): Runway = {
    val cols = line.split(",").map(_.trim)
    Runway(
      if (cols.length > 0 && cols(0).nonEmpty) cols(0).replace("\"", "").toLong else 0L,
      if (cols.length > 1 && cols(1).nonEmpty) cols(1).replace("\"", "").toLong else 0L,
      if (cols.length > 2) cols(2).replace("\"", "") else "",
      if (cols.length > 3 && cols(3).nonEmpty) cols(3).replace("\"", "").toInt else 0,
      if (cols.length > 4 && cols(4).nonEmpty) cols(4).replace("\"", "").toInt else 0,
      if (cols.length > 5) cols(5).replace("\"", "") else "",
      cols.length > 6 && cols(6) == "1",
      cols.length > 7 && cols(7) == "1",
      if (cols.length > 8) cols(8).replace("\"", "") else "",
      if (cols.length > 9 && cols(9).nonEmpty) cols(9).replace("\"", "").toDoubleOption.getOrElse(Double.NaN) else Double.NaN,
      if (cols.length > 10 && cols(10).nonEmpty) cols(10).replace("\"", "").toDoubleOption.getOrElse(Double.NaN) else Double.NaN,
      if (cols.length > 11 && cols(11).nonEmpty) cols(11).replace("\"", "").toIntOption.getOrElse(0) else 0,
      if (cols.length > 12 && cols(12).nonEmpty) cols(12).replace("\"", "").toDoubleOption.getOrElse(Double.NaN) else Double.NaN,
      if (cols.length > 13 && cols(13).nonEmpty) cols(13).replace("\"", "").toIntOption.getOrElse(0) else 0,
      if (cols.length > 14) cols(14).replace("\"", "") else "",
      if (cols.length > 15 && cols(15).nonEmpty) cols(15).replace("\"", "").toDoubleOption.getOrElse(Double.NaN) else Double.NaN,
      if (cols.length > 16 && cols(16).nonEmpty) cols(16).replace("\"", "").toDoubleOption.getOrElse(Double.NaN) else Double.NaN,
      if (cols.length > 17 && cols(17).nonEmpty) cols(17).replace("\"", "").toIntOption.getOrElse(0) else 0,
      if (cols.length > 18 && cols(18).nonEmpty) cols(18).replace("\"", "").toDoubleOption.getOrElse(Double.NaN) else Double.NaN,
      if (cols.length > 19 && cols(19).nonEmpty) cols(19).replace("\"", "").toIntOption.getOrElse(0) else 0
    )
  }

}


