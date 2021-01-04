package scalax.range.jodatime

import org.joda.time.LocalTime
import scalax.range.Stepper
import scalax.range.date.MillisStepper

import scala.concurrent.duration._


private[range] class LocalTimeStepper[S](toMillis: S => Long) extends Stepper[LocalTime, S] {

  def plus(t: LocalTime, s: S): LocalTime = t.plusMillis(toMillis(s).toInt)
}

private[range] object LocalTimeStepper extends MillisStepper[LocalTime](_.minutes) with JodaStepper[LocalTime] {

  override def newStepper[S](toSubj: S => Long): Stepper[LocalTime, S] = new LocalTimeStepper(toSubj)
}