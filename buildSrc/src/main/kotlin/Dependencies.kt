object Dependencies {
    const val ktor="1.5.0"
    const val kotlin="org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    object Ktor{
        const val netty = "io.ktor:ktor-server-netty:${Versions.ktor}"
        const val locations = "io.ktor:ktor-locations:${Versions.ktor}"
        const val gson = "io.ktor:ktor-gson:${Versions.ktor}"
    }

    object Koin{
        const val ktor = "org.koin:koin-ktor:${Versions.koin}"
        const val logger = "org.koin:koin-logger-slf4j:${Versions.koin}"
    }

    object Database{
        const val postgreSql = "org.postgresql:postgresql:${Versions.postgreSql}"
        const val h2 = "com.h2database:h2:${Versions.h2}"
        // Connection pooling
        const val hikari = "com.zaxxer:HikariCP:${Versions.hikari}"
        // Db migrations
        const val flyway = "org.flywaydb:flyway-core:${Versions.flyway}"
        // ORM
        object Exposed{
            const val core = "org.jetbrains.exposed:exposed-core:${Versions.exposed}"
            const val dao = "org.jetbrains.exposed:exposed-dao:${Versions.exposed}"
            const val jdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposed}"
            const val javaTime = "org.jetbrains.exposed:exposed-java-time:${Versions.exposed}"
        }

    }

    const val valiktor="org.valiktor:valiktor-core:${Versions.valiktor}"
    const val logback = "ch.qos.logback:logback-classic:${Versions.logback}"
}

object TestDependencies{
    object Ktor{
        const val serverTests = "io.ktor:ktor-server-tests:${Versions.ktor}"
    }
}