
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[List[models.Company],Form[models.Company],play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(companies: List[models.Company], company: Form[models.Company])(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.106*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>Welcome to SnP Server Site</title>
    </head>
    <body>
            <p>Welcome """),_display_(/*8.25*/session/*8.32*/.get("first_name")),format.raw/*8.50*/("""</p>
            <h2>New Company</h2>
            <a href ='"""),_display_(/*10.24*/routes/*10.30*/.Application.logout),format.raw/*10.49*/("""'>Logout</a>
            """),_display_(/*11.14*/helper/*11.20*/.form(action = routes.Application.create)/*11.61*/ {_display_(Seq[Any](format.raw/*11.63*/("""
                """),_display_(/*12.18*/helper/*12.24*/.inputText(company("id"), '_id -> "ABC_ID")),format.raw/*12.67*/("""
                """),_display_(/*13.18*/helper/*13.24*/.inputText(company("name"), '_label -> "Name")),format.raw/*13.70*/("""
                """),_display_(/*14.18*/helper/*14.24*/.inputText(company("status"), '_label -> "Status")),format.raw/*14.74*/("""
                """),_display_(/*15.18*/helper/*15.24*/.inputText(company("allocate"), '_label -> "Allocation")),format.raw/*15.80*/("""
                """),_display_(/*16.18*/helper/*16.24*/.inputText(company("t"), '_label -> "Type")),format.raw/*16.67*/("""
                """),_display_(/*17.18*/helper/*17.24*/.inputText(company("fund"), '_label -> "Funding Source")),format.raw/*17.80*/("""

                """),format.raw/*19.17*/("""<input type="submit" value="New Company" />
            """)))}),format.raw/*20.14*/("""

        """),format.raw/*22.9*/("""<table border="1px black">
            <thead>
            <tr>
                <th>ABC_ID</th>
                <th>Company Name</th>
                <th>Status</th>
                <th>Allocation</th>
                <th>Type</th>
                <th>Funding Source</th>
            </tr>
            </thead>
            <tbody>
                """),_display_(/*34.18*/companies/*34.27*/.map/*34.31*/ { company =>_display_(Seq[Any](format.raw/*34.44*/("""
                """),format.raw/*35.17*/("""<tr>
                    <td>"""),_display_(/*36.26*/company/*36.33*/.id),format.raw/*36.36*/("""</td>
                    <td>"""),_display_(/*37.26*/company/*37.33*/.name),format.raw/*37.38*/("""</td>
                    <td>"""),_display_(/*38.26*/company/*38.33*/.status),format.raw/*38.40*/("""</td>
                    <td>"""),_display_(/*39.26*/company/*39.33*/.allocate),format.raw/*39.42*/("""</td>
                    <td>"""),_display_(/*40.26*/company/*40.33*/.t),format.raw/*40.35*/("""</td>
                    <td>"""),_display_(/*41.26*/company/*41.33*/.fund),format.raw/*41.38*/("""</td>
                    <td>
                        <a href='"""),_display_(/*43.35*/routes/*43.41*/.Application.edit(company.id)),format.raw/*43.70*/("""'>Edit</a>
                    </td>
                    <td>
                        """),_display_(/*46.26*/helper/*46.32*/.form(action = routes.Application.delete(company.id))/*46.85*/{_display_(Seq[Any](format.raw/*46.86*/("""
                            """),format.raw/*47.29*/("""<input type="submit" value="Delete" />
                        """)))}),format.raw/*48.26*/("""
                    """),format.raw/*49.21*/("""</td>
                </tr>
                """)))}),format.raw/*51.18*/("""
            """),format.raw/*52.13*/("""</tbody>
        </table>
    </body>
</html>
"""))}
  }

  def render(companies:List[models.Company],company:Form[models.Company],session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(companies,company)(session)

  def f:((List[models.Company],Form[models.Company]) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (companies,company) => (session) => apply(companies,company)(session)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Sep 17 15:21:31 PDT 2016
                  SOURCE: /home/seth/Documents/LnP-Web-App/app/views/main.scala.html
                  HASH: 27d762851cc24bf6626dd1cbb35909ca3f5a4bf1
                  MATRIX: 560->1|753->105|781->107|922->222|937->229|975->247|1063->308|1078->314|1118->333|1171->359|1186->365|1236->406|1276->408|1321->426|1336->432|1400->475|1445->493|1460->499|1527->545|1572->563|1587->569|1658->619|1703->637|1718->643|1795->699|1840->717|1855->723|1919->766|1964->784|1979->790|2056->846|2102->864|2190->921|2227->931|2602->1279|2620->1288|2633->1292|2684->1305|2729->1322|2786->1352|2802->1359|2826->1362|2884->1393|2900->1400|2926->1405|2984->1436|3000->1443|3028->1450|3086->1481|3102->1488|3132->1497|3190->1528|3206->1535|3229->1537|3287->1568|3303->1575|3329->1580|3421->1645|3436->1651|3486->1680|3600->1767|3615->1773|3677->1826|3716->1827|3773->1856|3868->1920|3917->1941|3993->1986|4034->1999
                  LINES: 19->1|22->1|24->3|29->8|29->8|29->8|31->10|31->10|31->10|32->11|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|40->19|41->20|43->22|55->34|55->34|55->34|55->34|56->35|57->36|57->36|57->36|58->37|58->37|58->37|59->38|59->38|59->38|60->39|60->39|60->39|61->40|61->40|61->40|62->41|62->41|62->41|64->43|64->43|64->43|67->46|67->46|67->46|67->46|68->47|69->48|70->49|72->51|73->52
                  -- GENERATED --
              */
          