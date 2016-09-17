package models

import anorm._
import play.api.db._
import play.api.Play.current

case class Login(email: String, password: String)

object Login {

    def get(email: String) = {
        DB.withConnection { implicit connection =>
            SQL("SELECT first_name, last_name, email_address, passwd FROM UserTable WHERE email_address={email}").on ("email" -> email)().headOption.map { row =>
                Login(
                    email = row[String]("email_address"),
                    password = row[String]("passwd")
                )
            }
        }
    }

    def verify(login: Login) = {
        Login.get(login.email).map {loggedin =>{
            println("verifying" + loggedin.email)
            if(loggedin.password != login.password)
                "email and password do not match!"
                else {
                "login successful"
                }
            }
        } getOrElse "email not found!"    
    }
    import play.api.data._
    import play.api.data.Forms._

    val form = Form(
        mapping(
          "email" -> email,
          "password" -> text(minLength = 6, maxLength = 30)
        )(Login.apply)(Login.unapply)
    )
}