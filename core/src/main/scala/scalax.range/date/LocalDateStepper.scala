package scalax.range.date

import java.time.LocalDate
import java.{time => jt}
import scalax.range.Stepper
import scala.concurrent.duration._


private[range] class LocalDateStepper[S](toDays: S => Long) extends Stepper[jt.LocalDate, S] {

  def plus(t: jt.LocalDate, s: S): jt.LocalDate = t.plusDays(toDays(s))
}

private[range] object LocalDateStepper extends DaysStepper[jt.LocalDate](_.days) {

  override def newStepper[S](toSubj: S => Long): Stepper[LocalDate, S] = new LocalDateStepper(toSubj)
}