package com.androidmaestro.users.front.models

import com.androidmaestro.users.domain.entity.UserEntity
import com.google.gson.annotations.SerializedName
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.isNotBlank
import org.valiktor.functions.isNotEmpty
import org.valiktor.functions.validate
import kotlin.jvm.Throws
import org.valiktor.validate

data class RegisterUserRequest(val user : RegisterUser){
    data class RegisterUser(@SerializedName(value = "username") val userName : String,
                            val email : String,
                            val password : String
    )
}

fun RegisterUserRequest.toUserEntity() : UserEntity{
    return UserEntity(
            userName = this.user.userName,
            email = this.user.email,
            password = this.user.password
    )
}

@Throws(ConstraintViolationException::class)
fun RegisterUserRequest.validate(){
    validate(this){
        validate(RegisterUserRequest::user).validate {
            // Validate user name is not blank or empty
            validate(RegisterUserRequest.RegisterUser::userName).isNotEmpty()
            validate(RegisterUserRequest.RegisterUser::userName).isNotBlank()

            // Validate user name is not blank or empty
            validate(RegisterUserRequest.RegisterUser::email).isNotEmpty()
            validate(RegisterUserRequest.RegisterUser::email).isNotBlank()

            // Validate user name is not blank or empty
            validate(RegisterUserRequest.RegisterUser::password).isNotEmpty()
            validate(RegisterUserRequest.RegisterUser::password).isNotBlank()
        }
    }

}