
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
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Form[models.Login],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(login: Form[models.Login], message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.46*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>LnP Login</title>
    </head>
    <body>
        <p>"""),_display_(/*8.13*/message),format.raw/*8.20*/("""</p>
        """),_display_(/*9.10*/helper/*9.16*/.form(action = routes.Application.authenticate)/*9.63*/ {_display_(Seq[Any](format.raw/*9.65*/("""
            """),_display_(/*10.14*/helper/*10.20*/.inputText(login("email"), '_label -> "Your Email Address")),format.raw/*10.79*/("""
            """),_display_(/*11.14*/helper/*11.20*/.inputText(login("password"), '_label -> "Your Password")),format.raw/*11.77*/("""
            """),format.raw/*12.13*/("""<input type="submit"  value="Login" />
        """)))}),format.raw/*13.10*/("""
        """),format.raw/*14.9*/("""<a href=""""),_display_(/*14.19*/routes/*14.25*/.Application.signUp),format.raw/*14.44*/("""">SignUp</a>
    </body>
</html>"""))}
  }

  def render(login:Form[models.Login],message:String): play.twirl.api.HtmlFormat.Appendable = apply(login,message)

  def f:((Form[models.Login],String) => play.twirl.api.HtmlFormat.Appendable) = (login,message) => apply(login,message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Sep 20 00:34:16 PDT 2016
                  SOURCE: /home/seth/Documents/LnP-Web-App/app/views/login.scala.html
                  HASH: 633b670ab720424436257fbeceffbddc87af5b94
                  MATRIX: 524->1|656->45|684->47|796->133|823->140|863->154|877->160|932->207|971->209|1012->223|1027->229|1107->288|1148->302|1163->308|1241->365|1282->378|1361->426|1397->435|1434->445|1449->451|1489->470
                  LINES: 19->1|22->1|24->3|29->8|29->8|30->9|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|34->13|35->14|35->14|35->14|35->14
                  -- GENERATED --
              */
          