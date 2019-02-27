package scalax.range


trait RangeBuilder[+T] {

  def by[TT >: T, S](step: S)(implicit ord: Ordering[TT], s: Stepper[TT, S]): Iterator[TT]
}

object RangeBuilder {

  case class NonEmpty[T: Ordering] private (
    from: Endpoint[T],
    to: Endpoint[T]) extends RangeBuilder[T] {

    def by[TT >: T, S](
      step: S)(implicit
      ord: Ordering[TT],
      s: Stepper[TT, S]): Iterator[TT] = new RangeIterator[TT, S](from, to, step)

    override def toString: String = {
      val l = s"${if (from.inclusive) '[' else '('}${from.point}"
      val r = s"${to.point}${if (to.inclusive) ']' else ')'}"
      s"Range $l, $r"
    }
  }

  case object Empty extends RangeBuilder[Nothing] {

    override def by[TT >: Nothing, S](
      step: S)(implicit
      ord: Ordering[TT],
      s: Stepper[TT, S]): Iterator[TT] = Iterator.empty

    override def toString: String = "Empty Range"
  }

  def apply[T](from: Endpoint[T], to: Endpoint[T])(implicit ord: Ordering[T]): RangeBuilder[T] = {
    import ord._

    if      (from.point >= to.point)                    Empty
    else if (to.exclusive && from.point < to.point)     NonEmpty(from, to)
    else if (to.inclusive && from.point <= to.point)    NonEmpty(from, to)
    else                                                Empty
  }

  case class Endpoint[+T] private (inclusive: Boolean, point: T) {

    @inline def exclusive: Boolean = !inclusive

    def to[TT >: T](that: TT)(implicit o: Ordering[TT]): RangeBuilder[TT] = RangeBuilder(this, Endpoint inclusive that)

    def until[TT >: T](that: TT)(implicit o: Ordering[TT]): RangeBuilder[TT] = RangeBuilder(this, Endpoint exclusive that)

    def to[TT >: T](that: Endpoint[TT])(implicit o: Ordering[TT]): RangeBuilder[TT] = RangeBuilder(this, that)
  }

  object Endpoint {

    def inclusive[T: Ordering](x: T): Endpoint[T] = Endpoint(inclusive = true, x)

    def exclusive[T: Ordering](x: T): Endpoint[T] = Endpoint(inclusive = false, x)
  }
}