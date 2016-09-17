
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Form[models.Company],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: String, company: Form[models.Company]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.45*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>Company Edit Form</title>
    </head>
    <body>
        <h2>Update Company</h2>
        
        """),_display_(/*10.10*/helper/*10.16*/.form(action = routes.Application.update(id))/*10.61*/{_display_(Seq[Any](format.raw/*10.62*/("""
        
             """),_display_(/*12.15*/helper/*12.21*/.inputText(company("id"), '_id -> "ABC_ID")),format.raw/*12.64*/("""
            """),_display_(/*13.14*/helper/*13.20*/.inputText(company("name"), '_label -> "Name")),format.raw/*13.66*/("""
            """),_display_(/*14.14*/helper/*14.20*/.inputText(company("status"), '_label -> "Status")),format.raw/*14.70*/("""
            """),_display_(/*15.14*/helper/*15.20*/.inputText(company("allocate"), '_label -> "Allocation")),format.raw/*15.76*/("""
            """),_display_(/*16.14*/helper/*16.20*/.inputText(company("t"), '_label -> "Type")),format.raw/*16.63*/("""
            """),_display_(/*17.14*/helper/*17.20*/.inputText(company("fund"), '_label -> "Funding Source")),format.raw/*17.76*/("""

            """),format.raw/*19.13*/("""<input type="submit" value="Update Company" />
        """)))}),format.raw/*20.10*/("""
    """),format.raw/*21.5*/("""</body>
</html>"""))}
  }

  def render(id:String,company:Form[models.Company]): play.twirl.api.HtmlFormat.Appendable = apply(id,company)

  def f:((String,Form[models.Company]) => play.twirl.api.HtmlFormat.Appendable) = (id,company) => apply(id,company)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Sep 17 15:21:31 PDT 2016
                  SOURCE: /home/seth/Documents/LnP-Web-App/app/views/edit.scala.html
                  HASH: 47fb32ea37b759b76f6fef793fb9387daaac8c41
                  MATRIX: 525->1|656->44|684->46|843->178|858->184|912->229|951->230|1002->254|1017->260|1081->303|1122->317|1137->323|1204->369|1245->383|1260->389|1331->439|1372->453|1387->459|1464->515|1505->529|1520->535|1584->578|1625->592|1640->598|1717->654|1759->668|1846->724|1878->729
                  LINES: 19->1|22->1|24->3|31->10|31->10|31->10|31->10|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|40->19|41->20|42->21
                  -- GENERATED --
              */
          