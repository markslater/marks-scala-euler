package euler.scala.marks.problem10

import collection.Iterable

object Problem10 {

  def main(args: Array[String]) {
    val primes: Stream[Int] = sieve(200000)
    for (prime <- primes) {
      println(prime)
    }
    //    println(sieve(200000).reduceLeft(_ + _))
  }

  def sieve(maxPrime: Int): Stream[Int] = {
    def sieve(candidatePrimes: Iterable[Int]): Stream[Int] = {
      if (candidatePrimes.isEmpty) {
        Stream.empty;
      } else {
        val nextPrime: Int = candidatePrimes.head
        val remainingCandidates: Iterable[Int] = candidatePrimes.filter(_ % nextPrime != 0)
        Stream.cons(nextPrime, sieve(remainingCandidates));
      }
    }
    Stream.cons(2, sieve(3 to maxPrime by 2));
  }

}