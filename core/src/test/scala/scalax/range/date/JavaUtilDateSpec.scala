package scalax.range.date

import java.{time => jt, util => ju}
import scala.concurrent.duration._

class JavaUtilDateSpec extends ChronoSpecBase[ju.Date](
  "java.util.Date",
  ju.Date.from(jt.Instant.ofEpochSecond(0)),
  ju.Date.from(jt.Instant.ofEpochSecond(15)),
  (1, 1.second, jt.Duration.ofSeconds(1)),
  (0 until 15).toList map { sec =>
    ju.Date.from(jt.Instant.ofEpochSecond(sec))
  }
)
