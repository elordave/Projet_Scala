import com.montabe.runways.Runway

object RunwayDatabase {

  def insertAllRunways(runways: List[Runway]): Unit = {
    val connection = Database.getConnection
    val preparedStatement = connection.prepareStatement(
      """
        INSERT INTO runways (id, airport_ref, airport_ident, length_ft, width_ft, surface, lighted, closed, le_ident, le_latitude_deg, le_longitude_deg, le_elevation_ft, le_heading_degT, le_displaced_threshold_ft, he_ident, he_latitude_deg, he_longitude_deg, he_elevation_ft, he_heading_degT, he_displaced_threshold_ft)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
      """
    )

    runways.foreach { runway =>
      preparedStatement.setLong(1, runway.id)
      preparedStatement.setLong(2, runway.airportRef)
      preparedStatement.setString(3, runway.airportIdent)
      preparedStatement.setInt(4, runway.lengthFt)
      preparedStatement.setInt(5, runway.widthFt)
      preparedStatement.setString(6, runway.surface)
      preparedStatement.setBoolean(7, runway.lighted)
      preparedStatement.setBoolean(8, runway.closed)
      preparedStatement.setString(9, runway.leIdent)
      preparedStatement.setDouble(10, runway.leLatitudeDeg)
      preparedStatement.setDouble(11, runway.leLongitudeDeg)
      preparedStatement.setInt(12, runway.leElevationFt)
      preparedStatement.setDouble(13, runway.leHeadingDegT)
      preparedStatement.setInt(14, runway.leDisplacedThresholdFt)
      preparedStatement.setString(15, runway.heIdent)
      preparedStatement.setDouble(16, runway.heLatitudeDeg)
      preparedStatement.setDouble(17, runway.heLongitudeDeg)
      preparedStatement.setInt(18, runway.heElevationFt)
      preparedStatement.setDouble(19, runway.heHeadingDegT)
      preparedStatement.setInt(20, runway.heDisplacedThresholdFt)

      preparedStatement.executeUpdate()
    }

    connection.close()
  }

  def countRowsInTable(): Unit = {
    val connection = Database.getConnection
    val statement = connection.createStatement()

    // Exécute la requête de comptage
    val resultSet = statement.executeQuery("SELECT COUNT(*) AS total FROM runways")
    if (resultSet.next()) {
      val total = resultSet.getInt("total")
      println(s"Il y a $total lignes dans la table runways.")
    }
    connection.close()
  }
}