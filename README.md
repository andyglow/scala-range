# scala-range
[![Build Status](https://cloud.drone.io/api/badges/andyglow/scala-range/status.svg)](https://cloud.drone.io/andyglow/scala-range)
[![codecov](https://codecov.io/gh/andyglow/scala-range/branch/master/graph/badge.svg?token=3674BUQYDA)](https://codecov.io/gh/andyglow/scala-range)
[![mvn](https://img.shields.io/badge/dynamic/json.svg?label=mvn&query=%24.response.docs%5B0%5D.latestVersion&url=https%3A%2F%2Fsearch.maven.org%2Fsolrsearch%2Fselect%3Fq%3Dscalax-range_2.13%26start%3D0%26rows%3D1)](https://search.maven.org/artifact/com.github.andyglow/scalax-range_2.13/)

Install
```scala
libraryDependencies += "com.github.andyglow" %% "scalax-range" % Version
```

Use
```scala
import scalax.range._

// numeric
for { x <- inclusive(1) to 10 by 1 } println(x)
(exclusive(1) to 10 by 1) foreach println
(inclusive(0.0) until 1.0 by 0.1) foreach println

// date
import scalax.range.date._
import scala.concurrent.duration.FiniteDuration
import java.time.{Duration => JDuration}

for { d <- inclusive(new java.util.Date(0)) to new java.util.Date(100) by 1 } println(x)
for { d <- inclusive(new java.util.Date(0)) to new java.util.Date(1000000) by 1.second } println(x)
for { d <- inclusive(new java.util.Date(0)) to new java.util.Date(1000000) by JDuration.ofSeconds(1) } println(x)
```

# Introduction
This simple dsl tries to overcome limitation of a standard `scala.collection.immutable.Range` which is implemented for only Int.

By using `scala-range` you may leverage the same approach with extended amount of types.

## Supported types

All types which has Numeric type-class implemented
- `Byte`
- `Char`
- `Short`
- `Int`
- `Long`
- `Float`
- `Double`
- `BigInt`
- `BigDecimal`
For iterating through range of numeric types you need use the same type to specify a step. 
So Int is the only possible way to traverse through the range of ints, Double for doubles and so on.

For Date related types the step may be defined as `java.time.Duration` 
or `scala.concurrent.duration.FiniteDuration`.   
 
Standard Date & Time related types
- `java.util.Date`
- `java.time.Instant`
- `java.time.LocalDate`
- `java.time.LocalTime`
- `java.time.LocalDateTime`
- `java.time.OffsetDateTime`
- `java.time.ZonedDateTime`

### JodaTime
JodaTime Date & Time related types
- `org.joda.time.Instant`
- `org.joda.time.LocalDate`
- `org.joda.time.LocalTime`
- `org.joda.time.DateTime`

In order to add joda time support please add additional dependency:
```scala
libraryDependencies += "com.github.andyglow" %% "scalax-range-joda-time" % Version
```
Also additional import line will be required:
```scala
import scalax.range.jodatime._
```
This will also make you able to use `org.joda.time.Duration` as a step definition.

### Numerics to define a Step in Date based Ranges
There is also a way to use numeric types to define a step.
The way it will be treated is different for different types used to define a range. 
Basically the numeric will get converted into `Long` and then this long gets treated uniquely.

- `java.util.Date` (num is seconds)
- `java.time.Instant` (num is seconds)
- `java.time.LocalDate` (num is days)
- `java.time.LocalTime` (num is minutes)
- `java.time.LocalDateTime` (num is hours)
- `java.time.OffsetDateTime` (num is hours)
- `java.time.ZonedDateTime` (num is hours)
- `org.joda.time.Instant` (num is seconds)
- `org.joda.time.LocalDate` (num is days)
- `org.joda.time.LocalTime` (num is minutes)
- `org.joda.time.DateTime` (num is hours)

TODO:
- add support for
  - [ ] https://github.com/typelevel/squants
  - [ ] https://github.com/typelevel/spire