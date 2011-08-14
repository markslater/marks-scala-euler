package euler.scala.marks.problem14

object Problem14 {
  def main(args: Array[String]) {
    println((1 to 1000000).maxBy(theSequence(_)));
  }

  def theSequence(startingPoint: Int, lengthSoFar: Int = 0): Int = {
    if (startingPoint == 1) 1 + lengthSoFar
    else theSequence(if ((startingPoint % 2 == 0)) startingPoint / 2 else (startingPoint * 3) + 1, lengthSoFar + 1)
  }
}