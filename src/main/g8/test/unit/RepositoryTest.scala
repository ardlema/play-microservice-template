package unit

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import repository.Repository
import model.Recipe

class RepositoryTest
  extends FunSpec
  with ShouldMatchers {

  val descripcion = "macarrones"
  val dificultad = "facil"
  val preparacion = "cocer los macarrones y echarles tomate"

  it("should get a recipe by description") {
    //Given
    Repository.addRecipe(Recipe(descripcion, dificultad, preparacion))

    //When
    val recipe = Repository.getRecipeByDescription(descripcion).get

    //Then
    recipe.dificultad should be(dificultad)
    recipe.preparacion should be(preparacion)
  }

}
