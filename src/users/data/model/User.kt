package com.androidmaestro.users.data.model

import com.androidmaestro.core.data.ExtendedUUIDEntity
import com.androidmaestro.core.data.ExtendedUUIDEntityClass
import com.androidmaestro.core.data.ExtendedUUIDTable
import com.androidmaestro.users.domain.entity.UserEntity
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

object Users : ExtendedUUIDTable("Users"){
    val userName = varchar("username", 255).uniqueIndex()
    val email = varchar("email", 255).uniqueIndex()
    val bio = text("bio").default("")
    val image = varchar("image", 255).nullable()
    val password = varchar("password", 255)
}

class UsersDao(id: EntityID<UUID>) : ExtendedUUIDEntity(id, Users){
    companion object : ExtendedUUIDEntityClass<UsersDao>(Users)
    var userName by Users.userName
    var email by Users.email
    var bio by Users.bio
    var image by Users.image
    var password by Users.password
}

fun UsersDao.toEntity() : UserEntity{
    return UserEntity(
            this.uid,
            this.userName,
            this.email,
            this.password,
            this.createAt.toString(),
            this.bio,
            this.image
    )
}