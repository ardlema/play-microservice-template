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

  def createReceta() = Action { request =>
     val body = request.body
    val textBody: Option[String] = body.asText

    textBody.map { text =>
      val recipe = JsonParser.jsonToRecipe(text)
      Repository.addRecipe(recipe)
      Created("Recipe created OK")
    }.getOrElse {
      BadRequest("Expecting text/plain request body")
    }
  }



}
