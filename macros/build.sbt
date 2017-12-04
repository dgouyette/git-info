name := """git-info"""

version := "0.2.0"

organization := "org.cestpasdur"

scalaVersion := "2.12.3"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

publishMavenStyle := true

resolvers += "dgouyette maven bintray" at "https://bintray.com/dgouyette/maven"

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "4.4.1.201607150455-r"