package com.neeraj.helloword

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFA938")))
        btnDatePicker.setOnClickListener{ view->
            clickDatePicker(view)

        }

    }
    fun clickDatePicker(view: View){
        val myCalendar=Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDate="$dayOfMonth/${month+1}/$year"
                tvSelectedDate.setText(selectedDate)
                val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val theDate=sdf.parse(selectedDate)
                val selectedDateinMinutes=theDate!!.time/(60000*24*60)
                val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateToMinutes=currentDate!!.time/(60000*60*24)
                ageTextView.setText((currentDateToMinutes-selectedDateinMinutes).toString())
                                               }
            ,year
            , month
            , day)
        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()
    }
}
