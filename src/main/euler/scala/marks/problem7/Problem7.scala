package euler.scala.marks.problem7

import collection.immutable.{TreeSet, SortedSet}

object Problem7 {

  def main(args: Array[String]) {
    println(primes().drop(10000).head);
  }

  def primes(): Stream[Int] = {
    def primes(priorPrimes: SortedSet[Int]): Stream[Int] = {
      val prime: Int = nextPrime(priorPrimes)
      Stream.cons(prime, primes(priorPrimes + prime))
    }
    Stream.cons(2, primes(TreeSet[Int]() + 2));
  }

  def nextPrime(priorPrimes: SortedSet[Int]): Int = {
    def nextPrime(priorPrimes: SortedSet[Int], candidate: Int): Int = {
      if (!priorPrimes.exists(candidate % _ == 0)) candidate
      else nextPrime(priorPrimes, candidate + 1);
    }
    nextPrime(priorPrimes, priorPrimes.last + 1)
  }
}