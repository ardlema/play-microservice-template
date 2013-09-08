package model

import play.api.libs.json.Json

object JsonParser {
  implicit val recipeFormat = Json.format[Recipe]

  def recipeToJson(recipe: Recipe) = {
    val jsonRecipe = Json.toJson(recipe)
    Json.stringify(jsonRecipe)
  }

  def jsonToRecipe(json: String) = {
    val parsedJson = Json.parse(json)
    Json.fromJson[Recipe](parsedJson).get
  }

}
