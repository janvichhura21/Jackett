package com.example.jackett.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel:ViewModel() {
    val TAG=LoginViewModel::class.java
    var firebaseAuth=FirebaseAuth.getInstance()
    val email=""
    val password=""
    fun getLogin(email:String, password:String){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                Log.d(TAG.toString(),"$it" )
            }.addOnFailureListener {
                Log.d(TAG.toString(),"error",it)
            }
    }
}