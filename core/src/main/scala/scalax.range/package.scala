package scalax

import scalax.range.RangeBuilder.Endpoint

import scala.language.implicitConversions


package object range {

  implicit def inclusive[T: Ordering](x: T): Endpoint[T] = Endpoint inclusive x

  def exclusive[T: Ordering](x: T): Endpoint[T] = Endpoint exclusive x
}