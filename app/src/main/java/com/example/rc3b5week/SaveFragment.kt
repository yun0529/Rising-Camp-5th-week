package com.example.rc3b5week

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rc3b5week.databinding.FragmentCityHomeBinding
import com.example.rc3b5week.databinding.FragmentSaveBinding

private lateinit var binding : FragmentSaveBinding

class SaveFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSaveBinding.inflate(layoutInflater,container, false)
        return binding.root


    }
}