package com.example.combolifestyle35.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.combolifestyle35.R
import com.example.combolifestyle35.viewmodel.ComboViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var tv: TextView? = null
    private lateinit var viewModel: ComboViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the fragment's layout
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(requireActivity())[ComboViewModel::class.java]

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Update UI with data
        tv = view.findViewById<View>(R.id.textViewReceiver) as TextView

        viewModel.userData.observe(viewLifecycleOwner, Observer { userData ->
            tv!!.text = userData.user.name
        })
//        val liveDataObserver: Observer<UserData> =
//            Observer { userData ->
//            if (userData != null) {
//                tv!!.text = userData.user.name
//            }
//        }
        val profile = view.findViewById<Button>(R.id.button_profile) as Button
        // Listeners go here
    }
}