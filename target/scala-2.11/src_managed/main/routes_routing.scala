// @SOURCE:/home/seth/Documents/LnP-Web-App/conf/routes
// @HASH:02e455efa1dac87ad0d90f5c2730343aa906f9b7
// @DATE:Sat Sep 17 15:21:30 PDT 2016


import scala.language.reflectiveCalls
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Application_login1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_login1_invoker = createInvoker(
controllers.Application.login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """ Tasks""", Routes.prefix + """login"""))
        

// @LINE:10
private[this] lazy val controllers_Application_logout2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val controllers_Application_logout2_invoker = createInvoker(
controllers.Application.logout,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:11
private[this] lazy val controllers_Application_authenticate3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_authenticate3_invoker = createInvoker(
controllers.Application.authenticate,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
        

// @LINE:12
private[this] lazy val controllers_Application_signup4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
private[this] lazy val controllers_Application_signup4_invoker = createInvoker(
controllers.Application.signup,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "signup", Nil,"GET", """""", Routes.prefix + """signup"""))
        

// @LINE:13
private[this] lazy val controllers_Application_create5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_create5_invoker = createInvoker(
controllers.Application.create,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "create", Nil,"POST", """""", Routes.prefix + """"""))
        

// @LINE:14
private[this] lazy val controllers_Application_edit6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_edit6_invoker = createInvoker(
controllers.Application.edit(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "edit", Seq(classOf[String]),"GET", """""", Routes.prefix + """edit/$id<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_Application_update7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("update/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_update7_invoker = createInvoker(
controllers.Application.update(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "update", Seq(classOf[String]),"POST", """""", Routes.prefix + """update/$id<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_Application_delete8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("delete/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_delete8_invoker = createInvoker(
controllers.Application.delete(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "delete", Seq(classOf[String]),"GET", """""", Routes.prefix + """delete/$id<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_Application_newUser9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("newuser"))))
private[this] lazy val controllers_Application_newUser9_invoker = createInvoker(
controllers.Application.newUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "newUser", Nil,"POST", """""", Routes.prefix + """newuser"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Application.signup"""),("""POST""", prefix,"""controllers.Application.create"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit/$id<[^/]+>""","""controllers.Application.edit(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """update/$id<[^/]+>""","""controllers.Application.update(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """delete/$id<[^/]+>""","""controllers.Application.delete(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newuser""","""controllers.Application.newUser""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:9
case controllers_Application_login1_route(params) => {
   call { 
        controllers_Application_login1_invoker.call(controllers.Application.login)
   }
}
        

// @LINE:10
case controllers_Application_logout2_route(params) => {
   call { 
        controllers_Application_logout2_invoker.call(controllers.Application.logout)
   }
}
        

// @LINE:11
case controllers_Application_authenticate3_route(params) => {
   call { 
        controllers_Application_authenticate3_invoker.call(controllers.Application.authenticate)
   }
}
        

// @LINE:12
case controllers_Application_signup4_route(params) => {
   call { 
        controllers_Application_signup4_invoker.call(controllers.Application.signup)
   }
}
        

// @LINE:13
case controllers_Application_create5_route(params) => {
   call { 
        controllers_Application_create5_invoker.call(controllers.Application.create)
   }
}
        

// @LINE:14
case controllers_Application_edit6_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Application_edit6_invoker.call(controllers.Application.edit(id))
   }
}
        

// @LINE:15
case controllers_Application_update7_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Application_update7_invoker.call(controllers.Application.update(id))
   }
}
        

// @LINE:16
case controllers_Application_delete8_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Application_delete8_invoker.call(controllers.Application.delete(id))
   }
}
        

// @LINE:17
case controllers_Application_newUser9_route(params) => {
   call { 
        controllers_Application_newUser9_invoker.call(controllers.Application.newUser)
   }
}
        
}

}
     