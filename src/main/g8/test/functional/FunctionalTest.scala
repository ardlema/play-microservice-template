package functional

import org.scalatest.FeatureSpec
import play.api.test.Helpers._
import play.api.test.{FakeRequest, FakeApplication}
import org.scalatest.matchers.ShouldMatchers

class FunctionalTest
  extends FeatureSpec
  with ShouldMatchers {

  feature("El usuario puede obtener una receta") {

    scenario("el nombre de la receta existe") {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get

        status(home) should be(OK)
      }
    }

    scenario("el nombre de la receta no existe") (pending)
  }
}
