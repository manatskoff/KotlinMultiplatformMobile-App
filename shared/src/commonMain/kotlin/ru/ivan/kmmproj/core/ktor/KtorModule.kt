package ru.ivan.kmmproj.core.ktor

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.ivan.kmmproj.core.serialization.serializationModule


internal val ktorModule = DI.Module(
        name = "KtorModule",
        init = {

            bind<HttpEngineFactory>() with singleton { HttpEngineFactory()}

            bind<HttpClient>() with singleton {

                val engine = instance<HttpEngineFactory>().createEngine()

                HttpClient(engine) {
                    install(Logging) {
                        logger = Logger.SIMPLE
                        level = LogLevel.ALL
                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }

                    defaultRequest {
                        host = "hubblesite.org"
                        url {
                            protocol = URLProtocol.HTTPS
                        }
                    }
                }

            }

        }
)