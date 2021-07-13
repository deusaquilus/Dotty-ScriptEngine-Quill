package io.getquill

case class Person(name: String, age: Int)

object Example {

  def main(args: Array[String]): Unit = {
    val m = new javax.script.ScriptEngineManager(getClass().getClassLoader())
    val e = m.getEngineByName("scala")
    println(e.eval(
      """
      import io.getquill._
      val ctx = new SqlMirrorContext(PostgresDialect, Literal)
      import ctx._
      inline def q = quote { query[Person] }
      val result = run(q).string
      s"Output: $result"
      """
    ).asInstanceOf[String])
  }
}
