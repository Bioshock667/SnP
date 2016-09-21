
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
object userForm extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[models.User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: Form[models.User]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.27*/("""

"""),_display_(/*3.2*/helper/*3.8*/.form(action = routes.Application.newUser)/*3.50*/ {_display_(Seq[Any](format.raw/*3.52*/("""
    """),_display_(/*4.6*/helper/*4.12*/.inputText(user("first_name"), '_label -> "First Name")),format.raw/*4.67*/("""
    """),_display_(/*5.6*/helper/*5.12*/.inputText(user("last_name"), '_label -> "Last Name")),format.raw/*5.65*/("""
    """),_display_(/*6.6*/helper/*6.12*/.inputText(user("email_address"), '_label -> "Email Address")),format.raw/*6.73*/("""
    """),_display_(/*7.6*/helper/*7.12*/.inputText(user("password"), '_label -> "Password")),format.raw/*7.63*/("""
    """),_display_(/*8.6*/helper/*8.12*/.inputText(user("company"), '_label -> "Company")),format.raw/*8.61*/("""
    """),_display_(/*9.6*/helper/*9.12*/.inputText(user("mailing_address"), '_label -> "Mailing Address")),format.raw/*9.77*/("""
    """),_display_(/*10.6*/helper/*10.12*/.inputText(user("occupation"), '_label -> "Occupation")),format.raw/*10.67*/("""
    """),_display_(/*11.6*/helper/*11.12*/.inputText(user("birth_date"), '_label -> "Birth Date")),format.raw/*11.67*/("""

    """),format.raw/*13.5*/("""<input type="submit" value="New User" />
""")))}))}
  }

  def render(user:Form[models.User]): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((Form[models.User]) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Sep 20 22:13:29 PDT 2016
                  SOURCE: /home/seth/Documents/LnP-Web-App/app/views/userForm.scala.html
                  HASH: fb2350436291435738360ff544fce6f80a283ad0
                  MATRIX: 519->1|632->26|660->29|673->35|723->77|762->79|793->85|807->91|882->146|913->152|927->158|1000->211|1031->217|1045->223|1126->284|1157->290|1171->296|1242->347|1273->353|1287->359|1356->408|1387->414|1401->420|1486->485|1518->491|1533->497|1609->552|1641->558|1656->564|1732->619|1765->625
                  LINES: 19->1|22->1|24->3|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|34->13
                  -- GENERATED --
              */
          