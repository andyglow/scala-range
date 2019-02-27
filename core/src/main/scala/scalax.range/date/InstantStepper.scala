package scalax.range.date

import java.time.Instant
import scalax.range.Stepper
import java.{time => jt}
import scala.concurrent.duration._


private[range] class InstantStepper[S](toNanos: S => Long) extends Stepper[jt.Instant, S] {

  def plus(t: jt.Instant, s: S): jt.Instant = t.plusNanos(toNanos(s))
}

private[range] object InstantStepper extends NanoStepper[jt.Instant](_.seconds) {

  override def newStepper[S](toSubj: S => Long): Stepper[Instant, S] = new InstantStepper(toSubj)
}