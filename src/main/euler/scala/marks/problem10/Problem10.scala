package euler.scala.marks.problem10

import collection.Iterable

object Problem10 {

  def main(args: Array[String]) {
    println(sieve(2000000).reduceLeft(_ + _))
  }

  def sieve(maxPrime: Int): Iterable[Int] = {
    def sieve(candidatePrimes: Iterable[Int], primes: List[Int]): List[Int] = {
      if (candidatePrimes.isEmpty)
        primes
      else {
        val nextPrime: Int = candidatePrimes.head
        val remainingCandidates: Iterable[Int] = candidatePrimes.filter(_ % nextPrime != 0)
        sieve(remainingCandidates, nextPrime :: primes)
      }
    }
    2 :: sieve(3 to maxPrime by 2, Nil)
  }

}