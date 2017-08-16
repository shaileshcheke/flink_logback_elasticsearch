package com.autolitix.flink
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

object SLogger {
  lazy val logger: Logger =
    Logger(LoggerFactory.getLogger(getClass.getName))
}

trait SLogger extends Serializable {
  def error(mesg : String, throwable: Throwable): Unit = SLogger.logger.error(mesg, throwable)
  def warn(mesg : String): Unit = SLogger.logger.warn(mesg)
  def info(mesg : String): Unit = SLogger.logger.info(mesg)
  def debug(mesg : String): Unit = SLogger.logger.debug(mesg)
}
