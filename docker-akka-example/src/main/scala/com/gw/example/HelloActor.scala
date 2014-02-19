package com.gw.example

import akka.actor.{Props, ActorSystem, Actor}
import akka.kernel.Bootable

class HelloActor extends Actor {
  override def receive = {
    case name: String => println(s"Hello $name!")
  }
}

class HelloKernel extends Bootable {
  val system = ActorSystem()

  override def startup() = {
    system.actorOf(Props[HelloActor]) ! "John"
  }

  override def shutdown() = {
    system.shutdown()
  }
}