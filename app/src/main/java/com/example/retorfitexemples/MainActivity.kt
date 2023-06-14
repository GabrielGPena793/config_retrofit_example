package com.example.retorfitexemples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClient.createService(PostService::class.java)
        val call = service.getAll()
        call.enqueue(object : Callback<List<PostEntity>> { // tornar a chamada async
            override fun onResponse(call: Call<List<PostEntity>>, r: Response<List<PostEntity>>) {
                val list = r.body()
            }

            override fun onFailure(call: Call<List<PostEntity>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}