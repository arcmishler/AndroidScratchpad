package com.example.combolifestyle35.view


import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.combolifestyle35.R
import com.example.combolifestyle35.model.ComboApplication
import com.example.combolifestyle35.model.UserData
import com.example.combolifestyle35.model.UserTable
import com.example.combolifestyle35.viewmodel.ComboViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var mBtSubmit: Button? = null
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private lateinit var bottomBar: BottomNavigationView
    // Initialize the view model here. One per activity.
    // While initializing, we'll also inject the repository.
    // However, standard view model constructor only takes a context to
    // the activity. We'll need to define our own constructor, but this
    // requires writing our own view model factory.
    private val viewModel: ComboViewModel by viewModels {
        ComboViewModel.ComboViewModelFactory((application as ComboApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main)

//        Get the edit text, all the text views, button
//        mEtLocation = findViewById<View>(R.id.et_location) as EditText
//        mTvTemp = findViewById<View>(R.id.tv_temp) as TextView
//        mTvPress = findViewById<View>(R.id.tv_pressure) as TextView
//        mTvHum = findViewById<View>(R.id.tv_humidity) as TextView
//        mBtSubmit = findViewById<View>(R.id.button_submit) as Button
//        mBtSubmit!!.setOnClickListener(this)


        //Set the observer for the vanilla livedata object
        viewModel.userData.observe(this, liveDataObserver)

        //set another observer for the flow-converted-to-livedata object
        // cannot attach observers directly to flows, but the flow
        // has already been converted to a livedata object
        viewModel.allUserData.observe(this, flowObserver)

        //Get the recycler view.
//        mRecyclerView = findViewById<View>(R.id.rv_Master) as RecyclerView

        //Tell Android that we know the size of the recyclerview
        //doesn't change
//        mRecyclerView!!.setHasFixedSize(true)

        //Set the layout manager
//        val layoutManager = LinearLayoutManager(this)
//        mRecyclerView!!.layoutManager = layoutManager
        // Find the NavHostFragment using the fragment ID in your layout
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//
//        // Set up the Navigation Component with the NavHostFragment
    }

    // Override onOptionsItemSelected() to handle up/back button presses
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item)
    }

    // Override onSupportNavigateUp() to handle up/back button presses
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }

    //create an observer that watches the LiveData<WeatherData> object
    private val liveDataObserver: Observer<UserData> =
        Observer { userData -> // Update the UI if this data variable changes
            if (userData != null) {

//                mTvTemp!!.text = "" + (weatherData.temperature.temp - 273.15).roundToInt() + " C"
//                mTvHum!!.text = "" + weatherData.currentCondition.humidity + "%"
//                mTvPress!!.text = "" + weatherData.currentCondition.pressure + " hPa"
            }
        }

    // This observer is triggered when the Flow object in the repository
    // detects a change to the database (including at the start of the app)
    private val flowObserver: Observer<List<UserTable>> =
        Observer { UserTableList ->
            if (UserTableList != null) {
                // Pass the entire list to a RecyclerView
//                mRecyclerView!!.adapter = WeatherRVAdapter(weatherTableList)
            }
        }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_submit -> {
//
//                //Get the string from the edit text and sanitize the input
//                val inputFromEt = mEtLocation!!.text.toString().replace(' ', '&')
//                loadWeatherData(inputFromEt)
            }
        }
    }

//    private fun loadUserData(name: String?) {
//        //pass the location in to the view model
//        viewModel.setName(name!!)
//    }
}