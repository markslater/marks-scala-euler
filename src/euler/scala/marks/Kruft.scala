package euler.scala.marks

import collection.SortedSet
import collection.immutable.TreeSet

object Kruft {
         def sieveOfEratosthenes(maximumCandidatePrime: Int): List[Int] = {
    def sieveOfEratosthenes(candidatePrimes: SortedSet[Int]): List[Int] = {
      if (candidatePrimes.isEmpty) List.empty;
      else candidatePrimes.head :: sieveOfEratosthenes(candidatePrimes.tail &~ candidatePrimes.map(_*candidatePrimes.head));
    }
    sieveOfEratosthenes(TreeSet[Int]() ++ (2 to maximumCandidatePrime));
  }

  def greatestCommonDivisor(x: Int, y: Int): Int = {
    def minimum (x: Int, y: Int): Int = { if (x < y) x; else y; }
    def maximum (x: Int, y: Int): Int = { if (x > y) x; else y; }
    if (minimum(x, y) == 0) maximum(x, y);
    else greatestCommonDivisor(minimum(x, y), maximum(x, y) - minimum (x, y));
  }
}