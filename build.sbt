scalaVersion := "2.13.10"

name := "cas-pratique-spark-1"

version := "1.0.0"

organization := "io.github.jsarni"
homepage := Some(url("https://github.com/jsarni/cas-pratique-spark-1"))

// Dependencies
val scalaTest = "org.scalatest" %% "scalatest" % "3.2.7" % Test
val sparkCore = "org.apache.spark" % "spark-core_2.13" % "3.3.2"
val sparkSQL = "org.apache.spark" % "spark-sql_2.13" % "3.3.2"


lazy val casPratiqueSpark1 = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(scalaTest, sparkCore, sparkSQL)
  )