package src

import java.util.Date
import scala.annotation.{tailrec, unused}

object function {

  def addInt(a: Int = 5, b: Int): Int = {
    var sum: Int = 0
    sum = a + b
    sum
  }

  def time(): Long = {
    println("获取时间，单位为纳秒")
    System.nanoTime
  }

  // call bt name
  def delayed(t: => Int): Unit = {
    println("In delayed method")
    println("Param: " + t)
  }

  delayed(addInt(1, 2))

  /**
   *
   * @param args : multiple string
   * @example : "a","b","c"
   */
  def printStrings(args: String*): Unit = {
    var i: Float = 0;
    for (arg <- args) {
      println(s"Arg value[ $i ] = $arg" + arg);
      //println(f"Arg value[ $i %2.2f ] = $arg" + arg);
      i = i + 1;
    }
  }

  // Higher-order functions

  def apply(f: Int => String, v: Int): String = f(v)

  def layout[A](x: A): String = "[" + x.toString + "]"

  var mul: (Int, Int) => Int = (x: Int, y: Int) => x * y

  def higher(): Unit = {
    apply(v = 10, f = layout)
    addInt(b = 2, a = 1)
  }

  //nested
  def factorial(i: Int): Int = {
    @tailrec
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }

    fact(i, 1)
  }

  //anonymous functions
  var inc: Int => Int = (x: Int) => x + 1
  var userDir: () => String = () => {
    System.getProperty("user.dir")
  }
  var x: Int = inc(7) - 1

  // ~
  def add2: Int => Int = (x: Int) => x + 1

  //partial function
  def partial(): Unit = {
    val date = new Date
    //gán 1 đối số mặc định (thuộc đối tượng)
    val logWithDateBound = log(date, _: String)
    logWithDateBound("message1")
    Thread.sleep(1000)
    logWithDateBound("message2")
    Thread.sleep(1000)
    logWithDateBound("message3")
  }

  def log(date: Date, message: String): Unit = {
    println(date + "----" + message)


  }

  //Currying :gọi hàm nhiều đối số  được thay thế bằng nhiều lệnh gọi phương thức với các đối số nhỏ hơn
  def add1(x: Int)(y: Int): Int = x + y

  //~
  def add2(x: Int): Int => Int = (y: Int) => x + y



  //closure : dependence outside variable
  var factor = 3
  val multiplier: Int => Int = (i: Int) => i * factor
}
