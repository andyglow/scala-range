package scalax.range

import org.scalatest._
import org.scalatest.Matchers._
import scalax.range.date._

import java.util.Date
import java.time.{Duration => JDuration, _}
import scala.concurrent.duration._


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
    "java.util.Date" when {
      "FiniteDuration" should {
        "compile inclusive to"    in { "inclusive(new Date) to (new Date) by 1.second" should compile }
        "compile exclusive to"    in { "exclusive(new Date) to (new Date) by 1.second" should compile }
        "compile inclusive until" in { "inclusive(new Date) to (new Date) by 1.second" should compile }
        "compile exclusive until" in { "exclusive(new Date) to (new Date) by 1.second" should compile }
        "compile to"              in { "exclusive(new Date) to exclusive(new Date) by 1.second" should compile }
      }
      "java.time.Duration" should {
        "compile inclusive to"    in { "inclusive(new Date) to (new Date) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive to"    in { "exclusive(new Date) to (new Date) by JDuration.ofSeconds(1)" should compile }
        "compile inclusive until" in { "inclusive(new Date) to (new Date) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive until" in { "exclusive(new Date) to (new Date) by JDuration.ofSeconds(1)" should compile }
        "compile to"              in { "exclusive(new Date) to exclusive(new Date) by JDuration.ofSeconds(1)" should compile }
      }
      "Numeric" should {
        "compile inclusive to"    in { "inclusive(new Date) to (new Date) by 1" should compile }
        "compile exclusive to"    in { "exclusive(new Date) to (new Date) by 1" should compile }
        "compile inclusive until" in { "inclusive(new Date) to (new Date) by 1" should compile }
        "compile exclusive until" in { "exclusive(new Date) to (new Date) by 1" should compile }
        "compile to"              in { "exclusive(new Date) to exclusive(new Date) by 1" should compile }
      }
    }
    "java.time.Instant" when {
      "FiniteDuration" should {
        "compile inclusive to"    in { "inclusive(Instant.now) to (Instant.now) by 1.second" should compile }
        "compile exclusive to"    in { "exclusive(Instant.now) to (Instant.now) by 1.second" should compile }
        "compile inclusive until" in { "inclusive(Instant.now) to (Instant.now) by 1.second" should compile }
        "compile exclusive until" in { "exclusive(Instant.now) to (Instant.now) by 1.second" should compile }
        "compile to"              in { "exclusive(Instant.now) to exclusive(Instant.now) by 1.second" should compile }
      }
      "java.time.Duration" should {
        "compile inclusive to"    in { "inclusive(Instant.now) to (Instant.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive to"    in { "exclusive(Instant.now) to (Instant.now) by JDuration.ofSeconds(1)" should compile }
        "compile inclusive until" in { "inclusive(Instant.now) to (Instant.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive until" in { "exclusive(Instant.now) to (Instant.now) by JDuration.ofSeconds(1)" should compile }
        "compile to"              in { "exclusive(Instant.now) to exclusive(Instant.now) by JDuration.ofSeconds(1)" should compile }
      }
      "Numeric" should {
        "compile inclusive to"    in { "inclusive(Instant.now) to (Instant.now) by 1" should compile }
        "compile exclusive to"    in { "exclusive(Instant.now) to (Instant.now) by 1" should compile }
        "compile inclusive until" in { "inclusive(Instant.now) to (Instant.now) by 1" should compile }
        "compile exclusive until" in { "exclusive(Instant.now) to (Instant.now) by 1" should compile }
        "compile to"              in { "exclusive(Instant.now) to exclusive(Instant.now) by 1" should compile }
      }
    }
    "java.time.LocalDate" when {
      "FiniteDuration" should {
        "compile inclusive to"    in { "inclusive(LocalDate.now) to (LocalDate.now) by 1.second" should compile }
        "compile exclusive to"    in { "exclusive(LocalDate.now) to (LocalDate.now) by 1.second" should compile }
        "compile inclusive until" in { "inclusive(LocalDate.now) to (LocalDate.now) by 1.second" should compile }
        "compile exclusive until" in { "exclusive(LocalDate.now) to (LocalDate.now) by 1.second" should compile }
        "compile to"              in { "exclusive(LocalDate.now) to exclusive(LocalDate.now) by 1.second" should compile }
      }
      "java.time.Duration" should {
        "compile inclusive to"    in { "inclusive(LocalDate.now) to (LocalDate.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive to"    in { "exclusive(LocalDate.now) to (LocalDate.now) by JDuration.ofSeconds(1)" should compile }
        "compile inclusive until" in { "inclusive(LocalDate.now) to (LocalDate.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive until" in { "exclusive(LocalDate.now) to (LocalDate.now) by JDuration.ofSeconds(1)" should compile }
        "compile to"              in { "exclusive(LocalDate.now) to exclusive(LocalDate.now) by JDuration.ofSeconds(1)" should compile }
      }
      "Numeric" should {
        "compile inclusive to"    in { "inclusive(LocalDate.now) to (LocalDate.now) by 1" should compile }
        "compile exclusive to"    in { "exclusive(LocalDate.now) to (LocalDate.now) by 1" should compile }
        "compile inclusive until" in { "inclusive(LocalDate.now) to (LocalDate.now) by 1" should compile }
        "compile exclusive until" in { "exclusive(LocalDate.now) to (LocalDate.now) by 1" should compile }
        "compile to"              in { "exclusive(LocalDate.now) to exclusive(LocalDate.now) by 1" should compile }
      }
    }
    "java.time.LocalTime" when {
      "FiniteDuration" should {
        "compile inclusive to"    in { "inclusive(LocalTime.now) to (LocalTime.now) by 1.second" should compile }
        "compile exclusive to"    in { "exclusive(LocalTime.now) to (LocalTime.now) by 1.second" should compile }
        "compile inclusive until" in { "inclusive(LocalTime.now) to (LocalTime.now) by 1.second" should compile }
        "compile exclusive until" in { "exclusive(LocalTime.now) to (LocalTime.now) by 1.second" should compile }
        "compile to"              in { "exclusive(LocalTime.now) to exclusive(LocalTime.now) by 1.second" should compile }
      }
      "java.time.Duration" should {
        "compile inclusive to"    in { "inclusive(LocalTime.now) to (LocalTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive to"    in { "exclusive(LocalTime.now) to (LocalTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile inclusive until" in { "inclusive(LocalTime.now) to (LocalTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive until" in { "exclusive(LocalTime.now) to (LocalTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile to"              in { "exclusive(LocalTime.now) to exclusive(LocalTime.now) by JDuration.ofSeconds(1)" should compile }
      }
      "Numeric" should {
        "compile inclusive to"    in { "inclusive(LocalTime.now) to (LocalTime.now) by 1" should compile }
        "compile exclusive to"    in { "exclusive(LocalTime.now) to (LocalTime.now) by 1" should compile }
        "compile inclusive until" in { "inclusive(LocalTime.now) to (LocalTime.now) by 1" should compile }
        "compile exclusive until" in { "exclusive(LocalTime.now) to (LocalTime.now) by 1" should compile }
        "compile to"              in { "exclusive(LocalTime.now) to exclusive(LocalTime.now) by 1" should compile }
      }
    }
    "java.time.LocalDateTime" when {
      "FiniteDuration" should {
        "compile inclusive to"    in { "inclusive(LocalDateTime.now) to (LocalDateTime.now) by 1.second" should compile }
        "compile exclusive to"    in { "exclusive(LocalDateTime.now) to (LocalDateTime.now) by 1.second" should compile }
        "compile inclusive until" in { "inclusive(LocalDateTime.now) to (LocalDateTime.now) by 1.second" should compile }
        "compile exclusive until" in { "exclusive(LocalDateTime.now) to (LocalDateTime.now) by 1.second" should compile }
        "compile to"              in { "exclusive(LocalDateTime.now) to exclusive(LocalDateTime.now) by 1.second" should compile }
      }
      "java.time.Duration" should {
        "compile inclusive to"    in { "inclusive(LocalDateTime.now) to (LocalDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive to"    in { "exclusive(LocalDateTime.now) to (LocalDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile inclusive until" in { "inclusive(LocalDateTime.now) to (LocalDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive until" in { "exclusive(LocalDateTime.now) to (LocalDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile to"              in { "exclusive(LocalDateTime.now) to exclusive(LocalDateTime.now) by JDuration.ofSeconds(1)" should compile }
      }
      "Numeric" should {
        "compile inclusive to"    in { "inclusive(LocalDateTime.now) to (LocalDateTime.now) by 1" should compile }
        "compile exclusive to"    in { "exclusive(LocalDateTime.now) to (LocalDateTime.now) by 1" should compile }
        "compile inclusive until" in { "inclusive(LocalDateTime.now) to (LocalDateTime.now) by 1" should compile }
        "compile exclusive until" in { "exclusive(LocalDateTime.now) to (LocalDateTime.now) by 1" should compile }
        "compile to"              in { "exclusive(LocalDateTime.now) to exclusive(LocalDateTime.now) by 1" should compile }
      }
    }
    "java.time.ZonedDateTime" when {
      "FiniteDuration" should {
        "compile inclusive to"    in { "inclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1.second" should compile }
        "compile exclusive to"    in { "exclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1.second" should compile }
        "compile inclusive until" in { "inclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1.second" should compile }
        "compile exclusive until" in { "exclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1.second" should compile }
        "compile to"              in { "exclusive(ZonedDateTime.now) to exclusive(ZonedDateTime.now) by 1.second" should compile }
      }
      "java.time.Duration" should {
        "compile inclusive to"    in { "inclusive(ZonedDateTime.now) to (ZonedDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive to"    in { "exclusive(ZonedDateTime.now) to (ZonedDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile inclusive until" in { "inclusive(ZonedDateTime.now) to (ZonedDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive until" in { "exclusive(ZonedDateTime.now) to (ZonedDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile to"              in { "exclusive(ZonedDateTime.now) to exclusive(ZonedDateTime.now) by JDuration.ofSeconds(1)" should compile }
      }
      "Numeric" should {
        "compile inclusive to"    in { "inclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1" should compile }
        "compile exclusive to"    in { "exclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1" should compile }
        "compile inclusive until" in { "inclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1" should compile }
        "compile exclusive until" in { "exclusive(ZonedDateTime.now) to (ZonedDateTime.now) by 1" should compile }
        "compile to"              in { "exclusive(ZonedDateTime.now) to exclusive(ZonedDateTime.now) by 1" should compile }
      }
    }
    "java.time.OffsetDateTime" when {
      "FiniteDuration" should {
        "compile inclusive to"    in { "inclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1.second" should compile }
        "compile exclusive to"    in { "exclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1.second" should compile }
        "compile inclusive until" in { "inclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1.second" should compile }
        "compile exclusive until" in { "exclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1.second" should compile }
        "compile to"              in { "exclusive(OffsetDateTime.now) to exclusive(OffsetDateTime.now) by 1.second" should compile }
      }
      "java.time.Duration" should {
        "compile inclusive to"    in { "inclusive(OffsetDateTime.now) to (OffsetDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive to"    in { "exclusive(OffsetDateTime.now) to (OffsetDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile inclusive until" in { "inclusive(OffsetDateTime.now) to (OffsetDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile exclusive until" in { "exclusive(OffsetDateTime.now) to (OffsetDateTime.now) by JDuration.ofSeconds(1)" should compile }
        "compile to"              in { "exclusive(OffsetDateTime.now) to exclusive(OffsetDateTime.now) by JDuration.ofSeconds(1)" should compile }
      }
      "Numeric" should {
        "compile inclusive to"    in { "inclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1" should compile }
        "compile exclusive to"    in { "exclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1" should compile }
        "compile inclusive until" in { "inclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1" should compile }
        "compile exclusive until" in { "exclusive(OffsetDateTime.now) to (OffsetDateTime.now) by 1" should compile }
        "compile to"              in { "exclusive(OffsetDateTime.now) to exclusive(OffsetDateTime.now) by 1" should compile }
      }
    }
    "arbitraty types" should {
      "not compile String/String/Char"     in { "inclusive(\"foo\") to (\"bar\") by 'x'" shouldNot compile }
      "not compile OffsetDateTime/Int/Int" in { "exclusive(OffsetDateTime.now) to 5 by 1" shouldNot compile }
      "not compile Int/Int/FiniteDuration" in { "inclusive(10) to 50 by 1.second" shouldNot compile }
      "not compile int/Int/String"         in { "exclusive(1) to 7 by \"abc\"" shouldNot compile }
    }
  }
}
