package net.elixirpoint.accelerate

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

object Accelerate
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        embeddedServer(Netty, port = 8000) {
            routing {
                get("/") {
                    call.respondText("Hello, world!")
                }
            }
        }.start(wait = true)
        val message = Main("Hello World!")
        println(message.message)
    }

}