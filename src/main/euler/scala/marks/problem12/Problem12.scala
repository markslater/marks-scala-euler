package euler.scala.marks.problem12

object Problem12 {
  def main(args: Array[String]) {
    for (i <- triangularNumbers()) println(i)
  }

  def triangularNumbers(term: Int = 1): Stream[Long] = {
    Stream.cons(triangularNumber(term), triangularNumbers(term + 1))
  }

  def triangularNumber(n: Long): Long = {
    ((1 + n) * n) / 2
  }
}