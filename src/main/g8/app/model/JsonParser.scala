package model

import play.api.libs.json.{JsResult, Json}

object JsonParser {
  implicit val recipeFormat = Json.format[Recipe]

  def recipeToJson(recipe: Recipe) = {
    val jsonRecipe = Json.toJson(recipe)
    Json.stringify(jsonRecipe)
  }

  def jsonToRecipe(json: String): JsResult[Recipe] = {
    val parsedJson = Json.parse(json)
    Json.fromJson[Recipe](parsedJson)
  }

}
