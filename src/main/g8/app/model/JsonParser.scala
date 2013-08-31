package model

import net.liftweb.json.Serialization._

object JsonParser {
   implicit val formats = net.liftweb.json.DefaultFormats

  def recipeToJson(recipe: Recipe) = {
    write(recipe)
  }

}
