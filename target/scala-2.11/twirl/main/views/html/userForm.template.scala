
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
"""))}
  }

  def render(user:Form[models.User]): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((Form[models.User]) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Sep 17 15:21:31 PDT 2016
                  SOURCE: /home/seth/Documents/LnP-Web-App/app/views/userForm.scala.html
                  HASH: e17cfcdf082e0ab7f3426c7278241a551c6b2d91
                  MATRIX: 519->1|632->26
                  LINES: 19->1|22->1
                  -- GENERATED --
              */
          