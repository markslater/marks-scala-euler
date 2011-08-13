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

  //  def sieved(maxPrime: Int): Iterable[Int] = {
  //    for (i <- 1 to maxPrime by 2) {
  //
  //    }
  //  }

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