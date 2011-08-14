package euler.scala.marks.problem14

import java.lang.Boolean

object Problem14 {
  def main(args: Array[String]) {
    println(longestSequence((1 to 100000).toSet))
  }

  def longestSequence(currentTerms: Set[Int]): List[Int] = {
    def longestSequence(currentTerms: Set[List[Int]]): List[Int] = {
      val unfinishedSequences: Set[List[Int]] = currentTerms.filter(_.head != 1)
      val expandedSequences: Set[List[Int]] = unfinishedSequences.map(x => nextTerm(x.head) :: x)
      val newTerms: Set[Int] = expandedSequences.map(_.head)
      val sequencesThatHaveNotBeenOvertaken: Set[List[Int]] = expandedSequences.filter(!intersects(newTerms, _))
      if (sequencesThatHaveNotBeenOvertaken.size == 1) sequencesThatHaveNotBeenOvertaken.head
      else longestSequence(sequencesThatHaveNotBeenOvertaken)
    }
    longestSequence(currentTerms.map(List(_)))
  }

  def intersects(a: Set[Int], b: List[Int]): Boolean = {
    a.intersect(b.tail.toSet).size > 0
  }

  def nextTerm(currentTerm: Int): Int = {
    if ((currentTerm % 2 == 0)) currentTerm / 2 else (currentTerm * 3) + 1
  }

}