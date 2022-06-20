package com.example.ktorandroidexample.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
   /* val body: String,*/
    val title: String,
    val id: Int,
   /* val userId: Int*/
)
