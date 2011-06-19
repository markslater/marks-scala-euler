package euler.scala.marks.problem5

object Problem5 {
  def main(args: Array[String]) {
    println((1 to 20).reduceLeft(smallestCommonMultiple(_, _)));
  }

  def smallestCommonMultiple(x: Int, y: Int, multiplier: Int = 1) :Int = {
    if (((x * multiplier) % y) == 0) x * multiplier;
    else smallestCommonMultiple(x, y, multiplier + 1)
  }
}