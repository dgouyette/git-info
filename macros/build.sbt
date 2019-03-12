name := """git-info"""

version := "0.2.1"

organization := "org.cestpasdur"


lazy val scala213 = "2.13.0-M5"
lazy val scala212 = "2.12.8"

crossScalaVersions := List(scala212, scala213)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

bintrayOmitLicense := true

publishMavenStyle := true

resolvers += "dgouyette maven bintray" at "https://bintray.com/dgouyette/maven"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "4.4.1.201607150455-r"