package com.androidmaestro.users.controller

import com.androidmaestro.core.models.ResponseErrors
import com.androidmaestro.users.domain.entity.UserEntity
import com.androidmaestro.users.domain.entity.toGetAllUsersResponse
import com.androidmaestro.users.domain.entity.toPostUserResponse
import com.androidmaestro.users.domain.service.UserService
import com.androidmaestro.users.front.models.RegisterUserRequest
import com.androidmaestro.users.front.models.toUserEntity
import com.androidmaestro.users.front.models.validate
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.ktor.ext.inject

fun Route.users(){

    val userService : UserService by inject()
    route("/users"){
        post {
            val request : RegisterUserRequest =  withContext(Dispatchers.IO){
                call.receive()
            }
            request.validate()
            val createdUser = userService.add(request.toUserEntity())
            call.respond(HttpStatusCode.Created, message = createdUser.toPostUserResponse())
        }

        get{
            call.respond(userService.getAll().toGetAllUsersResponse())
        }

    }
}