package models

import anorm._
import play.api.db._
import play.api.Play.current

case class Login(email: String, password: String)

object Login {
    
    import play.api.data._
    import play.api.data.Forms._

    val form = Form(
        mapping(
          "email" -> email,
          "password" -> text(minLength = 6, maxLength = 30)
        )(Login.apply)(Login.unapply)
    )
}