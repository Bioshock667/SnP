package models

import anorm._
import play.api.db._
import play.api.Play.current

case class Company (id: String, name: String, status: String, allocate: String, t: String, fund: String)

object Company {

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
    
    def update(id: String, company: Company) {
        DB.withConnection { implicit connection =>
            SQL("UPDATE test_table SET Name={name}, Active_Inactive={status} WHERE ABC_ID={id}").on(
                "id" -> id,
                "name" -> company.name,
                "status" -> company.status
                ).execute()
        }
    }
    
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