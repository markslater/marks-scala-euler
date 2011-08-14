package euler.scala.marks.problem14

import java.lang.Boolean

object Problem14 {
  def main(args: Array[String]) {
    println(moreTerms((1 to 1000000).toSet))
  }

  def moreTerms(candidates: Set[Int], numberOfTerms: Int = 1): Int = {
    val newCandidates: Set[Int] = candidates.filter(hasTerm(_, numberOfTerms))
    if (newCandidates.size == 1) newCandidates.head
    else moreTerms(newCandidates, numberOfTerms + 1)
  }

  def hasTerm(firstTerm: Int, termNumber: Int): Boolean = {
    if (termNumber == 1) true
    else if (firstTerm == 1) false
    else hasTerm(if ((firstTerm % 2 == 0)) firstTerm / 2 else (firstTerm * 3) + 1, termNumber - 1)
  }
}