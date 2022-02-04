package scalax.range.date

import java.{time => jt}
import scala.concurrent.duration._

class LocalDateTimeSpec extends ChronoSpecBase[jt.LocalDateTime](
  "LocalDateTime",
  jt.LocalDateTime.of(2020, jt.Month.JANUARY, 1, 0, 0, 0),
  jt.LocalDateTime.of(2020, jt.Month.JANUARY, 1, 0, 0, 15),
  (1, 1.second, jt.Duration.ofSeconds(1)),
  (0 until 15).toList map { jt.LocalDateTime.of(2020, jt.Month.JANUARY, 1, 0, 0, _) }
)
