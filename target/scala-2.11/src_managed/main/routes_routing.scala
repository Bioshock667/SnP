// @SOURCE:/home/seth/Documents/LnP-Web-App/conf/routes
// @HASH:aaa36a29afc60904d9821055ef192b8262ec77ae
// @DATE:Tue Sep 20 23:49:17 PDT 2016


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
private[this] lazy val controllers_Application_signUp4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("newUser"))))
private[this] lazy val controllers_Application_signUp4_invoker = createInvoker(
controllers.Application.signUp,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "signUp", Nil,"GET", """""", Routes.prefix + """newUser"""))
        

// @LINE:13
private[this] lazy val controllers_Application_editUser5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("editUser/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_editUser5_invoker = createInvoker(
controllers.Application.editUser(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "editUser", Seq(classOf[Int]),"GET", """""", Routes.prefix + """editUser/$id<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_Application_updateUser6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateUser/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_updateUser6_invoker = createInvoker(
controllers.Application.updateUser(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "updateUser", Seq(classOf[Int]),"POST", """""", Routes.prefix + """updateUser/$id<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_Application_deleteUser7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteUser/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Application_deleteUser7_invoker = createInvoker(
controllers.Application.deleteUser(fakeValue[Int]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteUser", Seq(classOf[Int]),"GET", """""", Routes.prefix + """deleteUser/$id<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_Application_newUser8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("newuser"))))
private[this] lazy val controllers_Application_newUser8_invoker = createInvoker(
controllers.Application.newUser,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "newUser", Nil,"POST", """""", Routes.prefix + """newuser"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newUser""","""controllers.Application.signUp"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """editUser/$id<[^/]+>""","""controllers.Application.editUser(id:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateUser/$id<[^/]+>""","""controllers.Application.updateUser(id:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteUser/$id<[^/]+>""","""controllers.Application.deleteUser(id:Int)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """newuser""","""controllers.Application.newUser""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
case controllers_Application_signUp4_route(params) => {
   call { 
        controllers_Application_signUp4_invoker.call(controllers.Application.signUp)
   }
}
        

// @LINE:13
case controllers_Application_editUser5_route(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_Application_editUser5_invoker.call(controllers.Application.editUser(id))
   }
}
        

// @LINE:14
case controllers_Application_updateUser6_route(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_Application_updateUser6_invoker.call(controllers.Application.updateUser(id))
   }
}
        

// @LINE:15
case controllers_Application_deleteUser7_route(params) => {
   call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_Application_deleteUser7_invoker.call(controllers.Application.deleteUser(id))
   }
}
        

// @LINE:16
case controllers_Application_newUser8_route(params) => {
   call { 
        controllers_Application_newUser8_invoker.call(controllers.Application.newUser)
   }
}
        
}

}
     