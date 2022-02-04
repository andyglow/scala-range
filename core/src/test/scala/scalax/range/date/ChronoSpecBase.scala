package scalax.range.date

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec._
import scalax.range._

import scala.concurrent.duration.FiniteDuration

abstract class ChronoSpecBase[T](
  typeName: String,
  from: T,
  to: T,
  step: (Int, FiniteDuration, java.time.Duration),
  contains: List[T]
)(implicit
  ord: Ordering[T],
  intStepper: Stepper[T, Int],
  scalaDurStepper: Stepper[T, FiniteDuration],
  javaDurStepper: Stepper[T, java.time.Duration]) extends AnyWordSpec {

  private val (intStep, scalaStep, javaStep) = step

  typeName should {

    "support step: Int" in {
      (inclusive(from) until to by intStep).toList should contain inOrderElementsOf(contains.dropRight(1))
      (inclusive(from) to to by intStep).toList should contain inOrderElementsOf(contains)
      (exclusive(from) until to by intStep).toList should contain inOrderElementsOf(contains.drop(1).dropRight(1))
      (exclusive(from) to to by intStep).toList should contain inOrderElementsOf(contains.drop(1))
    }

    "support step: FiniteDuration" in {
      (inclusive(from) until to by scalaStep).toList should contain inOrderElementsOf(contains.dropRight(1))
      (inclusive(from) to to by scalaStep).toList should contain inOrderElementsOf(contains)
      (exclusive(from) until to by scalaStep).toList should contain inOrderElementsOf(contains.drop(1).dropRight(1))
      (exclusive(from) to to by scalaStep).toList should contain inOrderElementsOf(contains.drop(1))
    }

    "support step: java.time.Duration" in {
      (inclusive(from) until to by javaStep).toList should contain inOrderElementsOf(contains.dropRight(1))
      (inclusive(from) to to by javaStep).toList should contain inOrderElementsOf(contains)
      (exclusive(from) until to by javaStep).toList should contain inOrderElementsOf(contains.drop(1).dropRight(1))
      (exclusive(from) to to by javaStep).toList should contain inOrderElementsOf(contains.drop(1))
    }
  }
}
