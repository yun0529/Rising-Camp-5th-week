package com.example.rc3b5week

import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.rc3b5week.databinding.ActivityFlightBinding

private lateinit var binding : ActivityFlightBinding

class FlightActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityFlightBinding.inflate(layoutInflater)

        binding.chipOne.setOnClickListener {
            binding.chipTwo.isChecked = false
            if(binding.chipOne.isChecked){
                binding.chipOne.setChipBackgroundColorResource(com.example.rc3b5week.R.color.backBlue)
                binding.chipOne.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyle)
            }
            else{
                binding.chipOne.setChipBackgroundColorResource(com.example.rc3b5week.R.color.white)
                binding.chipOne.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyleN)
            }
            if(binding.chipTwo.isChecked){
                binding.chipTwo.setChipBackgroundColorResource(com.example.rc3b5week.R.color.backBlue)
                binding.chipTwo.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyle)
            }
            else{
                binding.chipTwo.setChipBackgroundColorResource(com.example.rc3b5week.R.color.white)
                binding.chipTwo.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyleN)
            }


        }
        binding.chipTwo.setOnClickListener {
            binding.chipOne.isChecked = false

            if(binding.chipOne.isChecked){
                binding.chipOne.setChipBackgroundColorResource(com.example.rc3b5week.R.color.backBlue)
                binding.chipOne.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyle)
            }
            else{
                binding.chipOne.setChipBackgroundColorResource(com.example.rc3b5week.R.color.white)
                binding.chipOne.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyleN)
            }
            if(binding.chipTwo.isChecked){
                binding.chipTwo.setChipBackgroundColorResource(com.example.rc3b5week.R.color.backBlue)
                binding.chipTwo.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyle)
            }
            else{
                binding.chipTwo.setChipBackgroundColorResource(com.example.rc3b5week.R.color.white)
                binding.chipTwo.setTextAppearanceResource(com.example.rc3b5week.R.style.ChipTextStyleN)
            }

        }

        binding.tvSelectGoLocation.setOnClickListener {
            val intent = Intent(this, GoActivity::class.java)
            startActivityForResult(intent,1234)
        }
        binding.tvSelectArriveLocation.setOnClickListener {
            val intent = Intent(this, ArriveActivity::class.java)
            startActivityForResult(intent,5678)
        }
        binding.tvSelectDate.setOnClickListener {
            val intent = Intent(this, DateActivity::class.java)
            startActivityForResult(intent,9101112)
        }

        binding.ibSelectChange.setOnClickListener {
            var change = binding.tvSelectGoLocation.text.toString()
            binding.tvSelectGoLocation.text = binding.tvSelectArriveLocation.text.toString()
            binding.tvSelectArriveLocation.text = change
        }

        binding.btSearchFlight.setOnClickListener {
            val goData: String = binding.tvSelectGoLocation.text.toString()
            val arriveData: String = binding.tvSelectArriveLocation.text.toString()
            val dateData: String = binding.tvSelectDate.text.toString()

            val intent = Intent(this,FlightListActivity::class.java)
            intent.putExtra("goData",goData)
            intent.putExtra("arriveData",arriveData)
            intent.putExtra("dateData",dateData)
            startActivity(intent)
        }

        setContentView(binding.root)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        if(binding.tvSelectArriveLocation.text != "" && binding.tvSelectDate.text != "" && binding.tvSelectGoLocation.text != "" && binding.tvSelectNum.text != ""){
            binding.btSearchFlight.isEnabled = true
            binding.btSearchFlight.setBackgroundResource(com.example.rc3b5week.R.drawable.select_flight_stroke2)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1234 && resultCode == RESULT_OK) {
            val gData = data?.getStringExtra("Go")
            binding.tvSelectGoLocation.text = gData
        }
        if (requestCode == 5678 && resultCode == RESULT_OK) {
            val aData = data?.getStringExtra("Arrive")
            binding.tvSelectArriveLocation.text = aData
        }
        if (requestCode == 9101112 && resultCode == RESULT_OK) {
            val dData = data?.getStringExtra("Date")
            binding.tvSelectDate.text = dData
        }
    }

}
