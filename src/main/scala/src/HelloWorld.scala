package src

import scala.util.control.Breaks
import scala.util.control.Breaks.break

object HelloWorld {
  var a: Int = 5
  val b = 5.5
  val string = "ad"
  // val (myVar1: Int, myVar2: String) = Pair(40, "Foo")

  def f(): Unit = {
    println("f")
  }

  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    a = 6
    println(a + b)

    val numList1 = List(1, 2, 3, 4, 12, 5)

    val x = a
    if (x == 10) println("X 的值为 10")
    else if (x == 20) println("X 的值为 20")
    else if (x == 30) println("X 的值为 30")
    else println("无法判断 X 的值")

    val outer = new Breaks;
    val inner = new Breaks;

    outer.breakable {
      for (a <- numList1) {
        println("Value of a: " + a);

        inner.breakable {
          for (b <- numList1) {
            println("Value of b: " + b);

            if (b == 12) {
              inner.break;
            }
          }
        } // inner breakable
      }
    } // outer breakable.
    for (a <- 1 to 10 by 3) {
      println("Value of a: " + a)
      for (b <- 1 to 10 by 3) {
        println("Value of b: " + b)
        break
      }
      break
    }

    var retVal = for {a <- numList1 if a != 3; if a < 8} yield a

    for (a <- numList1) {
      println("Value of a: " + a);
    }
    for (a <- numList1 if a != 3; if a < 8) {
      println("Value of a: " + a);
    }

    var point = new Point(1, 2)

  }
}

class Point(var xc: Int, var yc: Int) {
  def this(xc: Int) {
    this(xc, 2)
  }

  def this() {
    this(2)
    this.yc = 2
  }
}

//companion obj
object Point {
  val c = "d"


}

class Book(var title: String, var ISBN: Int) {

  def this(title: String) {
    this(title, 1111)
  }

  def this() {
    this("Begining Scala")
    this.ISBN = 2222
  }
}


