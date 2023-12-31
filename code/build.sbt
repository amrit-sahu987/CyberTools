val scala3Version = "3.3.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "code",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    
    libraryDependencies ++= Seq (
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.pcap4j" % "pcap4j-core" % "1.8.1"
    )
  )
