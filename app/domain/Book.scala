package domain

import play.api.libs.json._
import play.api.libs.json.JsSuccess

/**
 * User: blazej
 * Date: 4/23/13
 * Time: 9:04 PM
 */
case class Book(id: Long, title: String)

object Book {

  implicit object BookFormat extends Format[Book] {

    def writes(o: Book): JsValue = JsObject(Seq("id" -> JsNumber(o.id), "title" -> JsString(o.title)))

    def reads(json: JsValue): JsResult[Book] = JsSuccess(Book((json \ "id").as[Long], (json \ "title").as[String]))
  }

}

