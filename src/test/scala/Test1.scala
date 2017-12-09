import org.junit.Test
import org.junit.Assert._

class Test1 {
  val x = List(1,2,3,4,5)

  @Test def t1(): Unit = {
    assertEquals(Main.last(x), 5) //P01: Find the last element of a list 
  }

  @Test def t2(): Unit = {
    assertEquals(Main.penultimate(x), 4) //P02: Find the last but one element of a list 
  }

  @Test def t3(): Unit = {
    assertEquals(Main.nth(2, x), 3) //P03: Find the Kth element of a list.
  }

  @Test def t4(): Unit = {
    assertEquals(Main.length(x), 5) //P04: Find the number of elements of a list.
  }

  @Test def t5(): Unit = {
    assertEquals(Main.reverse(x), List(5,4,3,2,1))
  }

  @Test def t6(): Unit = {
    assertEquals(Main.isPalindrome(List(1,2,3,2,1)), true)
    assertEquals(Main.isPalindrome(List(1,2,2,1)), true)
  }

  @Test def t7(): Unit = {
    assertEquals(Main.flatten(List(List(1, 1), 2, List(3, List(5, 8)))), List(1, 1, 2, 3, 5, 8))
  }
}
