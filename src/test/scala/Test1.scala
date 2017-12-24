import org.junit.Test
import org.junit.Assert._

class Test1 {
  import Main._

  val x = List(1,6,4,3,5,2)

  @Test def t0(): Unit = {
    assertEquals(List(1,2,3,4,5,6), insertionSort(x))
  }

  @Test def t1(): Unit = {
    assertEquals(2, last(x)) //P01: Find the last element of a list 
  }

  @Test def t2(): Unit = {
    assertEquals(5, penultimate(x)) //P02: Find the last but one element of a list 
  }

  @Test def t3(): Unit = {
    assertEquals(4, nth(2, x)) //P03: Find the Kth element of a list.
  }

  @Test def t4(): Unit = {
    assertEquals(6, length(x)) //P04: Find the number of elements of a list.
  }

  @Test def t5(): Unit = {
    assertEquals(List(2, 5, 3, 4, 6, 1), reverse(x))
  }

  @Test def t6(): Unit = {
    assertEquals(isPalindrome(List(1,2,3,2,1)), true)
    assertEquals(isPalindrome(List(1,2,2,1)), true)
  }

  @Test def t7(): Unit = {
    assertEquals(flatten(List(List(1, 1), 2, List(3, List(5, 8)))), List(1, 1, 2, 3, 5, 8))
  }

  @Test def t8(): Unit = {
    assertEquals(List('a, 'b, 'c, 'a, 'd, 'e), 
      compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    )
  }

  @Test def t9(): Unit = {
    assertEquals(
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)),
      pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    )
  }

  @Test def t10(): Unit = {
    assertEquals(
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)),
      encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    )
  }

  @Test def t11(): Unit = {
    assertEquals(
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)),
      encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    )
  }

  @Test def t12(): Unit = {
    assertEquals(
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e),
      decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
    )
  }

  @Test def t13(): Unit = {
    assertEquals(
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)),
      encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    )
  }

  @Test def t99(): Unit = {
    assertEquals(2, numAdd(1,1))
  }
}
