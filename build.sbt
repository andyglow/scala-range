import xerial.sbt.Sonatype._
import ReleaseTransformations._

lazy val scala213 = "2.13.1"
lazy val scala212 = "2.12.10"
lazy val scala211 = "2.11.12"

lazy val commons = Seq(
  organization            := "com.github.andyglow",
  releaseCrossBuild       := true,
  scalaVersion            := scala211,
  publishMavenStyle       := true,
  publishArtifact         := true,
  crossScalaVersions      := List(scala213, scala212, scala211),
  homepage                := Some(new URL("http://github.com/andyglow/scala-range")),
  startYear               := Some(2019),
  organizationName        := "andyglow",
  publishTo               := sonatypePublishTo.value,
  licenses                := Seq(("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))),
  sonatypeProfileName     := "com.github.andyglow",
  sonatypeProjectHosting  := Some(GitHubHosting("andyglow", "scala-range", "andyglow@gmail.com")),
  scmInfo                 := Some(ScmInfo(url("https://github.com/andyglow/scala-range"), "scm:git@github.com:andyglow/scala-range.git")),
  developers              := List(Developer(id = "andyglow", name = "Andriy Onyshchuk", email = "andyglow@gmail.com", url = url("https://ua.linkedin.com/in/andyglow"))),
  scalacOptions ++= {
    val options = Seq(
      "-encoding", "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-Xfatal-warnings",
      "-Xlint",
      "-Yno-adapted-args",
      "-Ywarn-dead-code",
      "-Ywarn-numeric-widen",
      "-Xfuture")

    // WORKAROUND https://github.com/scala/scala/pull/5402
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, 12)) => options.map {
        case "-Xlint"               => "-Xlint:-unused,_"
        case "-Ywarn-unused-import" => "-Ywarn-unused:imports,-patvars,-privates,-locals,-implicits"
        case other                  => other
      }
      case Some((2, n)) if n >= 13  => options.filterNot { opt =>
        opt == "-Yno-adapted-args" || opt == "-Xfuture"
      }.map {
        case "-Ywarn-unused-import" => "-Ywarn-unused:imports,-patvars,-privates,-locals,-implicits"
        case other                  => other
      } :+ "-Xsource:2.13"
      case _             => options
    }
  },
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % Test,
  releaseProcess := Seq[ReleaseStep](
    checkSnapshotDependencies,
    inquireVersions,
    runClean,
    runTest,
    setReleaseVersion,
    commitReleaseVersion,
    tagRelease,
    releaseStepCommandAndRemaining("+publishSigned"),
    setNextVersion,
    commitNextVersion,
    releaseStepCommand("sonatypeReleaseAll"),
    pushChanges))

lazy val core = project.in(file("core"))
  .settings(
    commons,
    name := "scalax-range")

lazy val joda = project.in(file("ext-joda-time"))
  .dependsOn(core)
  .settings(
    commons,
    name := "scalax-range-joda-time",
    libraryDependencies += "joda-time" % "joda-time" % "2.10.6")

lazy val root = project.in(file("."))
  .aggregate(core, joda)
  .settings(
    commons,
    name := "scalax-range-root",
    crossScalaVersions := Nil,
    publish / skip := true,
    publishArtifact := false,
    aggregate in update := false)