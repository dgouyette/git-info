name := """play-git-info-webapp"""

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

run <<= run in Compile in root

lazy val macros = project

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .aggregate(macros)
  .dependsOn(macros)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
