package scalax.range

import java.{time => jt, util => ju}

import scala.concurrent.duration._
import scala.language.implicitConversions

@annotation.implicitNotFound(msg = "No implicit Stepper defined for ${T}.")
trait Stepper[T, S] {

  def plus(t: T, s: S): T

  class Ops(l: T) {
    def +(r: S): T = plus(l, r)
  }

  implicit def mkStepperOps(l: T): Ops = new Ops(l)
}

object Stepper {

  /*
   * Numbers
   */
  implicit def forNumeric[T, S](implicit num: Numeric[T], ev: T =:= S): Stepper[T, S] = new Stepper[T, S] {
    override def plus(t: T, s: S): T = num.plus(t, s.asInstanceOf[T])
  }

  /*
   * Dates
   */

  // java.util.Date
  implicit val juDateFinDurStepper: Stepper[ju.Date, FiniteDuration] = date.JavaUtilDateStepper.finDur
  implicit val juDateJtDurStepper: Stepper[ju.Date, jt.Duration] = date.JavaUtilDateStepper.jtDur
  implicit def juDateNumStepper[N](implicit num: Numeric[N]): Stepper[ju.Date, N] = date.JavaUtilDateStepper.numAsSec

  // java.time.Instant
  implicit val jtInstantFinDurStepper: Stepper[jt.Instant, FiniteDuration] = date.InstantStepper.finDur
  implicit val jtInstantJtDurStepper: Stepper[jt.Instant, jt.Duration] = date.InstantStepper.jtDur
  implicit def jtInstantNumStepper[N](implicit num: Numeric[N]): Stepper[jt.Instant, N] = date.InstantStepper.numAsSec

  // java.time.LocalDate
  implicit val jtLocalDateFinDurStepper: Stepper[jt.LocalDate, FiniteDuration] = date.LocalDateStepper.finDur
  implicit val jtLocalDateJtDurStepper: Stepper[jt.LocalDate, jt.Duration] = date.LocalDateStepper.jtDur
  implicit def jtLocalDateNumStepper[N](implicit num: Numeric[N]): Stepper[jt.LocalDate, N] = date.LocalDateStepper.numAsSec

  // java.time.LocalTime
  implicit val jtLocalTimeFinDurStepper: Stepper[jt.LocalTime, FiniteDuration] = date.LocalTimeStepper.finDur
  implicit val jtLocalTimeJtDurStepper: Stepper[jt.LocalTime, jt.Duration] = date.LocalTimeStepper.jtDur
  implicit def jtLocalTimeNumStepper[N](implicit num: Numeric[N]): Stepper[jt.LocalTime, N] = date.LocalTimeStepper.numAsSec

  // java.time.LocalDateTime
  implicit val jtLocalDateTimeFinDurStepper: Stepper[jt.LocalDateTime, FiniteDuration] = date.LocalDateTimeStepper.finDur
  implicit val jtLocalDateTimeJtDurStepper: Stepper[jt.LocalDateTime, jt.Duration] = date.LocalDateTimeStepper.jtDur
  implicit def jtLocalDateTimeNumStepper[N](implicit num: Numeric[N]): Stepper[jt.LocalDateTime, N] = date.LocalDateTimeStepper.numAsSec

  // java.time.ZonedDateTime
  implicit val jtZonedDateTimeFinDurStepper: Stepper[jt.ZonedDateTime, FiniteDuration] = date.ZonedDateTimeStepper.finDur
  implicit val jtZonedDateTimeJtDurStepper: Stepper[jt.ZonedDateTime, jt.Duration] = date.ZonedDateTimeStepper.jtDur
  implicit def jtZonedDateTimeNumStepper[N](implicit num: Numeric[N]): Stepper[jt.ZonedDateTime, N] = date.ZonedDateTimeStepper.numAsSec

  // java.time.OffsetDateTime
  implicit val jtOffsetDateTimeFinDurStepper: Stepper[jt.OffsetDateTime, FiniteDuration] = date.OffsetDateTimeStepper.finDur
  implicit val jtOffsetDateTimeJtDurStepper: Stepper[jt.OffsetDateTime, jt.Duration] = date.OffsetDateTimeStepper.jtDur
  implicit def jtOffsetDateTimeNumStepper[N](implicit num: Numeric[N]): Stepper[jt.OffsetDateTime, N] = date.OffsetDateTimeStepper.numAsSec
}
