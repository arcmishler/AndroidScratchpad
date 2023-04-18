package com.example.combolifestyle35.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.math.roundToInt

class BottomBarFragment : Fragment(), View.OnClickListener {
    private var activityLevel: String? = null
    private var dailyCalories: String? = null

    private var tvActivity: TextView? = null
    private var tvCalories: TextView? = null

    var onButtonPressed: OnButtonPressed? = null

    interface OnButtonPressed {
        fun caloriePressed()
        fun activityLevelPressed()
    }

    //Associate the callback with this Fragment
    override fun onAttach(context: Context) {
        super.onAttach(context) // TODO fix
        onButtonPressed = try {
            context as OnButtonPressed
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnButtonPressed")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // If profile data saved in arguments, load data
//        getDataFromBundle(arguments)
//
//        // If activity level & calories saved in arguments, load data
//        var al: String? = arguments?.getString(ARG_ACTIVITY)
//        if (al != null)
//            activityLevel = al
//        var dc: String? = arguments?.getString(ARG_CALORIC_LEVEL)
//        if (dc != null)
//            dailyCalories = dc
//
//        // If activity level & calories saved in save state, load data
//        al = savedInstanceState?.getString(ARG_ACTIVITY)
//        if (al != null)
//            activityLevel = al
//        dc = savedInstanceState?.getString(ARG_CALORIC_LEVEL)
//        if (dc != null)
//            dailyCalories = dc
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_bottom_bar, container, false)
//        tvActivity = view.findViewById<View>(R.id.tv_activitylevel_bar) as TextView
//        tvCalories = view.findViewById<View>(R.id.tv_calories_bar) as TextView
//        tvActivity!!.setOnClickListener(this)
//        tvCalories!!.setOnClickListener(this)
//
//        updateView()
//
//        return view
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString(ARG_ACTIVITY, activityLevel)
//        outState.putString(ARG_CALORIC_LEVEL, dailyCalories)
//    }
//
//    private fun updateView() {
//        if (activityLevel != null && tvActivity != null) {
//            tvActivity!!.text = activityLevel
//        }
//        if (dailyCalories != null && tvCalories != null) {
//            tvCalories!!.text = dailyCalories
//        }
//    }
//
//    private fun getDataFromBundle(data: Bundle?) {
//        if (data != null) {
//            // Get activity level as string
//            activityLevel = data.getString(ARG_ACTIVITY)
//
//            // Get activity level as Activity enum
//            var activity: Activity? = null
//            try {
//                if (activityLevel != null)
//                    activity = Activity.valueOf(activityLevel!!)
//            } catch (e: java.lang.IllegalArgumentException) {}
//
//            // Get daily caloric intake
//            if (activity != null) {
//                val height = data.getString(ARG_HEIGHT)?.toIntOrNull()
//                val weight = data.getString(ARG_WEIGHT)?.toIntOrNull()
//                val age = data.getString(ARG_AGE)?.toIntOrNull()
//                var sex: Sex? = null
//                try {
//                    val sexAsString: String? = data.getString(ARG_SEX)
//                    if (sexAsString != null)
//                        sex = Sex.valueOf(sexAsString!!)
//                } catch (e: java.lang.IllegalArgumentException) {}
//                val BMR = calculateBMR(weight, height, age, sex)
//
//                // Calculate daily calorie intake
//                val calories = calculateCaloricIntake(BMR, activity)
//                if (calories != null) {
//                    dailyCalories = calories!!.toInt().toString()
//                }
//            }
//        }
//    }
//
//    fun updateData(data: Bundle?) {
//        getDataFromBundle(data)
//        updateView()
//    }
//
//    override fun onClick(view: View) {
//        when (view.id) {
//            R.id.tv_activitylevel_bar -> {
//                onButtonPressed?.caloriePressed()
//            }
//            R.id.tv_calories_bar -> {
//                onButtonPressed?.activityLevelPressed()
//            }
//        }
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param activityLevel Activity level
//         * @param dailyCalories Daily caloric intake (int)
//         * @return A new instance of fragment BottomBarFragment.
//         */
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            BottomBarFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_ACTIVITY, activityLevel)
//                    putString(ARG_CALORIC_LEVEL, dailyCalories)
//                }
//            }
//    }
}