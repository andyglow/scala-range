package scalax.range.jodatime

import org.joda.time.Duration
import scalax.range.Stepper
import scalax.range.date.GenericStepper

import scala.concurrent.duration._

trait JodaStepper[T] { this: GenericStepper[T] =>

  val jodaDur: Stepper[T, Duration] = newStepper(d => fromDur(d.getMillis.millis))
}
