name := """macros"""

version := "0.2-SNAPSHOT"

scalaVersion := "2.11.8"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

publishMavenStyle := false

resolvers += Resolver.url("git-info resolver", url("https://bintray.com/dgouyette/git-info"))(Resolver.ivyStylePatterns)

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
libraryDependencies += "org.eclipse.jgit" % "org.eclipse.jgit" % "4.4.1.201607150455-r"