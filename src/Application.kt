package com.androidmaestro

import com.androidmaestro.config.api
import com.androidmaestro.core.data.AppDatabase
import com.androidmaestro.core.di.appModules
import com.androidmaestro.core.exceptions
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import org.koin.ktor.ext.modules
import org.koin.logger.SLF4JLogger

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation){
        gson {
            serializeNulls()
        }
    }

    install(StatusPages){
        exceptions()
    }

    install(Koin){
        SLF4JLogger()
        modules(appModules)
    }

    val appDatabase : AppDatabase by inject()
    appDatabase.init()

    routing {
        api()
        get("/health_check") {
            val isAlive = (appDatabase.dataSource as HikariDataSource).isRunning
            call.respond(HttpStatusCode.OK, "database: $isAlive")
        }
    }
}

