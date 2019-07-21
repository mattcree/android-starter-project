package com.starter.project.main.service

import com.starter.project.main.client.MainActivityHttpClient
import retrofit2.HttpException
import java.lang.RuntimeException
import javax.inject.Inject

class MainActivityService @Inject constructor(private val mainHttpClient: MainActivityHttpClient) {

    suspend fun newWord() = try {
        mainHttpClient.getWord().await().words.first()
    } catch (e: HttpException) {
        throw Exception()
    }

    class Exception : RuntimeException()
}