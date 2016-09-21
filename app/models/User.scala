package models

import anorm._
import play.api.db.DB
import play.api.Play.current
import java.util.Date
/**
	* Created by seth on 9/16/16.
	*/
case class User (
  id: Int,
  first_name: String,
	last_name: String,
	email_address: String,
  password: String,
  company: String,
  occupation: String,
  mailing_address: Option[String],
  birth_date: Option[Date],
  leader_id: Option[Int]
                )

object User {

  /**
    * This function will retrieve a list of users from the database
    * Note: null values should not be passed here
    * @param manager_id the manager_id to search the users by
    * @return a list of user objects
    */
  def all(manager_id: Int) = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM UserTable WHERE manager_id={MID}").on("MID" -> manager_id)().map { row =>
        User(
          id = row[Int]("user_id"),
          first_name = row[String]("first_name"),
          last_name = row[String]("last_name"),
          email_address = row[String]("email_address"),
          password = "",
          company = row[String]("company"),
          occupation = row[String]("occupation"),
          mailing_address = row[Option[String]]("mailing_address"),
          birth_date = row[Option[Date]]("birth_date"),
          leader_id = row[Option[Int]]("manager_id")
        )
      }.toList
    }
  }

  /**
    * This function connects to the MySQL database to insert a new User entry.
    * @param user a user object holding all relevant user data except manager_id
    * @param leader_id an optional integer obtained from the user_id stored in the session cookie
    *                  Note: The play app automatically assigns the current user as the manager
    *                  of the new user to be added.  Future implementation would likely allow the user
    *                  to chose a different manager, but for now groups are based on one manager for
    *                  security reasons.
    * @return
    */
  def newUser(user: User, leader_id: Option[Int]) = {
    DB.withConnection{ implicit connection =>
      SQL(
        """
          INSERT INTO UserTable (first_name, last_name, email_address, passwd, company, occupation, mailing_address, birth_date, manager_id)
          VALUES ({first_name}, {last_name}, {email_address}, {password}, {company}, {occupation}, {mailing_address}, {birth_date}, {manager_id});
        """
      ).on(
        "first_name" -> user.first_name,
        "last_name" -> user.last_name,
        "email_address" -> user.email_address,
        "password" -> user.password,
        "company" -> user.company,
        "occupation" -> user.occupation,
        "mailing_address" -> user.mailing_address,
        "birth_date" -> user.birth_date,
        "manager_id" -> leader_id
      ).execute()
    }
  }

  /**
    * This function retrieves the specified user from the MySQL database
    * @param email the email address string to search the user by
    * @return a User optional object
    */
  def getUser(email: String) = {
    DB.withConnection{ implicit connection =>
      SQL("SELECT * FROM UserTable WHERE email_address={email}").on("email" -> email)().headOption.map { row =>
        User(
          id = row[Int]("user_id"),
          first_name = row[String]("first_name"),
          last_name = row[String]("last_name"),
          email_address = row[String]("email_address"),
          password = "",
          company = row[String]("company"),
          occupation = row[String]("occupation"),
          mailing_address = row[Option[String]]("mailing_address"),
          birth_date = row[Option[Date]]("birth_date"),
          leader_id = row[Option[Int]]("manager_id")
        )
      }
    }
  }

  import play.api.data._
  import play.api.data.Forms._

  val form = Form(
    mapping(
      "id" -> default(number, 0),
      "first_name" -> text,
      "last_name" -> text,
      "email_address" -> email,
      "password" -> text,
      "company" -> text,
      "occupation" -> text,
      "mailing_address" -> optional(text),
      "birth_date" -> optional(date("yyyy-MM-dd")),
      "manager_id" -> optional(number)
    )(User.apply)(User.unapply)
  )
}
