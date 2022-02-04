package scalax.range.date

import java.{ time => jt }
import scala.concurrent.duration._

class LocalDateSpec extends ChronoSpecBase[jt.LocalDate](
  "LocalDate",
  jt.LocalDate.of(2020, jt.Month.JANUARY, 1),
  jt.LocalDate.of(2020, jt.Month.JANUARY, 15),
  (1, 1.day, jt.Duration.ofDays(1)),
  (1 until 16).toList map { jt.LocalDate.of(2020, jt.Month.JANUARY, _) }
)
