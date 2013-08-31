package unit

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import model.{JsonParser, Recipe}

class JsonParserTest
  extends FunSpec
  with ShouldMatchers {

  it("should parse a Recipe object into a json") {
    //Given
    val recipe = Recipe("receta", "dificil", "hacer la receta")
    val expectedJson = """{"descripcion":"receta","dificultad":"dificil","preparacion":"hacer la receta"}"""

    //When
    val parsedJson = JsonParser.recipeToJson(recipe)

    //Then
    parsedJson should be(expectedJson)
  }

}
