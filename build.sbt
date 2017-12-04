name := """play-git-info-webapp"""

version := "0.2.1"

organization := "org.cestpasdur"

scalaVersion := "2.12.3"

lazy val macros = project

libraryDependencies += guice

bintrayOmitLicense := true

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(macros)