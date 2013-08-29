package functional

import org.scalatest.FeatureSpec
import play.api.test.Helpers._
import play.api.test.{FakeRequest, FakeApplication}
import org.scalatest.matchers.ShouldMatchers
import play.api.mvc.Result

class FunctionalTest
  extends FeatureSpec
  with ShouldMatchers {

  feature("El usuario puede obtener una receta") {

    scenario("el nombre de la receta existe") {
      running(FakeApplication()) {
        val response: Result = route(FakeRequest(GET, "/receta/macarrones")).get

        status(response) should be(OK)
        contentAsString(response) should be("""{"dificultad":"facil","precio":"bajo","receta":"cocer los macarrones y echarles tomate"}""")
      }
    }

    scenario("el nombre de la receta no existe") {
      running(FakeApplication()) {
        val response: Result = route(FakeRequest(GET, "/receta/fabada")).get

        status(response) should be(NOT_FOUND)
      }
    }
  }
}
