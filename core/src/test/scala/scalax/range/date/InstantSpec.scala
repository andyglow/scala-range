package scalax.range.date

import java.{time => jt}
import scala.concurrent.duration._

class InstantSpec extends ChronoSpecBase[jt.Instant](
  "Instant",
  jt.Instant.ofEpochSecond(0),
  jt.Instant.ofEpochSecond(15),
  (1, 1.second, jt.Duration.ofSeconds(1)),
  (0 until 15).toList map {
    jt.Instant.ofEpochSecond(_)
  }
)
