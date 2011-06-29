package euler.scala.marks.problem10

import collection.immutable.{HashSet, TreeSet, SortedSet}

object Problem10 {

  def main(args: Array[String]) {
    println(sieve(new TreeSet[Int]().++(2 to 2000)))
    //    println(sieve(new TreeSet[Int]().++(2 to 20000)).reduceLeft(_ + _))
    //    println(sieve(new TreeSet[Int]().++(2 to 2000000)).reduceLeft(_ + _))
  }

  def sieve(candidatePrimes: SortedSet[Int]): Set[Int] = {
    if (candidatePrimes.isEmpty) {
      new HashSet[Int]()
    } else {
      sieve(candidatePrimes.filterNot(_ % candidatePrimes.head == 0)) + candidatePrimes.head
    }
  }
}