package euler.scala.marks.problem10

import collection.Iterable

object Problem10 {

  def main(args: Array[String]) {
    println(sieveIterative(10).reduceLeft(_ + _))
  }

  def sieveIterative(maxPrime: Int): Iterable[Int] = {
    var result = List(2)
    var candidates: Iterable[Int] = 3 to maxPrime by 2
    for (i <- 3 to maxPrime by 2) {
      if (!candidates.isEmpty && i == candidates.head) {
        result = candidates.head :: result
        candidates = candidates.filter(_ % i != 0)
      }
    }
    result;
  }

  def sieveRecursive(maxPrime: Int): Iterable[Int] = {
    def sieve(candidatePrimes: Iterable[Int]): List[Int] = {
      val nextPrime: Int = candidatePrimes.head
      val remainingCandidates: Iterable[Int] = candidatePrimes.filter(_ % nextPrime != 0)
      nextPrime :: (if (remainingCandidates.isEmpty) Nil else sieve(remainingCandidates))
    }
    2 :: sieve(3 to maxPrime by 2)
  }

  def sieve(maxPrime: Int): Stream[Int] = {
    def sieve(candidatePrimes: Iterable[Int]): Stream[Int] = {
      val nextPrime: Int = candidatePrimes.head
      val remainingCandidates: Iterable[Int] = candidatePrimes.filter(_ % nextPrime != 0)
      Stream.cons(
        nextPrime,
        if (remainingCandidates.isEmpty)
          Stream.empty
        else
          sieve(remainingCandidates)
      );
    }
    Stream.cons(2, sieve(3 to maxPrime by 2));
  }

}