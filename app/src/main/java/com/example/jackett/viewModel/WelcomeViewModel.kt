package com.example.jackett.viewModel

import android.content.Context
import android.util.Log
import android.widget.RadioButton
import androidx.lifecycle.ViewModel
import com.example.jackett.R

class WelcomeViewModel(val context: Context):ViewModel() {

    var checkedRole=""

    fun getRole(radioButton: RadioButton){
        radioButton.setOnCheckedChangeListener { r, i ->
            if (r.isChecked){
                checkedRole= context.getString(R.string.teacher)
                Log.d("locking", checkedRole)
            }
            else{
                checkedRole= context.getString(R.string.student)
                Log.d("checking", checkedRole)
            }
        }
    }
}