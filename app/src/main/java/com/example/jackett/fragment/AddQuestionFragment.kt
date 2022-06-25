package com.example.jackett.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.jackett.R
import com.example.jackett.databinding.FragmentAddQuestionBinding
import com.example.jackett.replaceFragment

class AddQuestionFragment : Fragment() {
    lateinit var binding: FragmentAddQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_add_question, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup() {
        binding.imageView.setOnClickListener {
            Toast.makeText(requireContext(), "image", Toast.LENGTH_SHORT).show()
            val view=View.inflate(requireContext(),R.layout.my_library,null)
            val dialog=AlertDialog.Builder(requireContext())
            dialog.setView(view)
            val builder=dialog.create()
            dialog.show()
            val btn=view.findViewById<Button>(R.id.uMQ)
            val btn1=view.findViewById<Button>(R.id.myLibrary)
            btn.setOnClickListener {
                builder.dismiss()
                activity?.replaceFragment(R.id.fragment,UMQFragment())
                Toast.makeText(requireContext(), "Use My Question", Toast.LENGTH_SHORT).show()
            }
            btn1.setOnClickListener {
                Toast.makeText(requireContext(), "My Library", Toast.LENGTH_SHORT).show()
            }
        }

    }

}