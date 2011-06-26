package euler.scala.marks.problem9

import java.lang.Boolean

object Problem9 {

  def main(args: Array[String]) {
    var pythagorean: (Int, Int, Int) = candidatePythagorean().dropWhile((x: (Int, Int, Int)) => !isPythagorianSquare(x._1, x._2, x._3)).head
    println(pythagorean);
    println((pythagorean._1 * pythagorean._2 * pythagorean._3));
  }

  def candidatePythagorean(candidate: (Int, Int, Int) = tripletSummingTo1000(1, 2)): Stream[(Int, Int, Int)] = {
    if (isValidCandidate(tripletSummingTo1000(candidate._1, candidate._2 + 1))) {
      Stream.cons(candidate, candidatePythagorean(tripletSummingTo1000(candidate._1, candidate._2 + 1)))
    } else if (isValidCandidate(tripletSummingTo1000(candidate._1 + 1, candidate._1 + 2))) {
      Stream.cons(candidate, candidatePythagorean(tripletSummingTo1000(candidate._1 + 1, candidate._1 + 2)))
    } else {
      Stream.cons(candidate, Stream.empty);
    }
  }

  def tripletSummingTo1000(a: Int, b: Int): (Int, Int, Int) = {
    (a, b, 1000 - (a + b))
  }

  def isValidCandidate(candidate: (Int, Int, Int)): Boolean = {
    (candidate._1 < candidate._2 && candidate._2 < candidate._3)
  }

  def isPythagorianSquare(a: Int, b: Int, c: Int) = {
    def squared(x: Int): Int = {
      x * x
    }
    squared(a) + squared(b) == squared(c)
  }
}