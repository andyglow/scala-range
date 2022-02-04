package scalax.range.date

import java.{time => jt}
import scala.concurrent.duration._

class LocalTimeSpec extends ChronoSpecBase[jt.LocalTime](
  "LocalTime",
  jt.LocalTime.of(0, 0, 0),
  jt.LocalTime.of(0, 0, 15),
  (1, 1.second, jt.Duration.ofSeconds(1)),
  (0 until 15).toList map { jt.LocalTime.of(0, 0, _) }
)
