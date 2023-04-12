package com.example.combolifestyle35.view

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.combolifestyle35.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mBtSubmit: Button? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null

    private lateinit var navController: NavController
    private val activityName: String = " "

    // Initialize the view model here. One per activity. Also inject the repository.
//    val comboViewModel: ComboViewModel by viewModels {
//        ComboViewModel.ComboViewModelFactory((application as ComboApplication).repository)
//    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(activityName)
//        setContentView(R.layout.activity_main)

//         Find the NavHostFragment using its ID
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Get the NavController from the NavHostFragment
        navController = navHostFragment.navController
//
//        navigateToHomeFragment()
//    }
//
////     Call this function to navigate to HomeFragment
//    private fun navigateToHomeFragment() {
//        // Navigate to HomeFragment
//        navController.navigate(R.id.homeFragment)
//    }
    }

//    fun getDefaultViewModelProviderFactory(): ComboViewModel.ComboViewModelFactory {
//        return ComboViewModel.ComboViewModelFactory((application as ComboApplication).repository)
//    }

    override fun onClick(v: View?) {
    }
}
    // Set click listeners for views that need to handle clicks
//    private fun setupClickListeners() {
//        findViewById<Button>(R.id.button_profile).setOnClickListener(this)
//    }

//    override fun onClick(view: View) {
//        when (view.id) {
//            R.id.button_profile -> {
//                // Handle button_profile click
//                // Navigate to ProfileFragment using the action defined in nav_graph.
//                val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
//                navController.navigate(action)
//            }
//        }
//    }

    // Call this method to load user data
//    private fun loadUserData(name: String?) {
//        //pass the location in to the view model
//        comboViewModel.setName(name!!)
//    }


