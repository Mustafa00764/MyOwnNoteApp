package com.example.myownnoteapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import com.example.myownnoteapp.R
import com.example.myownnoteapp.data.remote.ApiClient
import com.example.myownnoteapp.model.Note
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddFragment : Fragment(R.layout.fragment_add) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        val llSave = view.findViewById<LinearLayout>(R.id.ll_save)
        val etTitle = view.findViewById<EditText>(R.id.et_title)
        val etDescription = view.findViewById<EditText>(R.id.et_description)

        llSave.setOnClickListener {
            val title = etTitle.text.toString()
            val description = etDescription.text.toString()
            val color:String = getRandomColor()
            val note=Note(title= title, description = description, color = color)
            if (title.isNotEmpty() && description.isNotEmpty()) saveNote(note)
        }
    }

    private fun saveNote(note: Note) {
        //loading
        ApiClient.apiService.saveNote(note).enqueue(object :Callback<Note>{
            override fun onResponse(call: Call<Note>, response: Response<Note>) {
                //hideLoading
                if (response.isSuccessful){
                    findNavController().navigate(R.id.action_addFragment_to_homeFragment)
                }
            }

            override fun onFailure(call: Call<Note>, t: Throwable) {
                //hideLoading
            }

        })


    }

    private fun getRandomColor(): String {
        val rnds = (0..3).random()
        when(rnds){
            0->{
                return "#FF9E9E"
            }
            1->{
                return "#91F48F"
            }
            2->{
                return "#FFF599"
            }
            else->{
                return "#B69CFF"
            }
        }
    }

}