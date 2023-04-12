package com.example.combolifestyle35.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.combolifestyle35.R
import com.example.combolifestyle35.model.ComboApplication
import com.example.combolifestyle35.viewmodel.ComboViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment: Fragment(R.layout.fragment_profile) {
    private val viewModel: ComboViewModel by viewModels()
    private var nameEt: EditText? = null
    private var done: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for the Fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEt = view.findViewById<View>(R.id.et_user) as EditText
        done = view.findViewById<View>(R.id.button_done) as Button

        done?.setOnClickListener() {
           viewModel.setName(nameEt?.text.toString())
        }

        // Set up any UI interactions, event listeners, or ViewModel observers
//        comboViewModel.userData.observe(viewLifecycleOwner, {
//            nameET.text.toString(
//        })
            // Replace with actual name entered by user
            // Update ViewModel with the new user data
//            viewModel.setName(name)

    }

//    // Function to update user data
//    private fun loadUserData(name: String) {
////         Update ViewModel with the new user data
//        comboViewModel.setName(name)
//    }
}