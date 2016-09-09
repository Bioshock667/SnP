package controllers

import play.api.mvc._
import play.api.mvc.RequestHeader
import models.Company
import models.Login

object Application extends Controller {

  def index = Action { request =>
      request.session.get("connected").map { user =>
        println("Welcome" + user)
        val companies = Company.all
        Ok(views.html.main(companies, Company.form))
        }.getOrElse {
          Redirect(routes.Application.login)
      }
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
  
  def login = Action {
      //println("loging in")
      Ok(views.html.login(Login.form, ""))
  }
  
  def authenticate = Action { implicit request =>
      Login.form.bindFromRequest.fold(
        errors =>  {println("login failed")
                    BadRequest(views.html.login(errors, ""))},
        login => {
          //session().clear()
          println("login successful")
          Redirect(routes.Application.index()).withSession("connected"->login.email)
          //session("connected"-> loginForm.get().email)
          //Redirect(routes.Application.index())
      }
     )
  }
  
  def logout = Action { Redirect(routes.Application.login()).withNewSession }
}
