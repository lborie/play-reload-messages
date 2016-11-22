package services.messages

import play.api.{Configuration, Environment}
import play.api.i18n.{DefaultLangs, Langs, MessagesApi}
import play.api.inject.Module

class MessagesHRModule extends Module {
  def bindings(environment: Environment, configuration: Configuration) = {
    Seq(
      bind[Langs].to[DefaultLangs],
      bind[MessagesApi].to[MessagesHRApi],
      bind[play.i18n.MessagesApi].toSelf,
      bind[play.i18n.Langs].toSelf
    )
  }
}