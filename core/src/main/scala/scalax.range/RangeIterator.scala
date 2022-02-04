package scalax.range

import scalax.range.RangeBuilder._


class RangeIterator[T, S](
  from: Endpoint[T],
  to: Endpoint[T],
  step: S)(implicit ord: Ordering[T], stepper: Stepper[T, S]) extends Iterator[T] {
  import ord._
  import stepper._

  println(s"RangeIterator($from, $to, $step)")

  private var pointer: T = if (from.inclusive) from.point else from.point + step

  override def hasNext: Boolean = {

    val res = if (to.inclusive) pointer <= to.point else pointer < to.point
    println(s"RangeIterator.hasNext: $pointer, (${to.inclusive}) ${to.point}: $res")
    res
  }

  override def next(): T = {
    if (!hasNext) throw new NoSuchElementException("next on empty iterator")

    val e = pointer
    pointer += step

    println(s"RangeIterator.next: was ($e) became (${pointer})")

    e
  }
}
