package com.example.myownnoteapp.model

import com.google.gson.annotations.SerializedName


data class Note(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
