name := "cassandra-demo"

version := "1.0"

scalaVersion := "2.12.1"


libraryDependencies ++= Seq(
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.2.0-rc3",
  "log4j" % "log4j" % "1.2.17"
)


    