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

  it("should parse a correct json into a Recipe object") {
    //Given
    val json = """{"descripcion":"receta","dificultad":"dificil","preparacion":"hacer la receta"}"""

    //When
    val parsedRecipe = JsonParser.jsonToRecipe(json)

    //Then
    parsedRecipe.asOpt.isDefined should be(true)
    parsedRecipe.get.descripcion should be("receta")
    parsedRecipe.get.dificultad should be("dificil")
    parsedRecipe.get.preparacion should be("hacer la receta")
  }

  it("should not parse an incorrect json into a Recipe object") {
    //Given
    val json = """{"field1":"blah","field2":"blah","field3":"blah"}"""

    //When
    val parsedRecipe = JsonParser.jsonToRecipe(json)

    //Then
    parsedRecipe.asOpt.isDefined should be(false)
  }

}
