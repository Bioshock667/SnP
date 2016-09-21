
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[models.User,List[models.User],play.api.mvc.Session,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(curUser: models.User, group: List[models.User])(implicit session: play.api.mvc.Session):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.90*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>Welcome to SnP Server Site</title>
    </head>
    <body>
        <h1>Welcome """),_display_(/*8.22*/session/*8.29*/.get("User_First_Name")),format.raw/*8.52*/("""</h1>
        <h1>About Me</h1>
            """),_display_(/*10.14*/showUser(curUser)),format.raw/*10.31*/("""
        """),format.raw/*11.9*/("""<h1>My Group</h1>
        <a href=""""),_display_(/*12.19*/routes/*12.25*/.Application.logout),format.raw/*12.44*/("""">Signout</a>
        <a href=""""),_display_(/*13.19*/routes/*13.25*/.Application.signUp),format.raw/*13.44*/("""">Add User</a>
         """),_display_(/*14.11*/if(!group.isEmpty)/*14.29*/ {_display_(Seq[Any](format.raw/*14.31*/("""
        """),format.raw/*15.9*/("""<table border="1px black">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th>Company</th>
                <th>Occupation</th>
                <th>Birth Date</th>
            </tr>
            </thead>
            <tbody>
                """),_display_(/*27.18*/group/*27.23*/.map/*27.27*/ { User =>_display_(Seq[Any](format.raw/*27.37*/("""
                """),format.raw/*28.17*/("""<tr>
                    <td>"""),_display_(/*29.26*/User/*29.30*/.first_name),format.raw/*29.41*/("""</td>
                    <td>"""),_display_(/*30.26*/User/*30.30*/.last_name),format.raw/*30.40*/("""</td>
                    <td>"""),_display_(/*31.26*/User/*31.30*/.email_address),format.raw/*31.44*/("""</td>
                    <td>"""),_display_(/*32.26*/User/*32.30*/.company),format.raw/*32.38*/("""</td>
                    <td>"""),_display_(/*33.26*/User/*33.30*/.occupation),format.raw/*33.41*/("""</td>
                    <td>"""),_display_(/*34.26*/User/*34.30*/.birth_date),format.raw/*34.41*/("""</td>
                    <td>
                        <a href='"""),_display_(/*36.35*/routes/*36.41*/.Application.editUser(User.id)),format.raw/*36.71*/("""'>Edit</a>
                    </td>
                    <td>
                        """),_display_(/*39.26*/helper/*39.32*/.form(action = routes.Application.deleteUser(User.id))/*39.86*/{_display_(Seq[Any](format.raw/*39.87*/("""
                            """),format.raw/*40.29*/("""<input type="submit" value="Delete" />
                        """)))}),format.raw/*41.26*/("""
                    """),format.raw/*42.21*/("""</td>
                </tr>
                """)))}),format.raw/*44.18*/("""
            """),format.raw/*45.13*/("""</tbody>
        </table>
        """)))}/*47.11*/else/*47.16*/{_display_(Seq[Any](format.raw/*47.17*/("""
            """),format.raw/*48.13*/("""<p>List is empty</p>
        """)))}),format.raw/*49.10*/("""
    """),format.raw/*50.5*/("""</body>
</html>
"""))}
  }

  def render(curUser:models.User,group:List[models.User],session:play.api.mvc.Session): play.twirl.api.HtmlFormat.Appendable = apply(curUser,group)(session)

  def f:((models.User,List[models.User]) => (play.api.mvc.Session) => play.twirl.api.HtmlFormat.Appendable) = (curUser,group) => (session) => apply(curUser,group)(session)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Sep 20 23:47:52 PDT 2016
                  SOURCE: /home/seth/Documents/LnP-Web-App/app/views/main.scala.html
                  HASH: 15f0f33dd2f571cc2db68c3db481cef711f10969
                  MATRIX: 548->1|724->89|752->91|890->203|905->210|948->233|1020->278|1058->295|1094->304|1157->340|1172->346|1212->365|1271->397|1286->403|1326->422|1378->447|1405->465|1445->467|1481->476|1863->831|1877->836|1890->840|1938->850|1983->867|2040->897|2053->901|2085->912|2143->943|2156->947|2187->957|2245->988|2258->992|2293->1006|2351->1037|2364->1041|2393->1049|2451->1080|2464->1084|2496->1095|2554->1126|2567->1130|2599->1141|2691->1206|2706->1212|2757->1242|2871->1329|2886->1335|2949->1389|2988->1390|3045->1419|3140->1483|3189->1504|3265->1549|3306->1562|3360->1598|3373->1603|3412->1604|3453->1617|3514->1647|3546->1652
                  LINES: 19->1|22->1|24->3|29->8|29->8|29->8|31->10|31->10|32->11|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|48->27|48->27|48->27|48->27|49->28|50->29|50->29|50->29|51->30|51->30|51->30|52->31|52->31|52->31|53->32|53->32|53->32|54->33|54->33|54->33|55->34|55->34|55->34|57->36|57->36|57->36|60->39|60->39|60->39|60->39|61->40|62->41|63->42|65->44|66->45|68->47|68->47|68->47|69->48|70->49|71->50
                  -- GENERATED --
              */
          