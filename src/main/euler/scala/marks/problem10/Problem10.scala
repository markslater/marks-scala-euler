package euler.scala.marks.problem10

import collection.immutable.{TreeSet, SortedSet}

object Problem10 {

  def main(args: Array[String]) {
    val primes: Stream[Int] = sieve(new TreeSet[Int]().++(2 to 20000))
    for (prime <- primes) {
      println(prime)
    }
    //    println(sieve(new TreeSet[Int]().++(2 to 20000)).reduceLeft(_ + _))
    //    println(sieve(new TreeSet[Int]().++(2 to 2000000)).reduceLeft(_ + _))
  }

  def sieve(candidatePrimes: SortedSet[Int]): Stream[Int] = {
    if (candidatePrimes.isEmpty) {
      Stream.empty;
    } else {
      Stream.cons(candidatePrimes.head, sieve(candidatePrimes.filter(_ % candidatePrimes.head != 0)));
    }
  }
}