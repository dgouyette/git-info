name := """play-git-info-webapp"""

version := "0.1.1"

organization := "org.cestpasdur"

scalaVersion := "2.11.8"

lazy val macros = project

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(macros)