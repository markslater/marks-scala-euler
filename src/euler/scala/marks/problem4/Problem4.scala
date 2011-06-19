package euler.scala.marks.problem4

import java.lang.Math

object Problem4 {
  def main(args: Array[String]) {
    println((999 * 999 to 1 by -1).filter(isPalindromic).filter(hasTwoThreeDigitFactors).head);
    def isPalindromic(candidatePalindrome: Int): Boolean = {
      val candidatePalindromeString = candidatePalindrome.toString
      val length = (candidatePalindromeString.length / 2.0).floor.intValue()
      candidatePalindromeString.substring(0, length).equals(candidatePalindromeString.substring(candidatePalindromeString.length() - length).reverse)
    }

    def hasTwoThreeDigitFactors(candidate: Int) :Boolean = {
      factors(candidate).filter(isThreeDigit).exists((x :Int) => isThreeDigit((candidate / x ).intValue()))
    }

    def isThreeDigit(candidate: Int) :Boolean = {
      Math.log10(candidate) >= 2.0 && Math.log10(candidate) < 3.0;
    }

      def factors(number: Int, currentCandidate: Int = 1): List[Int] = {
        if ((currentCandidate * currentCandidate) > number) List.empty[Int];
        else if (number % currentCandidate == 0) number / currentCandidate :: ((currentCandidate) :: factors(number, currentCandidate + 1));
        else factors(number, currentCandidate + 1);
      }

  }

}