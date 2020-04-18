package scalax.range.date

import java.{time => jt}

import scalax.range.Stepper

import scala.concurrent.duration._


private[range] class LocalTimeStepper[S](toNanos: S => Long) extends Stepper[jt.LocalTime, S] {

  def plus(t: jt.LocalTime, s: S): jt.LocalTime = t.plusNanos(toNanos(s))
}

private[range] object LocalTimeStepper extends NanoStepper[jt.LocalTime](_.minutes) {

  override def newStepper[S](toSubj: S => Long): Stepper[jt.LocalTime, S] = new LocalTimeStepper(toSubj)
}