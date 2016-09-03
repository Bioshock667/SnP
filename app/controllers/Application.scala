package controllers

import play.api.mvc._
import models.Company

object Application extends Controller {

  def index = Action {
      val companies = Company.all
    Ok(views.html.main(companies))
  }

  def create = TODO
  def edit(id: String) = TODO
  def update(id: String) = TODO
  def delete(id:String) = TODO

}
