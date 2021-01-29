package com.androidmaestro.articles.controller

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.articles(){
    route("/articles"){
        get {
            call.respondText("Articles")
        }
    }
}