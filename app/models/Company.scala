package models

import anorm._
import play.api.db._
import play.api.Play.current

case class Company (id: String, name: String, status: String, allocate: String, t: String, fund: String)

object Company {
/*
    This function connects to a MySQL database and queries for the first 20 entries of the
    table.  It returns the list of Company objects.
 */
    def all = {

        DB.withConnection { implicit connection =>

            SQL("SELECT * FROM test_table limit 20")().map { row =>
                Company(
                  id = row[String]("ABC_ID"),
                  name = row[String]("Name"),
                  status = row[String]("Active_Inactive"),
                  allocate = row[String]("Allocation"),
                  t = row[String]("Type"),
                  fund = row[String]("Funding_Source")
                )
            }.toList
        }
    }
/*
    THis function takes in a company object and sends it to a database to be inserted.
 */
    def create(company: Company) = {
        DB.withConnection { implicit connection =>

        SQL("INSERT INTO test_table(Active_Inactive, ABC_ID, Name, Allocation, Type, Funding_Source)" +
          " VALUES ({status}, {id}, {name}, {allo}, {type}, {FS})").on(
            "name" -> company.name,
            "status" -> company.status,
            "id" -> company.id,
            "allo" -> company.allocate,
            "type" -> company.t,
            "FS"  -> company.fund
        ).execute()
        }
    }
/*
    This function takes the id and queries for an entry with that id and returns it as
    a company object
 */
    def get(id: String) = {
        DB.withConnection { implicit connection =>
            SQL("SELECT * FROM test_table WHERE ABC_ID={id}").on("id" -> id)().headOption.map {row =>
                Company(
                    id = row[String]("ABC_ID"),
                    name = row[String]("Name"),
                    status = row[String]("Active_Inactive"),
                    allocate = row[String]("Allocation"),
                    t = row[String]("Type"),
                    fund = row[String]("Funding_Source")
                )
            }
        }
    }

    /*
    This function takes the id and the company object and passes to a UPDATE query
     */
    def update(id: String, company: Company) {
        DB.withConnection { implicit connection =>
            SQL("UPDATE test_table SET Name={name}, Active_Inactive={status} WHERE ABC_ID={id}").on(
                "id" -> id,
                "name" -> company.name,
                "status" -> company.status
                ).execute()
        }
    }

    /**
      * This function deletes an entry from the database
      * @param id the id of the entry to be deleted
      */
    def delete(id: String) {
        DB.withConnection{ implicit connection =>
            SQL("DELETE FROM test_table WHERE ABC_ID={id}").on("id" -> id).execute()
    
        }
    }
    import play.api.data._
    import play.api.data.Forms._

    val form = Form(
        mapping(
          "id" -> nonEmptyText,
          "name" -> nonEmptyText,
          "status" -> nonEmptyText,
          "allocate" -> nonEmptyText,
          "t" -> nonEmptyText,
          "fund" -> nonEmptyText
        )(Company.apply)(Company.unapply)
    )
}