package com.example.ktorandroidexample.data.remote

import com.example.ktorandroidexample.data.dto.APIService
import com.example.ktorandroidexample.data.dto.UserRequest
import com.example.ktorandroidexample.data.dto.UserResponse
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.lang.Exception

class APIServiceImpl(
    private val client: HttpClient
): APIService {

    override suspend fun getUserResponse(): List<UserResponse> {
        return try {
            return client.get {
                url(ClientApi.POSTS)

            }
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()

        }
        catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()

        }
        catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun createUserRequest(userRequest: UserRequest): UserResponse? {
        return try {
            return client.post<UserResponse> {
                url(ClientApi.POSTS)
                contentType(ContentType.Application.Json)
                body = userRequest

            }
        } catch (e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            null
        }
        catch (e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            null
        }
        catch (e: Exception) {
            println("Error: ${e.message}")
            null
        }
    }
}