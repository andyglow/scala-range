import xerial.sbt.Sonatype._
import ReleaseTransformations._
import ScalaVer._

lazy val commons = ScalaVer.settings ++ Seq(
  organization            := "com.github.andyglow",
  releaseCrossBuild       := true,
  publishMavenStyle       := true,
  publishArtifact         := true,
  homepage                := Some(new URL("http://github.com/andyglow/scala-range")),
  startYear               := Some(2019),
  organizationName        := "andyglow",
  publishTo               := sonatypePublishTo.value,
  licenses                := Seq(("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))),
  sonatypeProfileName     := "com.github.andyglow",
  sonatypeProjectHosting  := Some(GitHubHosting("andyglow", "scala-range", "andyglow@gmail.com")),
  scmInfo                 := Some(ScmInfo(url("https://github.com/andyglow/scala-range"), "scm:git@github.com:andyglow/scala-range.git")),
  developers              := List(Developer(id = "andyglow", name = "Andriy Onyshchuk", email = "andyglow@gmail.com", url = url("https://ua.linkedin.com/in/andyglow"))),
  scalacOptions           := CompilerOptions(scalaV.value),
  libraryDependencies     += "org.scalatest" %% "scalatest" % "3.2.10" % Test,
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

lazy val joda = project.in(file("modules/joda-time"))
  .dependsOn(core)
  .settings(
    commons,
    name := "scalax-range-joda-time",
    libraryDependencies += "joda-time" % "joda-time" % "2.10.12")

lazy val root = project.in(file("."))
  .aggregate(core, joda)
  .settings(
    commons,
    name := "scalax-range-root",
    crossScalaVersions := Nil,
    publish / skip := true,
    publishArtifact := false,
    update / aggregate := false)