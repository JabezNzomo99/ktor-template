package com.androidmaestro.config

import com.androidmaestro.articles.controller.articles
import io.ktor.routing.*
import com.androidmaestro.users.controller.users

fun Route.api(){
    route("/api"){
        users()
        articles()
    }
}