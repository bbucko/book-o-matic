package controllers

import play.api.mvc._
import org.h2.util.Task
import play.api.data.Form
import play.api.data.Forms._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready.", List("A", "B"), List(1, 2, 3), taskForm))
  }

  def deleteTask(id: Long) = Action {
    println(id)
    Ok(s"Hello $id")
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => {
        println(s"dupa $errors")
        BadRequest(views.html.index("", List("C"), List(0), errors))
      },
      label => {
        println(s"hello world $label")
        Redirect(routes.Application.index())
      }
    )
  }

}
