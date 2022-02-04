package scalax.range.date

import java.time.ZoneOffset
import java.{time => jt}
import scala.concurrent.duration._

class ZonedDateTimeSpec extends ChronoSpecBase[jt.ZonedDateTime](
  "ZonedDateTime",
  jt.ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC),
  jt.ZonedDateTime.of(2020, 1, 1, 0, 0, 15, 0, ZoneOffset.UTC),
  (1, 1.second, jt.Duration.ofSeconds(1)),
  (0 until 15).toList map {
    jt.ZonedDateTime.of(2020, 1, 1, 0, 0, _, 0, ZoneOffset.UTC)
  }
)
