package com.example.rc3b5week

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.rc3b5week.databinding.FragmentCityHomeBinding
import android.content.pm.PackageManager

import android.content.pm.PackageInfo
import android.graphics.Paint
import android.util.Base64
import android.util.Log
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


private lateinit var binding : FragmentCityHomeBinding

class CityHomeFragment : Fragment() {
    var activity : TripActivity? = TripActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCityHomeBinding.inflate(layoutInflater,container, false)

        binding.tvCityHomeTitle.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        binding.tvCityHomeTour.setOnClickListener {
            //Toast.makeText(activity,"눌러는 짐",Toast.LENGTH_LONG).show()
            activity?.onFragmentChange(1)
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = getActivity() as TripActivity
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }



}