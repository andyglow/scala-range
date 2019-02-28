package scalax.range

import org.scalatest._
import org.scalatest.Matchers._


class DslSpec extends WordSpec {

  "dsl" when {
    // works with all Numeric members (BigDecimal, BugInteger, Char, ...)
    "byte/byte" should {
      "compile inclusive to"    in { "inclusive(1.toByte) to 5.toByte by 1.toByte" should compile }
      "compile exclusive to"    in { "exclusive(1.toByte) to 5.toByte by 1.toByte" should compile }
      "compile inclusive until" in { "inclusive(1.toByte) to 5.toByte by 1.toByte" should compile }
      "compile exclusive until" in { "exclusive(1.toByte) to 5.toByte by 1.toByte" should compile }
      "compile to"              in { "exclusive(1.toByte) to exclusive(5.toByte) by 1.toByte" should compile }
    }
    "short/short" should {
      "compile inclusive to"    in { "inclusive(1.toShort) to 5.toShort by 1.toShort" should compile }
      "compile exclusive to"    in { "exclusive(1.toShort) to 5.toShort by 1.toShort" should compile }
      "compile inclusive until" in { "inclusive(1.toShort) to 5.toShort by 1.toShort" should compile }
      "compile exclusive until" in { "exclusive(1.toShort) to 5.toShort by 1.toShort" should compile }
      "compile to"              in { "exclusive(1.toShort) to exclusive(5.toShort) by 1.toShort" should compile }
    }
    "int/int" should {
      "compile inclusive to"    in { "inclusive(1) to 5 by 1" should compile }
      "compile exclusive to"    in { "exclusive(1) to 5 by 1" should compile }
      "compile inclusive until" in { "inclusive(1) to 5 by 1" should compile }
      "compile exclusive until" in { "exclusive(1) to 5 by 1" should compile }
      "compile to"              in { "exclusive(1) to exclusive(5) by 1" should compile }
    }
    "long/long" should {
      "compile inclusive to"    in { "inclusive(1l) to 5l by 1l" should compile }
      "compile exclusive to"    in { "exclusive(1l) to 5l by 1l" should compile }
      "compile inclusive until" in { "inclusive(1l) to 5l by 1l" should compile }
      "compile exclusive until" in { "exclusive(1l) to 5l by 1l" should compile }
      "compile to"              in { "exclusive(1l) to exclusive(5l) by 1l" should compile }
    }
    "double/double" should {
      "compile inclusive to"    in { "inclusive(1.5) to 7.82 by 1.5" should compile }
      "compile exclusive to"    in { "exclusive(1.5) to 7.82 by 1.5" should compile }
      "compile inclusive until" in { "inclusive(1.5) to 7.82 by 1.5" should compile }
      "compile exclusive until" in { "exclusive(1.5) to 7.82 by 1.5" should compile }
      "compile to"              in { "exclusive(1.5) to exclusive(7.82) by 1.5" should compile }
    }
    "arbitraty types" should {
      "not compile String/String/Char"     in { "inclusive(\"foo\") to (\"bar\") by 'x'" shouldNot compile }
      "not compile OffsetDateTime/Int/Int" in { "exclusive(OffsetDateTime.now) to 5 by 1" shouldNot compile }
      "not compile Int/Int/FiniteDuration" in { "inclusive(10) to 50 by 1.second" shouldNot compile }
      "not compile int/Int/String"         in { "exclusive(1) to 7 by \"abc\"" shouldNot compile }
    }
  }
}
