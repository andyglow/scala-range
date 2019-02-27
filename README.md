# scala-range
[![Build Status](https://travis-ci.org/andyglow/scala-range.svg)](https://travis-ci.org/andyglow/scala-range)
![Maven Central 2.11](https://img.shields.io/maven-central/v/com.github.andyglow/scalax-range_2.11.svg)
![Maven Central 2.12](https://img.shields.io/maven-central/v/com.github.andyglow/scalax-range_2.12.svg)
[![Coverage Status](https://coveralls.io/repos/github/andyglow/scala-range/badge.svg?branch=master)](https://coveralls.io/github/andyglow/scala-range?branch=master)

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

By using `scala-range` you may leverage the same approach with wider amount of types.

## Supported types

All types which has Numeric type-class implemented
- Byte
- Char
- Short
- Int
- Long
- Float
- Double
- BigInt
- BigDecimal
 
Standard Date & Time related types
- java.util.Date
- java.time.Instant
- java.time.LocalDate
- java.time.LocalTime
- java.time.LocalDateTime
- java.time.OffsetDateTime
- java.time.ZonedDateTime

### JodaTime
JodaTime Date & Time related types
