object Main {

  def main(args: Array[String]): Unit = {
    println("please run -> sbt test")
  }

  /**
  P01: Find the last element of a list 
  */
  def P01[T] (xs: List[T]): T = {
    xs.size match {
      case 1 => xs.head
      case _ => P01(xs.tail)
    }
  }

}
