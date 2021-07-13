# Using Dotty ScriptEngine with Quill

In Scala 2, if we wanted to be able to compile some Scala code from a string inside of a JVM we had to use the ToolBox Compiler. Scala 3 implements a Java-Spec (jsr-223) ScriptEngine which lets you do that really, really easily. You can even get the return-value from the execution!

```scala
val m = new javax.script.ScriptEngineManager(getClass().getClassLoader())
val e = m.getEngineByName("scala")
// Execute a string inside the engine
println(e.eval("42"))
// You can get a strongly-typed return value too!
println(e.eval("Some(42)").asInstanceOf[Option[Int]].get)
```

You can even run macros inside the script engine too, including the entire of ProtoQuill:

```scala
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
```

This micro-example demonstrates that.
