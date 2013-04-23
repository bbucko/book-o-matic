package controllers

import play.api.mvc._
import play.api.libs.json._
import domain.Book

/**
 * User: blazej
 * Date: 4/23/13
 * Time: 7:20 PM
 */

object Books extends Controller {

  val books = List(Book(1, "Title"), Book(2, "New Title"))

  def show(id: Long) = Action {
    books.find(book => book.id == id).map { book =>
      Ok(Json.toJson(book))
    }.getOrElse {
      BadRequest(Json.toJson(Map("error" -> "book not found")))
    }
  }

  def list = Action {
    Ok(Json.toJson(
      Map(
        "count" -> Json.toJson(books.size),
        "total" -> Json.toJson(books.size),
        "list" -> Json.toJson(books))
    ))
  }
}
