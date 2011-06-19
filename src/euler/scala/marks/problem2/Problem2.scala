package euler.scala.marks.problem2

object Problem2 {
  def main(args: Array[String]) {
    println(
      sumUntilFourMillion(
        fibonacci()
          .filter(_ % 2 == 0)
      )
    );
  }

  def fibonacci(): Stream[Int] = {
    def fibonacci(i: Int, j: Int): Stream[Int] = {
      Stream.cons(i, fibonacci(j, i+j))
    }
    fibonacci(1, 2);
  }

  def sumUntilFourMillion(stream: Iterable[Int]): Int = {
    def sumUntilFourMillion(stream: Iterable[Int], accumulator: Int): Int = {
      if (stream.head > 4000000) accumulator;
      else sumUntilFourMillion(stream.tail, accumulator + stream.head);
    }
    sumUntilFourMillion(stream, 0);
  }
}