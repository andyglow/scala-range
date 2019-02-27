package scalax.range.jodatime

import org.joda.time.DateTime
import scalax.range.Stepper
import scalax.range.date.MillisStepper

import scala.concurrent.duration._


private[range] class DateTimeStepper[S](toMillis: S => Long) extends Stepper[DateTime, S] {

  def plus(t: DateTime, s: S): DateTime = t.plusMillis(toMillis(s).toInt)
}

private[range] object DateTimeStepper extends MillisStepper[DateTime](_.hours) with JodaStepper[DateTime] {

  override def newStepper[S](toSubj: S => Long): Stepper[DateTime, S] = new DateTimeStepper(toSubj)
}