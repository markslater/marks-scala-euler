package euler.scala.marks.problem3


import scala.collection.immutable.TreeSet
import scala.Long
;

object Problem3 {
  def main(args: Array[String]) {
    println(TreeSet[Long]().++:(
      factors(600851475143L)
        .filter(factors(_).size == 2)
    ).max);
  }

  def factors(number: Long): List[Long] = {
    def factors(number: Long, currentCandidate: Long): List[Long] = {
      if ((currentCandidate * currentCandidate) > number) List.empty[Long];
      else if (number % currentCandidate == 0) number / currentCandidate :: ((currentCandidate) :: factors(number, currentCandidate + 1));
      else factors(number, currentCandidate + 1);
    }
    factors(number, 1);
  }

}