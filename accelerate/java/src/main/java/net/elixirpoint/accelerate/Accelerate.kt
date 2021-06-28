package net.elixirpoint.accelerate

object Accelerate {
    @JvmStatic
    fun main(args: Array<String>) {
        val message = Main("Hello World!")
        println(message.message)
        println(Runner.main)
    }
}