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

  /**
  P02: Find the last but one element of a list 
  */
  def P02[T] (xs: List[T]): T = {
    xs.size match {
      case 2 => xs.head
      case _ => last(xs.tail)
    }
  }
}
