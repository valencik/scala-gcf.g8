package $package$

import scala.scalajs.js
import scala.scalajs.js.annotation._

object $name;format="Camel"$ {

  @JSExportTopLevel("$name;format="camel"$")
  def function(req: js.Dynamic, res: js.Dynamic) = {
    val msg = "Hello from $name$!"
    res.send(msg)
  }

}
