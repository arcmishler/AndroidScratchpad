package com.example.combolifestyle35.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.combolifestyle35.R

class HomeFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for the Fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Set up UI components and data binding, if needed

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up any UI interactions, event listeners, or ViewModel observers
    }
}