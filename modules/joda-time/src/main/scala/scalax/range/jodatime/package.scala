package scalax.range

import org.joda.time._

import scala.concurrent.duration.FiniteDuration


package object jodatime {

  implicit val jodaInstantOrd: Ordering[Instant] = Ordering fromLessThan { _.compareTo(_) > 0 }
  implicit val jodaLocalDateOrd: Ordering[LocalDate] = Ordering fromLessThan { _.compareTo(_) > 0 }
  implicit val jodaLocalTimeOrd: Ordering[LocalTime] = Ordering fromLessThan { _.compareTo(_) > 0 }
  implicit val jodaDateTimeOrd: Ordering[DateTime] = Ordering fromLessThan { _.compareTo(_) > 0 }

  // org.joda.time.Instant
  implicit val jodaInstantFinDurStepper: Stepper[Instant, FiniteDuration] = InstantStepper.finDur
  implicit val jodaInstantJtDurStepper: Stepper[Instant, java.time.Duration] = InstantStepper.jtDur
  implicit val jodaInstantJodaDurStepper: Stepper[Instant, Duration] = InstantStepper.jodaDur
  implicit def jodaInstantNumStepper[N](implicit num: Numeric[N]): Stepper[Instant, N] = InstantStepper.numAsSec

  // org.joda.time.LocalDate
  implicit val jodaLocalDateFinDurStepper: Stepper[LocalDate, FiniteDuration] = LocalDateStepper.finDur
  implicit val jodaLocalDateJtDurStepper: Stepper[LocalDate, java.time.Duration] = LocalDateStepper.jtDur
  implicit val jodaLocalDateJodaDurStepper: Stepper[LocalDate, Duration] = LocalDateStepper.jodaDur
  implicit def jodaLocalDateNumStepper[N](implicit num: Numeric[N]): Stepper[LocalDate, N] = LocalDateStepper.numAsSec

  // org.joda.time.LocalTime
  implicit val jodaLocalTimeFinDurStepper: Stepper[LocalTime, FiniteDuration] = LocalTimeStepper.finDur
  implicit val jodaLocalTimeJtDurStepper: Stepper[LocalTime, java.time.Duration] = LocalTimeStepper.jtDur
  implicit val jodaLocalTimeJodaDurStepper: Stepper[LocalTime, Duration] = LocalTimeStepper.jodaDur
  implicit def jodaLocalTimeNumStepper[N](implicit num: Numeric[N]): Stepper[LocalTime, N] = LocalTimeStepper.numAsSec

  // org.joda.time.DateTime
  implicit val jodaDateTimeFinDurStepper: Stepper[DateTime, FiniteDuration] = DateTimeStepper.finDur
  implicit val jodaDateTimeJtDurStepper: Stepper[DateTime, java.time.Duration] = DateTimeStepper.jtDur
  implicit val jodaDateTimeJodaDurStepper: Stepper[DateTime, Duration] = DateTimeStepper.jodaDur
  implicit def jodaDateTimeNumStepper[N](implicit num: Numeric[N]): Stepper[DateTime, N] = DateTimeStepper.numAsSec
}
