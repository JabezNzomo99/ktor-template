package com.androidmaestro.users.data.repository

import com.androidmaestro.users.data.model.Users
import com.androidmaestro.users.data.model.UsersDao
import com.androidmaestro.users.data.model.toEntity
import com.androidmaestro.users.domain.entity.UserEntity
import org.jetbrains.exposed.sql.or
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UserRepository {
    suspend fun insert(userEntity : UserEntity) : UserEntity = newSuspendedTransaction {
        val existingUser = UsersDao.find {
            (Users.userName eq userEntity.userName) or (Users.email eq userEntity.email)
        }.firstOrNull()
        if(existingUser != null) throw UserExists("User already exists")
        UsersDao.new {
            userName = userEntity.userName
            email = userEntity.email
            password = userEntity.password
        }.toEntity()
    }

    suspend fun getAll() : List<UserEntity> = newSuspendedTransaction {
        UsersDao.all().map(UsersDao::toEntity)
    }
}

class UserExists(override val message: String? = null) : RuntimeException(message)