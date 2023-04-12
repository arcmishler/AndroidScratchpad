package com.example.combolifestyle35.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.combolifestyle35.R
import com.example.combolifestyle35.viewmodel.ComboViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var buttonProfile: Button? = null
    private var nameTv: TextView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the fragment's layout
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Update UI with data
        val viewModel = ViewModelProvider(requireActivity())[ComboViewModel::class.java]

        // WORKING -- Use the ViewModel navController to navigate via buttons
        viewModel.navController = findNavController()
        buttonProfile = view.findViewById(R.id.button_profile) as Button
        buttonProfile!!.setOnClickListener {
            viewModel.navigateToProfile()
        }

        // NOT WORKING -- Use the ViewModel to update name textView with
        // name entered in profile
        nameTv = view.findViewById(R.id.name_tv) as TextView
        viewModel.name.observe(viewLifecycleOwner, { name->
            nameTv!!.text = name
        })
    }

}
