package euler.scala.marks.problem12

object Problem12 {
  def main(args: Array[String]) {
    println(triangularNumbers().find(factors(_).length > 500));
  }

  def triangularNumbers(term: Int = 1): Stream[Long] = {
    Stream.cons(triangularNumber(term), triangularNumbers(term + 1))
  }

  def triangularNumber(n: Long): Long = {
    ((1 + n) * n) / 2
  }

  def factors(number: Long, currentCandidate: Long = 1): List[Long] = {
    if ((currentCandidate * currentCandidate) > number) List.empty[Long];
    else if (number % currentCandidate == 0) number / currentCandidate :: ((currentCandidate) :: factors(number, currentCandidate + 1));
    else factors(number, currentCandidate + 1);
  }

}