package com.example.combolifestyle35.view

import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.combolifestyle35.R
import com.example.combolifestyle35.viewmodel.ComboViewModel
import java.text.SimpleDateFormat
import java.util.*

class ProfileFragment: Fragment(), DateSelected {
    private var buttonSubmit: Button? = null
    private var buttonCamera: Button? = null

    private var nameEt: EditText? = null
    private var etName: EditText? = null
    private var etAge: Int? = null
    private var etLoc: AutoCompleteTextView? = null
    private var etWeight: Int? = null
    private var etSex: AutoCompleteTextView? = null
    private var etActivityLvl: AutoCompleteTextView? = null
    private var buttonAge: Button? = null
    private var buttonWeight: Button? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for the Fragment
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)

        //Set up UI components
        val sexes = resources.getStringArray(R.array.sexes)
        val sexAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, sexes)
        etSex = view.findViewById<View>(R.id.tv_sex_data) as AutoCompleteTextView
        etSex!!.setAdapter(sexAdapter)

        // Create location dropdown box
        val locations = resources.getStringArray(R.array.us_states)
        val locAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, locations)
        etLoc = view.findViewById<View>(R.id.tv_loc_data) as AutoCompleteTextView
        etLoc!!.setAdapter(locAdapter)

        // Create location dropdown box
        val activities = resources.getStringArray(R.array.activities)
        val activityAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, activities)
        etActivityLvl= view.findViewById<View>(R.id.tv_activityLevel_data) as AutoCompleteTextView
        etActivityLvl!!.setAdapter(activityAdapter)

        //Get the UI elements
        buttonWeight = view.findViewById<View>(R.id.button_weight) as Button
        buttonAge = view.findViewById<View>(R.id.button_age) as Button
        buttonCamera = view.findViewById<View>(R.id.button_picture) as Button

        etName = view.findViewById<View>(R.id.et_name) as EditText

        //Say that this class itself contains the listener.
//        buttonWeight!!.setOnClickListener(this)
//        buttonAge!!.setOnClickListener(this)
//        buttonCamera!!.setOnClickListener(this)


//        cameraActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
//            if(result.resultCode == Activity.RESULT_OK)
//            {
//                val thumbnailImage: Bitmap?
//                if(Build.VERSION.SDK_INT >= 33)
//                {
//                    thumbnailImage = result.data!!.getParcelableExtra("data", Bitmap::class.java)
//                }
//                else{
//                    thumbnailImage = result.data!!.getParcelableExtra<Bitmap>("data")
//                }
//                dataPasser?.onPFPChanged(thumbnailImage)
//            }
//        };
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[ComboViewModel::class.java]

        viewModel.navController = findNavController()

        nameEt = view.findViewById(R.id.et_name) as EditText

        buttonSubmit = view.findViewById(R.id.button_submit) as Button
        buttonSubmit!!.setOnClickListener {

            val name = nameEt!!.text.toString()
            viewModel.setName(name)

            viewModel.navigateToHome()
        }

        buttonAge!!.setOnClickListener {
            showDatePicker()
        }

        buttonWeight!!.setOnClickListener {
            showWeightPicker()
        }
        // Set up any UI interactions, event listeners, or ViewModel observers
    }

    private fun showWeightPicker() {
        // Create a NumberPicker dialog
        val numberPicker = NumberPicker(requireContext())

        // Set properties for the NumberPicker
        numberPicker.minValue = 1
        numberPicker.maxValue = 999
        numberPicker.value = 100

        // Create an AlertDialog with the NumberPicker as its view
        val dialog = AlertDialog.Builder(requireContext())
            .setView(numberPicker)
            .setTitle("Select Weight")
            .setPositiveButton("OK") { _, _ ->
                // Get the selected value from the NumberPicker
                val weight = numberPicker.value

                // Call a method in FormFragment with the selected weight
                onWeightSelected(weight)
            }
            .setNegativeButton("Cancel", null)
            .create()

        // Show the dialog
        dialog.show()
    }

    private fun onWeightSelected(weight: Int) {
        etWeight = weight
        // Update the text on the weightButton with the selected weight or "Weight"
        val weightButton = view?.findViewById<Button>(R.id.button_weight)
        if (weight > 0) {
            // If a weight is selected, update the text with the weight value
            weightButton?.text = getString(R.string.weight_data, weight)
        } else {
            // If no weight is selected, show "Weight" as the default text
            weightButton?.setText(R.string.weight)
        }

    }
    private fun showDatePicker() {
        val datePickerFragment = DatePickerFragment(this)
        datePickerFragment.show(childFragmentManager, "datePicker")
    }

    // Popup dialog for age
    public class DatePickerFragment(private val dateSelected: DateSelected) : DialogFragment(), android.app.DatePickerDialog.OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val calendar : Calendar = Calendar.getInstance()
            val year : Int = calendar.get(Calendar.YEAR)
            val month : Int = calendar.get(Calendar.MONTH)
            val dayOfMonth : Int = calendar.get(Calendar.DAY_OF_MONTH)
            return DatePickerDialog(requireContext(), this, year, month, dayOfMonth)
        }
        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            dateSelected.receiveDate(year, month, dayOfMonth)
        }

    }
    // Function that gets called when date is picked
    override fun receiveDate(year: Int, month: Int, dayOfMonth: Int) {
        val calendar = GregorianCalendar()
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.YEAR, year)

        // Calculate age
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        etAge = currentYear - year

        val viewFormatter = SimpleDateFormat("MM/dd/yyyy", Locale.US)
        val viewFormattedDate : String = viewFormatter.format(calendar.time)
        buttonAge?.text = viewFormattedDate
    }

//    fun numberPicker() {
//        val numberPicker = NumberPicker(activity)
//        numberPicker.maxValue = 360 // Maximum value to select
//        numberPicker.minValue = 0 // Minimum value to select
//
//        val builder = AlertDialog.Builder(activity)
//        builder.setView(numberPicker)
//        builder.setTitle("Number picker")
//        builder.setMessage("Choose a value :")
//        builder.setPositiveButton("OK") { dialog, which ->
//            Toast.makeText(context, "Number selected " + numberPicker.value, Toast.LENGTH_LONG).show()
//        }
//        builder.setNegativeButton("CANCEL") { dialog, which ->
//            Toast.makeText(context, "You have not selected anything", Toast.LENGTH_LONG).show()
//            dialog.dismiss()
//        }
//        builder.show()
//    }
}
// For DatePickerDialog
interface DateSelected {
    fun receiveDate(year: Int, month: Int, dayOfMonth: Int)

}
