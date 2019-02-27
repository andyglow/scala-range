package scalax.range

import java.time.Duration

import org.joda.time.Instant

import scala.concurrent.duration.FiniteDuration

package object jodatime {

  // java.time.Instant
  implicit val jtInstantFinDurStepper: Stepper[Instant, FiniteDuration] = InstantStepper.finDur
  implicit val jtInstantJtDurStepper: Stepper[Instant, Duration] = InstantStepper.jtDur
  implicit def jtInstantNumStepper[N](implicit num: Numeric[N]): Stepper[Instant, N] = InstantStepper.numAsSec


}
