package com.example.jackett.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jackett.R
import com.example.jackett.databinding.FragmentUMQBinding
import com.example.jackett.model.UMQ
import com.example.jackett.viewModel.QuestionViewModel

class UMQFragment : Fragment() {
    lateinit var binding:FragmentUMQBinding
    lateinit var viewModel: QuestionViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_u_m_q, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(requireActivity())[QuestionViewModel::class.java]
        binding.data=viewModel
        viewModel.getDetails()
        viewModel.getMoreDetails()
      //  getthings()
        rechecked()
        nextBtn()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun nextBtn() {
            viewModel.resultSet.observe(viewLifecycleOwner, Observer { umq ->
              for (i in umq){
               //   binding.button6.setOnClickListener {
                      binding.ques.text = i.question
                      binding.radioButton3.text = i.options[0]
                      binding.radioButton4.text = i.options[1]
                      //  rechecked()
                //  }
                  Toast.makeText(requireContext(),"janvi", Toast.LENGTH_SHORT).show()
              }
            })

    }

    private fun rechecked() {
        viewModel.results.observe(viewLifecycleOwner, Observer {umq->
            binding.radioButton3.setOnClickListener {
                if (binding.radioButton3.text == umq.answer) {
                    binding.radioButton3.setBackgroundColor(resources.getColor(R.color.green))
                    binding.textView2.visibility = View.VISIBLE
                    binding.textView2.text = umq.answer
                } else {
                    binding.radioButton3.setBackgroundColor(resources.getColor(R.color.red))
                    binding.textView2.visibility = View.VISIBLE
                    binding.textView2.text = umq.answer
                }
            }
            binding.radioButton4.setOnClickListener {
                val umq = UMQ()
                if (binding.radioButton4.text == umq.answer) {
                    binding.radioButton4.setBackgroundColor(resources.getColor(R.color.green))
                    binding.textView2.visibility = View.VISIBLE
                    binding.textView2.text = umq.answer
                } else {
                    binding.radioButton4.setBackgroundColor(resources.getColor(R.color.red))
                    binding.textView2.visibility = View.VISIBLE
                    binding.textView2.text = umq.answer
                }
            }
        })
    }

    private fun getthings() {
        viewModel.results.observe(viewLifecycleOwner, Observer {
            binding.ques.text=it.question
            binding.radioButton3.text=it.options[0]
            binding.radioButton4.text=it.options[1]
            Log.d("janvi",it.answer)

        })
    }
}