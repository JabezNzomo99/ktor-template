package com.androidmaestro.users.domain.entity

import com.androidmaestro.users.front.models.GetAllUsersResponse
import com.androidmaestro.users.front.models.GetUserResponse
import com.androidmaestro.users.front.models.PostUserResponse
import java.util.*

data class UserEntity(
        val id : UUID? = null,
        val userName : String,
        val email : String,
        val password : String,
        val createdAt: String? = null,
        val bio : String? = null,
        val image : String? = null
)

fun UserEntity.toPostUserResponse() = PostUserResponse(
        this.id,
        this.userName,
        this.email,
        this.password,
        this.createdAt
)

fun UserEntity.toGetUserResponse() = GetUserResponse(
        this.userName,
        this.email,
        this.bio,
        this.image
)

fun List<UserEntity>.toGetAllUsersResponse() : GetAllUsersResponse = GetAllUsersResponse(this.map(UserEntity::toGetUserResponse))