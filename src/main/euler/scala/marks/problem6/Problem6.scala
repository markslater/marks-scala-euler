package euler.scala.marks.problem6

object Problem6 {

  def sumOfSquares(range: Iterable[Long]): Long = {
    range.map(x => x * x).reduceLeft(_ + _)
  }

  def squareOfSums(range: Iterable[Long]): Long = {
    def squared(x: Long): Long = {
      x * x
    }
    squared(range.reduceLeft(_ + _))
  }

  def main(args: Array[String]) {
    val range = 1L to 100L
    println(squareOfSums(range) - sumOfSquares(range));
  }
}