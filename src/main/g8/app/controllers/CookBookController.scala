package controllers

import play.api.mvc._

object CookBookController extends Controller {

  def getReceta(descripcion: String) = Action {
    Ok("""{"dificultad":"facil","precio":"bajo","receta":"cocer los macarrones y echarles tomate"}""")
  }

}
