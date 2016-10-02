package models

import utils.silhouette.IdentitySilhouette
import com.mohiva.play.silhouette.password.BCryptPasswordHasher
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import anorm._
import play.api.Play.current
import java.util.Date
import play.api.db.DB

case class User(
    id: Int,
    email: String,
    emailConfirmed: Boolean,
    password: String,
    nick: String,
    first_name: String,
    last_name: String,
    company: Option[String],
    occupation: Option[String],
    mailing_address: Option[String],
    birth_date: Option[Date],
    manager_id: Option[Int],
    /*
	* A user can register some accounts from third-party services, then it will have access to different parts of the webpage. The 'master' privilege has full access.
	* Ex: ("master") -> full access to every point of the webpage.
	* Ex: ("serviceA") -> have access only to general and serviceA areas.
	* Ex: ("serviceA", "serviceB") -> have access only to general, serviceA and serviceB areas.
	*/
    services: List[String]
) extends IdentitySilhouette {
  def key = email
  def fullName: String = first_name + " " + last_name
}

object User {

  val services = Seq("serviceA", "serviceB", "serviceC")
  /*
  val users = scala.collection.mutable.HashMap[Long, User](
    1L -> User(Some(1L), "master@myweb.com", true, (new BCryptPasswordHasher()).hash("123123").password, "Eddy", "Eddard", "Stark", List("master")),
    2L -> User(Some(2L), "a@myweb.com", true, (new BCryptPasswordHasher()).hash("123123").password, "Maggy", "Margaery", "Tyrell", List("serviceA")),
    3L -> User(Some(3L), "b@myweb.com", true, (new BCryptPasswordHasher()).hash("123123").password, "Petyr", "Petyr", "Baelish", List("serviceB")),
    4L -> User(Some(4L), "a_b@myweb.com", true, (new BCryptPasswordHasher()).hash("123123").password, "Tyry", "Tyrion", "Lannister", List("serviceA", "serviceB"))
  )
*/
  def getService(service: String): List[String] = service.split(", ").toList

  def putService(service: Seq[String]): String = service.mkString(", ")

  /**
   * This function will retrieve a list of users from the database
   * Note: null values should not be passed here
   * @param manager_id the manager_id to search the users by
   * @return a list of user objects
   */
  def all = {
    DB.withConnection { implicit connection =>
      SQL("SELECT * FROM UserTable")().map { row =>
        User(
          id = row[Int]("user_id"),
          first_name = row[String]("first_name"),
          last_name = row[String]("last_name"),
          email = row[String]("email_address"),
          emailConfirmed = row[Boolean]("email_confirmed"),
          password = row[String]("passwd"),
          nick = row[String]("user_name"),
          company = row[Option[String]]("company"),
          occupation = row[Option[String]]("occupation"),
          mailing_address = row[Option[String]]("mailing_address"),
          birth_date = row[Option[Date]]("birth_date"),
          manager_id = row[Option[Int]]("manager_id"),
          services = getService(row[String]("services"))
        )
      }.toList
    }
  }

  def findByEmail(email: String): Future[Option[User]] = {
    //Future.successful(users.find(_._2.email == email).map(_._2))
    val user = DB.withConnection { implicit connection =>
      SQL("SELECT * FROM UserTable WHERE email_address={email}").on("email" -> email)().headOption.map { row =>
        User(
          id = row[Int]("user_id"),
          first_name = row[String]("first_name"),
          last_name = row[String]("last_name"),
          email = row[String]("email_address"),
          emailConfirmed = row[Boolean]("email_confirmed"),
          password = "",
          nick = row[String]("user_name"),
          company = row[Option[String]]("company"),
          occupation = row[Option[String]]("occupation"),
          mailing_address = row[Option[String]]("mailing_address"),
          birth_date = row[Option[Date]]("birth_date"),
          manager_id = row[Option[Int]]("manager_id"),
          services = getService(row[String]("services"))
        )
      }
    }
    Future.successful(user)
  }

  def save(user: User): Future[User] = {
    // A rudimentary auto-increment feature...
    //def nextId: Long = users.maxBy(_._1)._1 + 1
    println("Password chosen: " + user.password)
    //val theUser = if (user.id.isDefined) user else user.copy(id = Some(nextId))
    DB.withConnection { implicit connection =>
      SQL(
        """
          INSERT INTO UserTable (first_name, last_name, user_name, email_address, email_confirmed, passwd, company, occupation, mailing_address, birth_date, manager_id, services)
          VALUES ({first_name}, {last_name}, {username}, {email_address}, {email_confirmed}, {password}, {company}, {occupation}, {mailing_address}, {birth_date}, {manager_id}, {services});
        """
      ).on(
          "first_name" -> user.first_name,
          "last_name" -> user.last_name,
          "username" -> user.nick,
          "email_address" -> user.email,
          "email_confirmed" -> user.emailConfirmed,
          "password" -> user.password,
          "company" -> user.company,
          "occupation" -> user.occupation,
          "mailing_address" -> user.mailing_address,
          "birth_date" -> user.birth_date,
          "manager_id" -> user.manager_id,
          "services" -> putService(user.services)
        ).execute()
      Future.successful(user)
    }
  }

  def remove(email: String): Future[Unit] = {
    val bool = DB.withConnection { implicit connection =>
      SQL("DELETE FROM UserTable WHERE email_address={email}").on("email" -> email).execute()
    }
    Future.successful()
  }
}