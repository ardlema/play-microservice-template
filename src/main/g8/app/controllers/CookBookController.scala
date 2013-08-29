package controllers

import play.api.mvc._

object CookBookController extends Controller {

  def getReceta(descripcion: String) = Action {

    val receta = {
    if (descripcion.equals("macarrones"))
      Some("""{"dificultad":"facil","precio":"bajo","receta":"cocer los macarrones y echarles tomate"}""")
    else
      None
    }

    //val receta = repository.getRecetaByDescripcion(descripcion)

    receta match {
      case Some(receta) => Ok(receta)
      case _ => NotFound
    }

  }



}
