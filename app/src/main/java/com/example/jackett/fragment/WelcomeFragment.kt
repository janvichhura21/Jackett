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
import androidx.lifecycle.ViewModelProvider
import com.example.jackett.R
import com.example.jackett.addBackButtonListener
import com.example.jackett.databinding.FragmentWelcomeBinding
import com.example.jackett.replaceFragment
import com.example.jackett.viewModel.ViewModelFactory
import com.example.jackett.viewModel.WelcomeViewModel

class WelcomeFragment : Fragment() {
    lateinit var binding:FragmentWelcomeBinding
    lateinit var viewModel: WelcomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(requireActivity(),ViewModelFactory(requireContext()))[WelcomeViewModel::class.java]
       addBackButtonListener {
           activity?.replaceFragment(R.id.frame,FirstFragment())
       }
        binding.data=viewModel

        setUpBtn()

    }

    private fun setUpBtn() {
        binding.button3.setOnClickListener {

            val view=View.inflate(requireContext(),R.layout.dialog_view,null)
            val builder= AlertDialog.Builder(requireContext())
            builder.setView(view)
            val dialog=builder.create()
            dialog.show()
            dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
            val btn=dialog.findViewById<Button>(R.id.Confirm)
            btn.setOnClickListener {
                activity?.replaceFragment(R.id.frame,SecondFragment())
                dialog.dismiss()
                Toast.makeText(requireContext(), "Role selected", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
