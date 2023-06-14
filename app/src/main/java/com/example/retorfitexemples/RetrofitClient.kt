package com.example.retorfitexemples

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/" // sempre termina com  / no final

        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()

            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)                                  // URl base das requests
                    .client(http.build())                               // Quem vai fazer a chamada a internet
                    .addConverterFactory(GsonConverterFactory.create()) // nescessário par converter o json em classes
                    .build()
            }
            return INSTANCE
        }

        // Função para criar o serviço indenpende de qual entidade seja
        fun <T> createService(service: Class<T>): T {
            return getRetrofitInstance().create(service)
        }
    }
}