package unit

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import model.{JsonParser, Recipe}

class JsonParserTest
  extends FunSpec
  with ShouldMatchers {

  val recipe = Recipe("receta", "dificil", "hacer la receta")

  it("should parse a Recipe object into a json") {
    //Given
    val expectedJson = """{"descripcion":"receta","dificultad":"dificil","preparacion":"hacer la receta"}"""

    //When
    val parsedJson = JsonParser.recipeToJson(recipe)

    //Then
    parsedJson should be(expectedJson)
  }

  it("should parse a json into a Recipe object") {
    //Given
    val json = """{"descripcion":"receta","dificultad":"dificil","preparacion":"hacer la receta"}"""

    //When
    val parsedRecipe = JsonParser.jsonToRecipe(json)

    //Then
    parsedRecipe.descripcion should be("receta")
    parsedRecipe.dificultad should be("dificil")
    parsedRecipe.preparacion should be("hacer la receta")
  }

}
