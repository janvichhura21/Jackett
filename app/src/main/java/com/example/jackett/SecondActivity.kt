package com.example.jackett

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jackett.fragment.AddQuestionFragment

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        addFragment(R.id.fragment,AddQuestionFragment())
    }
}