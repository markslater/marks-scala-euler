package euler.scala.marks.problem14

import collection.mutable.Map

object Problem14 {
  def main(args: Array[String]) {
    val map: Map[Int, Int] = Map(1 -> 1)
    println((1 to 1000000).maxBy(theSequence(_, map)));
  }

  def cachingSequence(startingPoint: Int, previousSolutions: Map[Int, Int], lengthSoFar: Int = 0): Int = {
    val result: Int = theSequence(startingPoint, previousSolutions)
    previousSolutions.put(startingPoint, result)
    result;
  }

  def theSequence(startingPoint: Int, previousSolutions: Map[Int, Int], lengthSoFar: Int = 0): Int = {
    if (previousSolutions.contains(startingPoint)) lengthSoFar + previousSolutions.get(startingPoint).get
    else if (startingPoint == 1) 1 + lengthSoFar
    else theSequence(if ((startingPoint % 2 == 0)) startingPoint / 2 else (startingPoint * 3) + 1, previousSolutions, lengthSoFar + 1)
  }
}