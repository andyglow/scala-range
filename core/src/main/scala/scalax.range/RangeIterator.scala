package scalax.range

import RangeBuilder._


class RangeIterator[T, S](
  from: Endpoint[T],
  to: Endpoint[T],
  step: S)(implicit ord: Ordering[T], stepper: Stepper[T, S]) extends Iterator[T] {
  import ord._
  import stepper._

  private var pointer: T = if (from.inclusive) from.point else from.point + step

  override def hasNext: Boolean =
    if (to.inclusive) pointer <= to.point else pointer < to.point

  override def next(): T = {
    if (!hasNext) throw new NoSuchElementException("next on empty iterator")

    val e = pointer
    pointer += step

    e
  }
}
