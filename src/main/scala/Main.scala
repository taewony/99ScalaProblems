object Main {

  def main(args: Array[String]): Unit = {
    println("please run -> sbt test")
  }

  // P01 - Find the last element of a list 
  def last[T] (xs: List[T]): T = {
    xs.size match {
      case 1 => xs.head
      case _ => last(xs.tail)
    }
  }

  // P02 - Find the last but one element of a list 
  def penultimate[T] (xs: List[T]): T = {
    xs.size match {
      case 2 => xs.head
      case _ => penultimate(xs.tail)
    }
  }

  // P03 - Find the Kth element of a list.
  def nth[T] (n: Int, xs: List[T]): T =
    if (n >= 0) xs(n)
    else throw new NoSuchElementException

  // P04 - find the number of elements of a list (folding)
  def length[T] (xs: List[T]): Int = xs.foldLeft(0)((count,_)=>count+1)

  // P05 - reverse a list (folding)
  def reverse[T] (xs: List[T]): List[T] = xs.foldLeft(List.empty[T])((n,e)=>e::n)

  // P06 - find out whether a list is palyndrome
  def isPalindrome[T] (xs: List[T]): Boolean = reverse(xs) == xs

  // P07 - flatten a nested list structure
  def flatten(list: List[_]): List[_] = {
    def helper(remainder: Any, result: List[_]): List[_] =
      remainder match {
        case Nil => result
        case (head:List[_]) :: tail => helper(tail, result ++ flatten(head))
        case head :: tail => helper(tail, result :+ head)
      }
    helper(list, Nil)
  }

  // P08 - flatten a nested list structure
  def compress[T](list: List[T]): List[T] = {
    list.foldRight(List[T]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }
  }
}
