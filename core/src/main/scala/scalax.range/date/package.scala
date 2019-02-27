package scalax.range

import java.time.{LocalDate, LocalDateTime, ZonedDateTime}


package object date {

  implicit val localDateOrd: Ordering[LocalDate] = Ordering fromLessThan { _.compareTo(_) > 0 }

  implicit val localDateTimeOrd: Ordering[LocalDateTime] = Ordering fromLessThan { _.compareTo(_) > 0 }

  implicit val zonedDateTimeOrd: Ordering[ZonedDateTime] = Ordering fromLessThan { _.compareTo(_) > 0 }
}
