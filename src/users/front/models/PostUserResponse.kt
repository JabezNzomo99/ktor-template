package com.androidmaestro.users.front.models

import java.util.*

data class PostUserResponse(val id : UUID? = null,
                            val userName : String,
                            val email : String,
                            val password : String,
                            val createdAt: String? = null
)