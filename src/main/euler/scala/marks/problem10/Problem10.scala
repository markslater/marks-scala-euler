package euler.scala.marks.problem10

import collection.immutable.{TreeSet, SortedSet}

object Problem10 {

  def main(args: Array[String]) {
    println(sieve(new TreeSet[Int]().++(2 to 2000000)).reduceLeft(_ + _))
  }

  def sieve(candidatePrimes: SortedSet[Int]): Set[Int] = {
    if (nextPrime == candidatePrimes.max) {
      candidatePrimes
    } else {
      var newCandidates: SortedSet[Int] = candidatePrimes.filterNot((x: Int) => x > nextPrime && x % nextPrime == 0)
      sieve(newCandidates, newCandidates.from(nextPrime).tail.head)
    }
  }
}