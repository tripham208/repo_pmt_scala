package src.sangia

import sangria.schema._
import sangria.execution._
import sangria.macros._

import scala.concurrent.ExecutionContext.Implicits.global

object A {
  def main(args: Array[String]): Unit = {
    val QueryType = ObjectType("Query", fields[Unit, Unit](
      Field("hello", StringType, resolve = _ ⇒ "Hello world!")
    ))

    val schema = Schema(QueryType)

    val query = graphql"{ hello }"

    Executor.execute(schema, query) map println
    val x = if (true) "no" else "ok"
  }
}

