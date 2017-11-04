object Main {

  def main(args: Array[String]): Unit = {
    println("please run -> sbt test")
  }

  /**
   last: Find the last element of a list 
   */
  def last[T] (xs: List[T]): T = {
    xs.size match {
      case 1 => xs.head
      case _ => last(xs.tail)
    }
  }

  /**
   penultimate: Find the last but one element of a list 
   */
  def penultimate[T] (xs: List[T]): T = {
    xs.size match {
      case 2 => xs.head
      case _ => penultimate(xs.tail)
    }
  }

  /**
   nth: Find the Kth element of a list.
   */
  def nth[T] (n: Int, xs: List[T]): T =
    if (n >= 0) xs(n)
    else throw new NoSuchElementException

  def length[T] (xs: List[T]): Int = xs.size
}
