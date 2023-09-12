package com.example.myownnoteapp.ui.fragments

import android.os.Bundle

import androidx.fragment.app.Fragment

import android.view.View

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myownnoteapp.R
import com.example.myownnoteapp.adapters.HomeAdapter
import com.example.myownnoteapp.data.remote.ApiClient
import com.example.myownnoteapp.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {

lateinit var adapter:HomeAdapter
var myNotes = ArrayList<Note>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        adapter = HomeAdapter()
        loadAllNote()
        val bAdd = view.findViewById<FloatingActionButton>(R.id.b_add)
        val rvNotes = view.findViewById<RecyclerView>(R.id.rv_notes)
        rvNotes.adapter= adapter

        bAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }
    }

    private fun loadAllNote() {
        ApiClient.apiService.getAllNotes().enqueue(object :Callback<ArrayList<Note>>{
            override fun onResponse(
                call: Call<ArrayList<Note>>,
                response: Response<ArrayList<Note>>
            ) {
                if (response.isSuccessful){
                    myNotes.clear()
                    myNotes.addAll(response.body()!!)
                    adapter.submitList(myNotes)
                }
            }

            override fun onFailure(call: Call<ArrayList<Note>>, t: Throwable) {

            }
        })
    }


}