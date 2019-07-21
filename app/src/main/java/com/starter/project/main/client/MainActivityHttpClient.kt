package com.starter.project.main.client

import com.starter.project.main.model.Word
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MainActivityHttpClient {
    @GET("wordbot")
    fun getWord(): Deferred<Word>
}