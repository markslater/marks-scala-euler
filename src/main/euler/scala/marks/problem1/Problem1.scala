package euler.scala.marks.problem1

object Problem1 {
  def main(args: Array[String]) {
    println(
      (0 to 999)
        .filter(x => (x % 3 == 0) | (x % 5 == 0))
        .reduceLeft(_ + _)
    );
  }
}