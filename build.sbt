lazy val scala212 = "2.12.8"
lazy val scala211 = "2.11.12"

lazy val commons = Seq(
organization      := "com.github.andyglow",
version           := "0.1",
scalaVersion      := scala211,
publishMavenStyle := true,
publishArtifact   := true,
crossScalaVersions := List(scala212, scala211),
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
      case "-Ywarn-unused-import" => "-Ywarn-unused:imports,-patvars,-privates,-locals,-params,-implicits"
      case other                  => other
    }
    case _             => options
  }
},
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test)

lazy val core = project.in(file("core"))
  .settings(
    commons,
    name := "scalax-range")

lazy val joda = project.in(file("ext-joda-time"))
  .dependsOn(core)
  .settings(
    commons,
    name := "scalax-range-joda-time",
    libraryDependencies += "joda-time" % "joda-time" % "2.10.1")

lazy val root = project.in(file("."))
  .aggregate(core, joda)
  .settings(
    name := "scalax-range-root",
    aggregate in update := false)