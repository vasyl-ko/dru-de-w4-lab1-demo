import scala.io.{Codec, Source}

object Main {
  def main(arg: Array[String]): Unit = {
    def sourceIterator: Iterator[String] =
      Source
        .fromResource("user-ct-test-collection-01.txt")(Codec.ISO8859)
        .getLines()

    val records: Vector[LogRecord] = sourceIterator.flatMap(LogRecord.parse).toVector
    println("size")

    println(records.size)

    val task1: (String, Int) = records.groupBy(_.id).mapValues(_.size).maxBy(_._2)
    println("task 1")

    println(task1)

    val task2: (Int, Int) = records.groupBy(_.timestamp.getHour).mapValues(_.size).maxBy(_._2)
    println("task 2")
    println(task2)

    val task3 = records.groupBy(_.query).mapValues(_.size).toVector.sortWith(_._2 > _._2).take(3)

    println("task 3")
    println(task3)

    // Vector[(url, Vector[Int])]
    val task4: Map[String, Vector[Int]] = records.collect{
      case LogRecord(_, _, _, Some(rank), Some(url)) => url -> rank
    }.groupBy(_._1).mapValues(_.map(_._2).distinct).filter(_._2.size > 10)

    println("task 4")
    println(task4.mkString("\n"))

    def task5(keywords: Vector[String]) = records
      .filter(r => keywords
        .exists(keyword => r.query.contains(keyword))
      ).map(_.query)

    println("Task 5")
    println(task5(Vector("scala")).mkString("\n"))




  }
}
