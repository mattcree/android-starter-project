package com.starter.project.dagger

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.starter.project.config.Config
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun providesObjectMapper() = ObjectMapper().registerKotlinModule()

    @Provides
    fun providesHttpClient() = OkHttpClient.Builder().build()

    @Provides
    fun providesRetrofit(config: Config, client: OkHttpClient, objectMapper: ObjectMapper) = Retrofit.Builder()
        .baseUrl(config.baseUrl)
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(client)
        .build()
}