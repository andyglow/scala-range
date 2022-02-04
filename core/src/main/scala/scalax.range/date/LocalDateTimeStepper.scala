package scalax.range.date

import java.{time => jt}

import scalax.range.Stepper

import scala.concurrent.duration._


private[range] class LocalDateTimeStepper[S](toNanos: S => Long) extends Stepper[jt.LocalDateTime, S] {

  def plus(t: jt.LocalDateTime, s: S): jt.LocalDateTime = t.plusNanos(toNanos(s))
}

private[range] object LocalDateTimeStepper extends NanoStepper[jt.LocalDateTime](_.seconds) {

  override def newStepper[S](toSubj: S => Long): Stepper[jt.LocalDateTime, S] = new LocalDateTimeStepper(toSubj)
}