package net.elixirpoint.accelerate

import java.awt.event.{ActionEvent, ActionListener}

class HelloWorld extends ActionListener {
  override def actionPerformed(arg0: ActionEvent) {
    println("Hello World!")
  }
}