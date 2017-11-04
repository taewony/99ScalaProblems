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

}
