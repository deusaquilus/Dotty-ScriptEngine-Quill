lazy val `Dotty-ScriptEngine-Quill` = project
  .in(file("."))
  .settings(
    name := "Dotty-ScriptEngine-Quill",
    version := "0.1.0",
    resolvers ++= Seq(
      Resolver.mavenLocal,
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
    ),
    scalaVersion := "3.2.0",
    fork := true,
    libraryDependencies ++= Seq(
      "org.scala-lang" %% "scala3-compiler" % scalaVersion.value,
      "io.getquill" %% "quill-sql" % "4.6.0.1"
    )
  )
