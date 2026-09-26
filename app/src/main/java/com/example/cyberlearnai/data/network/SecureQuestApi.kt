package com.example.securequest.data.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

@Serializable
data class AskRequest(
    val question: String
)

@Serializable
data class AskResponse(
    val status: String? = null,
    val answer: String? = null,
    val error: String? = null
)

class SecureQuestApi {

    private val client = OkHttpClient()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val mediaType = "application/json".toMediaType()

    fun ask(question: String): AskResponse {
        val requestBody = json.encodeToString(
            AskRequest.serializer(),
            AskRequest(question)
        ).toRequestBody(mediaType)

        val request = Request.Builder()
             .url("http://10.124.178.215:3000/api/ask")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            val body = response.body?.string().orEmpty()

            if (!response.isSuccessful) {
                return AskResponse(
                    error = "Backend error: ${response.code}"
                )
            }

            return json.decodeFromString<AskResponse>(body)
        }
    }
}
