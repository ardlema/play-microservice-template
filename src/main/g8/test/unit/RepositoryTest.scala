package unit

import org.scalatest.{BeforeAndAfterEach, FunSpec}
import org.scalatest.matchers.ShouldMatchers
import repository.Repository
import model.Recipe

class RepositoryTest
  extends FunSpec
  with ShouldMatchers
  with BeforeAndAfterEach {

  val descripcion = "macarrones"
  val dificultad = "facil"
  val preparacion = "cocer los macarrones y echarles tomate"

  override def beforeEach() {
    Repository.clean()
  }

  it("should add a recipe") {
    //Given
    Repository.addRecipe(Recipe(descripcion, dificultad, preparacion))

    //Then
    Repository.repository.size should be(1)
  }

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
