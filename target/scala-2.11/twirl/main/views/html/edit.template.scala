
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
object edit extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Int,Form[models.Company],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Int, company: Form[models.Company]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.42*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>Company Edit Form</title>
    </head>
    <body>
        <h2>Update Company</h2>
        
        """),_display_(/*10.10*/helper/*10.16*/.form(action = routes.Application.updateUser(id))/*10.65*/{_display_(Seq[Any](format.raw/*10.66*/("""
        
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

  def render(id:Int,company:Form[models.Company]): play.twirl.api.HtmlFormat.Appendable = apply(id,company)

  def f:((Int,Form[models.Company]) => play.twirl.api.HtmlFormat.Appendable) = (id,company) => apply(id,company)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Sep 20 00:34:16 PDT 2016
                  SOURCE: /home/seth/Documents/LnP-Web-App/app/views/edit.scala.html
                  HASH: a28308ff321b939ece4d8b94b0e919a3b8a999b6
                  MATRIX: 522->1|650->41|678->43|837->175|852->181|910->230|949->231|1000->255|1015->261|1079->304|1120->318|1135->324|1202->370|1243->384|1258->390|1329->440|1370->454|1385->460|1462->516|1503->530|1518->536|1582->579|1623->593|1638->599|1715->655|1757->669|1844->725|1876->730
                  LINES: 19->1|22->1|24->3|31->10|31->10|31->10|31->10|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|40->19|41->20|42->21
                  -- GENERATED --
              */
          