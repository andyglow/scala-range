package scalax.range.date

import java.{util => ju}
import scalax.range.Stepper
import scala.concurrent.duration._


private[range] class JavaUtilDateStepper[S](toNanos: S => Long) extends Stepper[ju.Date, S] {

  def plus(t: ju.Date, s: S): ju.Date = ju.Date from {
    t.toInstant.plusNanos(toNanos(s))
  }
}

private[range] object JavaUtilDateStepper extends NanoStepper[ju.Date](_.seconds) {

  override def newStepper[S](toSubj: S => Long): Stepper[ju.Date, S] = new JavaUtilDateStepper(toSubj)
}