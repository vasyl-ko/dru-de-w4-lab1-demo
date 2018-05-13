import java.time.format.DateTimeFormatter
import java.time.{LocalDate, LocalDateTime}

import scala.util.Try



final case class LogRecord(id: String, query: String, timestamp: LocalDateTime, itemRank: Option[Int], url: Option[String])

object LogRecord {
  val recordRegex = """^(\d+)\t([^\t]*)\t([^\t]*)\t(\d+)?\t?([^\t]*)?$""".r
  //2006-03-18 08:02:58
  val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  def parse(string: String): Option[LogRecord] = string match {
    case recordRegex(id, query, timestampString, itemRank, url) =>
      val dateTime = LocalDateTime.parse(timestampString, dateTimeFormatter)
      Option(LogRecord(id, query, dateTime, Try(itemRank.toInt).toOption, Option(url)))
    case s =>
      println(s)
      None
  }
}

class Lab1(val records: Vector[LogRecord]) {

  def task1(replyBytes: Int): Set[String] = Set()

  def task2(request: String): Set[Int] = Set()

  def task3(request: String): Set[String] = Set()

  def task4(username: String, date: LocalDate): Set[String] = Set()

  def task5(username: String): Set[LocalDate] = Set()

  def task6(username: String, date: LocalDate): Boolean = false

  def task7(startDate: LocalDate, endDate: LocalDate): Vector[String] = Vector()

  def task8: Option[Int] = None

  def task9(n: Int): Vector[String] = Vector()

  def task10(date: LocalDate): Vector[String] = Vector()

  def task11(startDate: LocalDate, endDate: LocalDate): Set[String] = Set()

  def task12(request: String): Vector[String] = Vector()

  def task13(n: Int, startDate: LocalDate, endDate: LocalDate): Set[String] = Set()

  def task14(startDate: LocalDate, endDate: LocalDate): Option[String] = None

  def task15(startDate: LocalDate, endDate: LocalDate): Option[Double] = None
}
