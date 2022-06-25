package com.example.jackett

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jackett.databinding.ActivityMainBinding
import com.example.jackett.fragment.FirstFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.root
        val actionBar = supportActionBar
        actionBar!!.title = resources.getString(R.string.app_name)
        addFragment(R.id.frame,FirstFragment())
    }
}