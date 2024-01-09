ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "ProjetScala"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9"

libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.34.0"



