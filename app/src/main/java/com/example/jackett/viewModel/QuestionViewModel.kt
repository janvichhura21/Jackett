package com.example.jackett.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jackett.model.Resource
import com.example.jackett.model.UMQ
import com.example.jackett.repository.MainRepository
import com.google.firebase.firestore.FirebaseFirestore

class QuestionViewModel:ViewModel() {

    var radioGroup=""
    var db= FirebaseFirestore.getInstance()
    var resultSet=MutableLiveData<List<UMQ>>()
    val results=MutableLiveData<UMQ>()
    val answers= MutableLiveData<String>()
    fun getDetails(){
        db.collection("UMQ")
            .get()
            .addOnSuccessListener {
                for(result in it){
                    val user=result.toObject(UMQ::class.java)
                    answers.postValue(user.answer)
                    results.value=user
                    radioGroup=user.options.toString()
                    Log.d("yahooo", user.options.toString())
                    Log.d("viewmodel", user.toString())
                }

            }.addOnFailureListener {
                Log.d("viewmodel", it.message.toString())
            }
    }

    fun getMoreDetails():LiveData<List<UMQ>>{
        db.collection("UMQ")
            .get()
            .addOnSuccessListener {
                resultSet.value=it.toObjects(UMQ::class.java)
                Log.d("laila", it.toObjects(UMQ::class.java).toString())

            }.addOnFailureListener {
                Log.d("viewmodel", it.message.toString())
            }
        return resultSet
    }


    fun getLive(umq: UMQ):LiveData<UMQ>{
        return results
    }
}