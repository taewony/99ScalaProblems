object Main {

  def main(args: Array[String]): Unit = {
    println("please run -> sbt test")
  }

  // add two numbers
  def numAdd(a: Int, b:Int) = a + b

  // P00 - insertion sort
  def insertionSort(list: List[Int]): List[Int] = {
    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => List(x)
      case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
    }

    list match {
      case List() => List()
      case y :: ys => insert(y, insertionSort(ys))
    }
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

  // P09 - Pack consecutive duplicates of list elements into sublists.
  def pack[T](list: List[T]): List[List[T]] = {
    if (list.isEmpty) List(List())
    else {
      val (packed, next) = list span { _ == list.head }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  // P10 - Run-length encoding of a list.
  def encode[T](list: List[T]): List[(Int, T)] = {
    if (list.isEmpty) List()
    else {
      val (packed, next) = list span { _ == list.head }
      if (next == Nil) List((packed.size, packed.head))
      else (packed.size, packed.head) :: encode(next)
    }
  }

  // P11 - Modified run-length encoding.
  def encodeModified[T](list: List[T]): List[Any] = {
    if (list.isEmpty) List()
    else {
      val (packed, next) = list span { _ == list.head }
      val e = if (packed.size == 1) packed.head else (packed.size, packed.head)
      if (next == Nil) List(e)
      else e :: encodeModified(next)
    }
  }

  // P12 - Decode a run-length encoded list.
  def decode[T](list: List[(Int, T)]): List[T] = {
    list.flatMap { e => List.fill(e._1)(e._2)}
  }

  // P13 - Run-length encoding of a list.
  def encodeDirect[T](list: List[T]): List[(Int, T)] = {
    if (list.isEmpty) List()
    else {
      val (packed, next) = list span { _ == list.head }
      (packed.size, packed.head) :: encodeDirect(next)
    }
  }

  // P14 - Duplicate the elements of a list.
  def duplicate[T](list: List[T]): List[T] =
    list flatMap { e => List(e, e) }

  // P15 - Duplicate the elements of a list a given number of times.
  def duplicateN[T](n: Int, list: List[T]): List[T] =
    list flatMap { e => List.fill(n)(e) }

  // P16 - Drop every Nth element from a list.
  def drop[T](n: Int, list: List[T]): List[T] =
    list.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map { _._1 }

  // P17 - Split a list into two parts.
  def split[T](n: Int, list: List[T]): (List[T], List[T]) = {
    (list.take(n), list.drop(n))
  }

  // P18 - Extract a slice from a list.
  def slice[T](n: Int, k: Int, list: List[T]): List[T] = {
    list.drop(n).take(k-n)
  }

}
