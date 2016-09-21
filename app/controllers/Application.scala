package controllers

import play.api.mvc._
import play.api.mvc.RequestHeader
import play.api.Play.current
import models._
import models.Login

/**
  * copied and pasted from https://www.playframework.com/documentation/2.0.4/ScalaSecurity.
  * added 9/15/16
  * This provides an interface for the play Security controller to authenticate HTTP requests.
  * When incorperated into a function it checks the username in the request header
  */
trait Secured {

  def username(request: RequestHeader) = {
    /*
    val previousTick: String = request.session.get("session_time").getOrElse("")
    val previousT: Long = previousTick.toLong
      val currentT: Long = System.currentTimeMillis()
      val time: String = current.configuration.getString("sessionTimeout").getOrElse("")
      val timeout: Long = time.toLong * 1000 * 60
      if((currentT - previousT) > timeout) {
        Results.Redirect(routes.Application.login()).withNewSession
      }
      val tickString: String = System.currentTimeMillis().toString
      request.session("session_time" -> System.currentTimeMillis().toString)*/
    request.session.get(Security.username)
  }

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
    val leader_id = request.session.get("User_ID").getOrElse("0").toInt
    val email = username
    val users = User.all(leader_id)
    User.getUser(email).map { curUser=>
      Ok(views.html.main(curUser, users)
      )
    }getOrElse{
      println("getUser failed to get User " + email)
      Redirect(routes.Application.index())
    }
  }
  /**
    * This function is called after a user clicks "create" in the main webpage.(POST /)
    * It uses bindFromRequest and fold to bind request data.  fold takes two functions
    * The first is for when the binding results in an error while the second is when the
    * binding is successful
    * @return badrequest if bad data
    */

  def newUser = Action { implicit request =>
    User.form.bindFromRequest.fold(
      errors => {println("new user failed binding request data")
      BadRequest(views.html.signup(errors))},
      user => {
        val leader_id = request.session.get("User_ID")
        val leader_id_int: Int = leader_id.getOrElse("0").toInt
        var leader_opt: Option[Int] = None
        if(leader_id_int != 0)
          leader_opt = Some(leader_id_int)
        User.newUser(user, leader_opt)
        Redirect(routes.Application.index())
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
  /*
  def edit(id: String) = isAuthenticated { username => implicit request =>
      Company.get(id).map { company =>
          Ok(views.html.edit(id, Company.form.fill(company)))
      } getOrElse {
          Results.Redirect(routes.Application.index())
      }
  }
*/
  def editUser(id: Int) = TODO
  /**
    * This function is called after a user clicks "update company" in the edit webpage (POST /update)
    * It binds the POST request data to a form.  If failed, return to the edit page.  If, successful
    * call on the update function in the Company object then redirect to the main webpage
    * @param id
    */
  /*
  def update(id: String) = Action { implicit request =>
      Company.form.bindFromRequest.fold(
          errors => BadRequest(views.html.edit(id, errors)),
          company => {
              Company.update(id, company)
              Redirect(routes.Application.index())
          }
        )
  }
*/
  def updateUser(id: Int) = TODO
  /**
    * This function is called after a user clicks "delete" in the main webpage (GET /delete)
    * It calls the delete function in company object then returns to main webpage
    * @param id the id of the company to be deleted
    * @return
    */
  /*
  def delete(id:String) = isAuthenticated {username => implicit request =>
      Company.delete(id)
      Redirect(routes.Application.index())
  }
*/
  def deleteUser(id: Int) = TODO
  /**
    * This function is called after the index function reads that the user is not signed in
    * @return
    */
  def login = Action {
      //println("loging in")
      Ok(views.html.login(Login.form, ""))
  }

  /**
    * This function checks if the request data is valid.  Then it calls the getUser to get user data
    * to save into the session cookie.
    * @return If its not, the user is sent to  the login page.
    *         If successful, the user is sent to the index page as signed-in.
    */
  def authenticate = Action { implicit request =>
        Login.form.bindFromRequest.fold(
        errors =>  {println("login failed")
                    BadRequest(views.html.login(errors, ""))},
        login => {
          //session().clear()
            println("login successful")
            val logstat: String = Login.verify(login)
            if(logstat == "login successful") {
              User.getUser(login.email).map { curUser=>
                Redirect(routes.Application.index()).withSession(
                  Security.username -> login.email,
                  "User_ID" -> curUser.id.toString,
                  "User_First_Name" -> curUser.first_name,
                  "User_Last_Name" -> curUser.last_name
                  //"Session_Time" -> System.currentTimeMillis().toString
                )
              }getOrElse{Redirect(routes.Application.index())}
            }else
                BadRequest(views.html.login(Login.form.fill(login), logstat))
          //session("connected"-> loginForm.get().email)
          //Redirect(routes.Application.index())
      }
     )
  }
  //This function logs the user out by clearing the session data
  def logout = Action { Redirect(routes.Application.login()).withNewSession }

  //This function sends the user to the signup page
  def signUp = Action {Ok(views.html.signup(User.form))}

  /**
    * This function binds a User form from request data.  Once the data is considered good
    * it gets the user_id and pass it and the form to the newUser function
    * @return if bad data, redirect to signup page
    *         if good data, return to the main page
    */


}
