package controllers

import play.api.mvc._
import repository.Repository
import model.JsonParser

object CookBookController extends Controller {

  def getReceta(descripcion: String) = Action {

    val receta = Repository.getRecipeByDescription(descripcion)

    receta match {
      case Some(receta) => Ok(JsonParser.recipeToJson(receta))
      case _ => NotFound
    }

  }

  def createReceta() = Action {

      Created
  }



}
