package controllers

import play.api.mvc._
import play.api.mvc.RequestHeader
import models.Company
import models.Login

/**
  * copied and pasted from https://www.playframework.com/documentation/2.0.4/ScalaSecurity.
  * added 9/15/16
  * This provides an interface for the play Security controller to authenticate HTTP requests.
  * When incorperated into a function it checks the username in the request header
  */
trait Secured {

  def username(request: RequestHeader) = request.session.get(Security.username)

  def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Application.login)

  def isAuthenticated(f: => String => Request[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) { login =>
      Action(request => f(login)(request))
    }
  }
}

object Application extends Controller with Secured {
/**
  * This function takes the user to the main webpage
  * Its called when
 */
  def index = isAuthenticated { username => implicit request =>
    val companies = Company.all
    Ok(views.html.main(companies, Company.form))
  }
  /**
    * This function is called after a user clicks "create" in the main webpage.(POST /)
    * It uses bindFromRequest and fold to bind request data.  fold takes two functions
    * The first is for when the binding results in an error while the second is when the
    * binding is successful
    * @return badrequest if bad data
    */
  def create = Action { implicit request =>

    Company.form.bindFromRequest.fold(
      errors => BadRequest(views.html.main(Company.all, errors)),
      company => {
        Company.create(company)
        Results.Redirect(routes.Application.index())
      }
    )
  }

  /**
    * THis function is called after a user clicks "edit" in the main webpage (GET /edit)
    * It calls on the get function from the Company object and maps the result "company" to
    * an Ok response; passing a form filled with the contents of "company"
    * @param id the id is of the company to be edited
    * @return
    */
  def edit(id: String) = isAuthenticated { username => implicit request =>
      Company.get(id).map { company =>
          Ok(views.html.edit(id, Company.form.fill(company)))
      } getOrElse {
          Results.Redirect(routes.Application.index())
      }
  }

  /**
    * This function is called after a user clicks "update company" in the edit webpage (POST /update)
    * It binds the POST request data to a form.  If failed, return to the edit page.  If, successful
    * call on the update function in the Company object then redirect to the main webpage
    * @param id
    */
  def update(id: String) = Action { implicit request =>
      Company.form.bindFromRequest.fold(
          errors => BadRequest(views.html.edit(id, errors)),
          company => {
              Company.update(id, company)
              Redirect(routes.Application.index())
          }
        )
  }

  /**
    * This function is called after a user clicks "delete" in the main webpage (GET /delete)
    * It calls the delete function in company object then returns to main webpage
    * @param id the id of the company to be deleted
    * @return
    */
  def delete(id:String) = isAuthenticated {username => implicit request =>
      Company.delete(id)
      Redirect(routes.Application.index())
  }

  /**
    * This function is called after the index function reads that the user is not signed in
    * @return
    */
  def login = Action {
      //println("loging in")
      Ok(views.html.login(Login.form, ""))
  }

  /**
    * This function checks if the request data is valid.  If its not, the user is sent to
    *  the login page.  IF successful, the user is sent to the index page as signed-in.
    * @return
    */
  def authenticate = Action { implicit request =>
        Login.form.bindFromRequest.fold(
        errors =>  {println("login failed")
                    BadRequest(views.html.login(errors, ""))},
        login => {
          //session().clear()
            println("login successful")
            val logstat: String = Login.verify(login)
            if(logstat == "login successful")
                Redirect(routes.Application.index()).withSession(
                    Security.username->login.email
                )
            else
                BadRequest(views.html.login(Login.form.fill(login), logstat))
          //session("connected"-> loginForm.get().email)
          //Redirect(routes.Application.index())
      }
     )
  }
  //This function logs the user out by clearing the session data
  def logout = Action { Redirect(routes.Application.login()).withNewSession }

  def signup = TODO

  def newUser = TODO
}
