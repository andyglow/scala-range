package scalax.range.date

import scalax.range.Stepper
import scala.concurrent.duration._


abstract class GenericStepper[T](
  val fromNum: Long => FiniteDuration, // to convert numeric into duration
  val fromDur: FiniteDuration => Long) { // to convert duration into subject

  def newStepper[S](toSubj: S => Long): Stepper[T, S]

  val finDur: Stepper[T, FiniteDuration] = newStepper(fromDur)

  val jtDur: Stepper[T, java.time.Duration] = newStepper(d => fromDur(d.toNanos.nanos))

  def numAsSec[N](implicit num: Numeric[N]): Stepper[T, N] = newStepper(n => fromDur(fromNum(num.toLong(n))))
}

abstract class NanoStepper[T](fromNum: Long => FiniteDuration) extends GenericStepper[T](fromNum, _.toNanos)
abstract class MillisStepper[T](fromNum: Long => FiniteDuration) extends GenericStepper[T](fromNum, _.toMillis)
abstract class DaysStepper[T](fromNum: Long => FiniteDuration) extends GenericStepper[T](fromNum, _.toDays)