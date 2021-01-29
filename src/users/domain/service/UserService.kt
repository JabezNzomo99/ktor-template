package com.androidmaestro.users.domain.service

import com.androidmaestro.users.data.repository.UserRepository
import com.androidmaestro.users.domain.entity.UserEntity

class UserService (private val userRepository: UserRepository) {
    suspend fun add(userEntity: UserEntity) = userRepository.insert(userEntity)
    suspend fun getAll(): List<UserEntity> = userRepository.getAll()
}