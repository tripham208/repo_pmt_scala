package src.cat

import src.cat.AreaInstances.rectangleArea
import src.cat.ShapeAreaSyntax.ShapeAreaOps

trait Area[A] {
  def area(a: A): Double
}
case class Rectangle(width: Double, length: Double)
case class Circle(radius: Double)

object AreaInstances {
  implicit val rectangleArea: Area[Rectangle] = (a: Rectangle) => a.width * a.length

  implicit val circleArea: Area[Circle] = (a: Circle) => Math.PI * (a.radius * a.radius)
}

object ShapeArea {
  def areaOf[A](a: A)(implicit shape: Area[A]): Double = shape.area(a)
}

object ShapeAreaSyntax {
  implicit class ShapeAreaOps[A](a: A) {
    def areaOf(implicit shape: Area[A]): Double = shape.area(a)
  }
}


object  test{
  val  rectangle: Rectangle = Rectangle(1,2)
  val d: Double = ShapeArea.areaOf(rectangle)(rectangleArea)
  Rectangle(2, 3).areaOf(rectangleArea)
}
