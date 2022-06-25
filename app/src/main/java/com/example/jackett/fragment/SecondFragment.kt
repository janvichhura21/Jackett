package com.example.jackett.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jackett.R
import com.example.jackett.SecondActivity
import com.example.jackett.databinding.ActivitySecondBinding
import com.example.jackett.databinding.FragmentSecondBinding
import com.example.jackett.viewModel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(requireActivity())[LoginViewModel::class.java]
        binding.viewModel=viewModel
        if (FirebaseAuth.getInstance().currentUser!=null){
            startActivity(Intent(requireActivity(),SecondActivity::class.java))
            activity?.finish()
        }
        binding.button4.setOnClickListener {
            val email=binding.edtEmail.text.toString()
            val password=binding.edtPassword.text.toString()
            viewModel.getLogin(email, password)
            Toast.makeText(requireContext(), "Login Successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireContext(),SecondActivity::class.java))
            activity?.finish()
        }
    }

}