package scalax.range.date

import java.{time => jt}

import scalax.range.Stepper

import scala.concurrent.duration._


private[range] class ZonedDateTimeStepper[S](toNanos: S => Long) extends Stepper[jt.ZonedDateTime, S] {

  def plus(t: jt.ZonedDateTime, s: S): jt.ZonedDateTime = t.plusNanos(toNanos(s))
}

private[range] object ZonedDateTimeStepper extends NanoStepper[jt.ZonedDateTime](_.seconds) {

  override def newStepper[S](toSubj: S => Long): Stepper[jt.ZonedDateTime, S] = new ZonedDateTimeStepper(toSubj)
}