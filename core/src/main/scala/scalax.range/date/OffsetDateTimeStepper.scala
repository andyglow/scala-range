package scalax.range.date

import java.{time => jt}

import scalax.range.Stepper

import scala.concurrent.duration._


private[range] class OffsetDateTimeStepper[S](toNanos: S => Long) extends Stepper[jt.OffsetDateTime, S] {

  def plus(t: jt.OffsetDateTime, s: S): jt.OffsetDateTime = t.plusNanos(toNanos(s))
}

private[range] object OffsetDateTimeStepper extends NanoStepper[jt.OffsetDateTime](_.seconds) {

  override def newStepper[S](toSubj: S => Long): Stepper[jt.OffsetDateTime, S] = new OffsetDateTimeStepper(toSubj)
}