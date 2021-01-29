package com.androidmaestro.core.di

import com.androidmaestro.core.data.AppDatabase
import com.androidmaestro.users.data.repository.UserRepository
import com.androidmaestro.users.domain.service.UserService
import com.typesafe.config.ConfigFactory
import io.ktor.config.*
import org.koin.dsl.module

val dataModule = module {
    single {
        AppDatabase(get())
    }
    single { UserRepository() }
}

val coreModule = module {
    single { provideKtorConfig() }
}

val domainModule = module {
    single { UserService(get()) }
}

val appModules = listOf(dataModule, coreModule, domainModule)

private fun provideKtorConfig(): ApplicationConfig {
    return HoconApplicationConfig(ConfigFactory.load())
}