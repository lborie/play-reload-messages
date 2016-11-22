package services.messages

import javax.inject.Inject

import play.api.{Configuration, Environment, Logger}
import play.api.i18n.{DefaultMessagesApi, Langs}

/**
  * Created by bodul on 22/11/16.
  */
class MessagesHRApi @Inject()(environment: Environment, configuration: Configuration, langs: Langs) extends DefaultMessagesApi(environment, configuration, langs) {

  override protected def loadAllMessages: Map[String, Map[String, String]] = {
    // Log some debug info
    Logger.debug("My personnal logger.")

    langs.availables.map(_.code).map { lang =>
      (lang, loadMessages("messages." + lang))
    }.toMap
      .+("default" -> loadMessages("messages"))
      .+("default.play" -> loadMessages("messages.default"))
  }
}
