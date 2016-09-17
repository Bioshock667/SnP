package models

import anorm._
import play.api.db.DB
import play.api.Play.current

/**
	* Created by seth on 9/16/16.
	*/
case class User (
	first_name: String,
	last_name: String,
	email_address: String,
  password: String,
  company: String,
  mailing_address: String,
  occupation: String,
  birthdate: String,
  leader_id: Int
                )

object User {
  def newUser(user: User) = {
    DB.withConnection{ implicit connection =>
      SQL(
        """
          INSERT INTO UserTable (first_name, last_name, email_address, passwd, )
          VALUES ({first_name}, {last_name}, {email_address}, {password});
        """
      ).on(
        "first_name" -> user.first_name,
        "last_name" -> user.last_name,
        "email_address" -> user.email_address,
        "password" -> user.password
      ).execute()
    }
  }
}
