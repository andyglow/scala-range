package scalax.range.jodatime

import org.joda.time.Instant
import scalax.range.Stepper
import scalax.range.date._

import scala.concurrent.duration._


private[range] class InstantStepper[S](toMillis: S => Long) extends Stepper[Instant, S] {

  def plus(t: Instant, s: S): Instant = t.withDurationAdded(toMillis(s), 1)
}

private[range] object InstantStepper extends MillisStepper[Instant](_.seconds) with JodaStepper[Instant] {

  override def newStepper[S](toSubj: S => Long): Stepper[Instant, S] = new InstantStepper(toSubj)
}