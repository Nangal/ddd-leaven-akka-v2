import sbt._
import Keys._
import com.typesafe.sbt.packager.docker.{Cmd, DockerKeys}

object CommonDockerSettingsPlugin extends AutoPlugin with DockerKeys {
  override def trigger = allRequirements
  override def requires = com.typesafe.sbt.packager.docker.DockerPlugin
  def appLogLevel = sys.props.getOrElse("ECOMMERCE_LOG_LEVEL", default = "DEBUG")

  override lazy val projectSettings = Seq(
      dockerBaseImage := "java:8",
      dockerCommands ++= Seq(
        Cmd("MAINTAINER", "Pawel Kaczor <newion@o2.pl>"),
        Cmd("ENV", "ES_HOST=127.0.0.1"),
        Cmd("ENV", "ES_PASSWORD=changeit"),
        Cmd("ENV", s"ECOMMERCE_LOG_LEVEL=$appLogLevel")
      )
  )
}