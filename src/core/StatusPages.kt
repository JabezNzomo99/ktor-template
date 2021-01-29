package com.androidmaestro.core

import com.androidmaestro.core.models.ResponseErrors
import com.androidmaestro.users.data.repository.UserExists
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import org.valiktor.ConstraintViolationException

fun StatusPages.Configuration.exceptions(){


    exception<ConstraintViolationException> { exception ->
        // Basic ConstraintViolationException handler
        val violations = exception.constraintViolations.map { violation -> "${violation.property}:${violation.constraint.name}" }
        call.respond(status = HttpStatusCode.UnprocessableEntity, message = ResponseErrors(ResponseErrors.Errors(violations.toList())))
    }
    exception<UserExists> { exception ->
        call.respond(status = HttpStatusCode.Conflict, message = ResponseErrors(ResponseErrors.Errors(listOf(exception.message))))
    }

    exception<Throwable> { exception ->
        application.log.error("Unhandled exception", exception)
        call.respond(HttpStatusCode.InternalServerError)
    }
}