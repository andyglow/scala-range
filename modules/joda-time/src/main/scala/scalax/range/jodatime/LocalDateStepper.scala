package scalax.range.jodatime

import org.joda.time.LocalDate
import scalax.range.Stepper
import scalax.range.date.DaysStepper

import scala.concurrent.duration._


private[range] class LocalDateStepper[S](toDays: S => Long) extends Stepper[LocalDate, S] {

  def plus(t: LocalDate, s: S): LocalDate = t.plusDays(toDays(s).toInt)
}

private[range] object LocalDateStepper extends DaysStepper[LocalDate](_.days) with JodaStepper[LocalDate]{

  override def newStepper[S](toSubj: S => Long): Stepper[LocalDate, S] = new LocalDateStepper(toSubj)
}