name := """play-git-info-webapp"""

version := "0.2.2"

organization := "org.cestpasdur"


lazy val macros = project

libraryDependencies += guice

PlayKeys.playOmnidoc := false


bintrayOmitLicense := true

lazy val scala213 = "2.13.0-M5"
lazy val scala212 = "2.12.8"

lazy val supportedScalaVersions = List(scala213)

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(macros)
  .settings(
    crossScalaVersions := supportedScalaVersions,
    excludeDependencies ++= Seq(ExclusionRule("com.typesafe.play", "play-omnidoc"))
  )

