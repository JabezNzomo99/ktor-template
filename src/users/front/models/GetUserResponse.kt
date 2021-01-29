package com.androidmaestro.users.front.models

data class GetUserResponse(
        val userName: String,
        val email: String,
        val bio: String? = null,
        val image: String? = null
)