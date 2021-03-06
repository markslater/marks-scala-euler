package euler.scala.marks.problem10

import collection.Iterable

object Problem10 {

  def main(args: Array[String]) {
    println(sieveAndSum(2000000))
  }

  def sieveAndSum(maxPrime: Int): Long = {
    def sieveAndSum(candidatePrimes: Iterable[Int], sumOfPrimes: Long): Long = {
      if (candidatePrimes.isEmpty)
        sumOfPrimes
      else {
        val nextPrime: Int = candidatePrimes.head
        val remainingCandidates: Iterable[Int] = candidatePrimes.filter(_ % nextPrime != 0)
        sieveAndSum(remainingCandidates, sumOfPrimes + nextPrime)
      }
    }
    sieveAndSum(3 to maxPrime by 2, 2L)
  }

}