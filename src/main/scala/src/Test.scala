package src

import cat.AreaInstances.rectangleArea
import cat.Rectangle
import cat.ShapeAreaSyntax.ShapeAreaOps

import java.io.{FileNotFoundException, FileReader, IOException}

object Test {
  def main(args: Array[String]): Unit = {

    // cat
    println(s" cat: ${Rectangle(2, 3).areaOf}")


    //function
    function.time()
    function.printStrings("w3big", "Scala", "Python")
    function.higher()
    //
    collections()

    val height = 1f
    val name = "James"
    println(f"$name%s is $height%2.2f meters tall") //James is 1.90 meters tall
  }

  def collections(): Unit = {
    val array = Array(1, 2, 3)
    val list = List(1, 2, 3)
    println(2 +: list)
    println(list :+ 2)
    println(list.:+(2))
    println(list.::(6))
    println(list.:::(List(1, 4, 3)))


    try {
      val f = new FileReader("input.txt")
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception")
      }

      case ex: IOException => {
        println("IO Exception")
      }
    } finally {
      println("Exiting finally...")
    }
  }

  def matchTest(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case Person("Alice", 25) => println("Hi Alice!")
    case _ => "many"
  }

  case class Person(value: "Alice", value1: 25)
}
