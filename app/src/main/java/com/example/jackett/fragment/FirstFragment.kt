package com.example.jackett.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate
import androidx.databinding.DataBindingUtil
import com.example.jackett.R
import com.example.jackett.SecondActivity
import com.example.jackett.addFragment
import com.example.jackett.databinding.FragmentFirstBinding
import com.example.jackett.replaceFragment
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     //   loadLocale()
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadLocale()
        binding.button.setOnClickListener {
            setLang()
        }

        binding.button2.setOnClickListener {
           activity?.replaceFragment(R.id.frame,WelcomeFragment())
        }
    }

    private fun setLang() {
        val listitems= arrayOf("English","मराठी","हिंदी","ગુજરાતી","française")
        val alertDialog=AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Select a Language")
        alertDialog.setSingleChoiceItems(listitems,-1){ dialog,which->
            if (which==0){
                setLocate("en")
                recreate(requireActivity())

            }else if (which==1){
                setLocate("mr")
                recreate(requireActivity())
            }
            else if (which==2){
                setLocate("hi")
                recreate(requireActivity())
            }
            else if (which==3){
                setLocate("gu")
                recreate(requireActivity())
            }
            else if (which==4){
                setLocate("fr")
                recreate(requireActivity())
            }

            dialog.dismiss()
        }
        val dialog=alertDialog.create()
        dialog.show()
    }

    private fun setLocate(Lang: String) {
        val locale=Locale(Lang)
        Locale.setDefault(locale)
        val config=Configuration()
        context?.resources?.updateConfiguration(config,context?.resources?.displayMetrics)
        val editor=context?.getSharedPreferences("Settings",Activity.MODE_PRIVATE)?.edit()
        editor?.putString("MY_Lang",Lang)
        editor?.apply()
    }

    private fun loadLocale(){
        val sharedPreferences=context?.getSharedPreferences("Settings",Activity.MODE_PRIVATE)
        val language=sharedPreferences?.getString("MY_Lang","")
        if (language != null) {
            setLocate(language)
        }
    }
}