package euler.scala.marks.problem14

object Problem14 {
  def main(args: Array[String]) {
    println(theSequence(13))
  }

  def theSequence(startingPoint: Int): List[Int] = {
    if (startingPoint == 1) List(1)
    else if (startingPoint % 2 == 0) {
      startingPoint :: theSequence(startingPoint / 2)
    } else {
      startingPoint :: theSequence((startingPoint * 3) + 1)
    }
  }
}