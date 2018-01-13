import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ ContentTypes, HttpEntity }
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

object Server extends App {
  implicit val system = ActorSystem("sangria-server")
  implicit val materializer = ActorMaterializer()

  val route: Route =
    get {
      complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>This is my app</h1>"))
    }

  Http().bindAndHandle(route, "localhost", 8080)
}
