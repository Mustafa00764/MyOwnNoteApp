package com.example.myownnoteapp.data.remote

import com.example.myownnoteapp.model.Note
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("notes")
    fun getAllNotes(): Call<ArrayList<Note>>

    @GET("notes/{id}")
    fun getNoteById(@Path("id") id:String):Call<Note>

    @POST("notes")
    fun saveNote(@Body note: Note):Call<Note>

    @PUT("notes/{id}")
    fun editNote(
        @Path("id") id: String,
        @Body note: Note
    ): Call<Note>

    @DELETE("notes/{id}")
    fun deleteNote(@Path("id") id: String):Call<Note>
}