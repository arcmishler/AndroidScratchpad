package com.example.combolifestyle35.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.combolifestyle35.R
import com.example.combolifestyle35.viewmodel.ComboViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel: ComboViewModel by viewModels()
    private var tv: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the fragment's layout
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Update UI with data
        tv = view.findViewById<View>(R.id.textViewReceiver) as TextView

        viewModel.userData.observe(viewLifecycleOwner, Observer { userData ->
            tv!!.text = userData.profile.name
        })
//        val liveDataObserver: Observer<UserData> =
//            Observer { userData ->
//            if (userData != null) {
//                tv!!.text = userData.user.name
//            }
//        }
        val profile = view.findViewById<Button>(R.id.button_profile) as Button
        // Listeners go here
        profile.setOnClickListener {
            // Navigate to ProfileFragment using the action defined in nav_graph.
            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
            view.findNavController().navigate(action)
        }


    }
}