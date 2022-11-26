package lila.push

final case class WebSubscription(
    endpoint: String,
    auth: String,
    p256dh: String
)

object WebSubscription:

  object readers:
    import play.api.libs.json.*
    import play.api.libs.functional.syntax.*

    implicit val WebSubscriptionReads: Reads[WebSubscription] = (
      (__ \ "endpoint").read[String] and
        (__ \ "keys" \ "auth").read[String] and
        (__ \ "keys" \ "p256dh").read[String]
    )(WebSubscription.apply)
