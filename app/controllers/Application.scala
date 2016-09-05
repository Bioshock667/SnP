package controllers

import play.api.mvc._
import models.Company

object Application extends Controller {

  def index = Action {
      val companies = Company.all
    Ok(views.html.main(companies, Company.form))
  }

  def create = Action { implicit request =>

    Company.form.bindFromRequest.fold(
      errors => BadRequest(views.html.main(Company.all, errors)),
      company => {
        Company.create(company)
        Redirect(routes.Application.index())
      }
    )
  }
  def edit(id: String) = Action {
      Company.get(id).map { company =>
          Ok(views.html.edit(id, Company.form.fill(company)))
      } getOrElse {
          Redirect(routes.Application.index())
      }
  }
  def update(id: String) = Action { implicit request =>
      Company.form.bindFromRequest.fold(
          errors => BadRequest(views.html.edit(id, errors)),
          company => {
              Company.update(id, company)
              Redirect(routes.Application.index())
          }
        )
  }
  def delete(id:String) = Action {
      
      Company.delete(id)
      Redirect(routes.Application.index())
  }

}
