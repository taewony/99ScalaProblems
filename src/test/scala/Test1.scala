import org.junit.Test
import org.junit.Assert._

class Test1 {
  val x = List(1,2,3,4,5)

  @Test def t1(): Unit = {
    assertEquals(Main.P01(x), 5) //P01: Find the last element of a list 
  }

  @Test def t2(): Unit = {
    assertEquals(Main.P02(x), 4) //P02: Find the last but one element of a list 
  }


}
