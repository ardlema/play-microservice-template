package repository

import model.Recipe

object Repository {

  var repository: List[Recipe] = List.empty

  def clean() {
    repository = List.empty
  }

  def addRecipe(recipe: Recipe) {
    repository ::= recipe
  }

  def getRecipeByDescription(description: String) = {
    repository.find(recipe => recipe.descripcion.equals(description))
  }

}
