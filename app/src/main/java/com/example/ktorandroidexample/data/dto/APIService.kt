package com.example.ktorandroidexample.data.dto

import com.example.ktorandroidexample.data.remote.APIServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface APIService {

    suspend fun getUserResponse(): List<UserResponse>

    suspend fun createUserRequest(userRequest: UserRequest): UserResponse?

    companion object {
        fun create(): APIService{
            return APIServiceImpl(
                client = HttpClient(Android) {
                    install(Logging) {
                        level = LogLevel.ALL

                    }
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }

    }
}