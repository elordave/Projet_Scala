import java.sql.{Connection, DriverManager, Statement}
import com.montabe.airports.Airport
import com.montabe.countries.Country
import com.montabe.runways.Runway

object Database {
  Class.forName("org.sqlite.JDBC")

  def getConnection: Connection = {
    DriverManager.getConnection("jdbc:sqlite:sample.db")
  }

  def dropTables(): Unit = {
    val connection = Database.getConnection
    val statement = connection.createStatement()

    // requête pour supprimer les tables
    statement.executeUpdate("DROP TABLE IF EXISTS countries")
    statement.executeUpdate("DROP TABLE IF EXISTS airports")
    statement.executeUpdate("DROP TABLE IF EXISTS runways")
  }

  def createTables(): Unit = {
    val connection = getConnection
    val statement = connection.createStatement()

    val createCountriesTable = """
      CREATE TABLE IF NOT EXISTS countries (
        id INTEGER PRIMARY KEY,
        code TEXT,
        name TEXT,
        continent TEXT,
        wikipedia_link TEXT,
        keywords TEXT
      )
    """

    val createAirportsTable = """
      CREATE TABLE IF NOT EXISTS airports (
        id INTEGER PRIMARY KEY,
        ident TEXT,
        type TEXT,
        name TEXT,
        latitude_deg REAL,
        longitude_deg REAL,
        elevation_ft INTEGER,
        continent TEXT,
        iso_country TEXT,
        iso_region TEXT,
        municipality TEXT,
        scheduled_service TEXT,
        gps_code TEXT,
        iata_code TEXT,
        local_code TEXT,
        home_link TEXT,
        wikipedia_link TEXT,
        keywords TEXT
      )
    """

    val createRunwaysTable = """
      CREATE TABLE IF NOT EXISTS runways (
        id INTEGER PRIMARY KEY,
        airport_ref INTEGER,
        airport_ident TEXT,
        length_ft INTEGER,
        width_ft INTEGER,
        surface TEXT,
        lighted INTEGER,
        closed INTEGER,
        le_ident TEXT,
        le_latitude_deg REAL,
        le_longitude_deg REAL,
        le_elevation_ft INTEGER,
        le_heading_degT INTEGER,
        le_displaced_threshold_ft INTEGER,
        he_ident TEXT,
        he_latitude_deg REAL,
        he_longitude_deg REAL,
        he_elevation_ft INTEGER,
        he_heading_degT INTEGER,
        he_displaced_threshold_ft INTEGER
      )
    """

    statement.execute(createCountriesTable)
    statement.execute(createAirportsTable)
    statement.execute(createRunwaysTable)
    connection.close()
  }
}

