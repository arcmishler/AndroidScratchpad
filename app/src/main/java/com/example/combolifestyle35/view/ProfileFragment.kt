package com.example.combolifestyle35.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.combolifestyle35.R
import com.example.combolifestyle35.viewmodel.ComboViewModel

class ProfileFragment: Fragment() {
    private var buttonDone: Button? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for the Fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Set up UI components and data binding, if needed

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[ComboViewModel::class.java]

        viewModel.navController = findNavController()


        buttonDone = view.findViewById(R.id.button_done) as Button
        buttonDone!!.setOnClickListener {
            viewModel.navigateToHome()
        }
        // Set up any UI interactions, event listeners, or ViewModel observers
    }
}