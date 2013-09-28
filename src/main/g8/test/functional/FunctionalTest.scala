package functional

import org.scalatest.{BeforeAndAfterEach, Tag, FeatureSpec}
import play.api.test.Helpers._
import play.api.test.{FakeRequest, FakeApplication}
import org.scalatest.matchers.ShouldMatchers
import play.api.mvc.Result
import repository.Repository
import model.Recipe

class FunctionalTest
  extends FeatureSpec
  with ShouldMatchers
  with BeforeAndAfterEach {

  val descripcion = "macarrones"
  val dificultad = "facil"
  val preparacion = "cocer los macarrones y echarles tomate"

  override def beforeEach() {
    Repository.clean()
  }

  feature("El usuario puede obtener una receta") {

    scenario("el nombre de la receta existe") {
      running(FakeApplication()) {
        //Given
        Repository.addRecipe(Recipe(descripcion, dificultad, preparacion))

        //When
        val response: Result = route(FakeRequest(GET, "/receta/macarrones")).get

        //Then
        status(response) should be(OK)
        contentAsString(response) should be("""{"descripcion":"macarrones","dificultad":"facil","preparacion":"cocer los macarrones y echarles tomate"}""")
      }
    }

    scenario("el nombre de la receta no existe") {
      running(FakeApplication()) {
        //When
        val response: Result = route(FakeRequest(GET, "/receta/fabada")).get

        //Then
        status(response) should be(NOT_FOUND)
      }
    }
  }

  feature("El usuario puede crear una receta") {

    scenario("el nombre de la receta no existe", Tag("wip")) {
      running(FakeApplication()) {
        //Given
        val body = """{"descripcion":"macarrones","dificultad":"facil","preparacion":"cocer los macarrones y echarles tomate"}"""

        //When
        val response: Result = route(FakeRequest(POST, "/receta").withBody(body)).get

        //Then
        status(response) should be(CREATED)
        thereShouldBeARecipeWithDescription(descripcion)
      }
    }

    scenario("el nombre de la receta no existe y el body de la peticion post no es correcto")  {
      running(FakeApplication()) {
        //Given
        val body = """{"descripcion":"macarrones","dificultad":"facil","incorrecto":"blah"}"""

        //When
        val response: Result = route(FakeRequest(POST, "/receta").withBody(body)).get

        //Then
        status(response) should be(BAD_REQUEST)
        thereShouldNotBeARecipeWithDescription(descripcion)
      }
    }

    scenario("el nombre de la receta existe")  (pending)

  }

  def thereShouldBeARecipeWithDescription(descripcion: String) = {
    val recipe = Repository.getRecipeByDescription(descripcion)
    recipe.isDefined should be(true)
  }

  def thereShouldNotBeARecipeWithDescription(descripcion: String) = {
    val recipe = Repository.getRecipeByDescription(descripcion)
    recipe.isDefined should be(false)
  }
}
