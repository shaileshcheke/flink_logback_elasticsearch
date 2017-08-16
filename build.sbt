name := "kafka-flink-logback-elastic-search"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.flink" %% "flink-scala" % "1.2.1" excludeAll( ExclusionRule(organization = "log4j",name="log4j"),
ExclusionRule(organization = "org.slf4j",name = "slf4j-log4j12")
)
libraryDependencies += "org.apache.flink" %% "flink-clients" % "1.2.1" excludeAll( ExclusionRule(organization = "log4j",name="log4j"),
ExclusionRule(organization = "org.slf4j",name = "slf4j-log4j12")
)
libraryDependencies += "org.apache.flink" %% "flink-streaming-scala" % "1.2.1" excludeAll( ExclusionRule(organization = "log4j",name="log4j"),
ExclusionRule(organization = "org.slf4j",name = "slf4j-log4j12")
)
libraryDependencies += "org.apache.flink" %% "flink-connector-kafka-0.10" % "1.2.1" excludeAll( ExclusionRule(organization = "log4j",name="log4j"),
ExclusionRule(organization = "org.slf4j",name = "slf4j-log4j12")
)
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.1"
libraryDependencies += "ch.qos.logback" % "logback-core" % "1.2.1"
libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.12"
libraryDependencies += "com.internetitem" % "logback-elasticsearch-appender"%"1.6"