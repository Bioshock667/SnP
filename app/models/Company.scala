package models

import anorm._
import play.api.db._
import play.api.Play.current

case class Company (id: String, name: String, status: String)

object Company {

    def all = {

        DB.withConnection { implicit connection =>

            SQL("SELECT Active_Inactive, ABC_ID, Name FROM sample.test_table limit 10")().map { row =>
                Company(
                    id = row[String]("ABC_ID"),
                    name = row[String]("Name"),
                    status = row[String]("Active_Inactive")
                )
            }.toList
        }
    }
}