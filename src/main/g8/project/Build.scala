import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "micro-service"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test",
    "net.liftweb" % "lift-json-ext_2.10" % "2.5-M4"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
