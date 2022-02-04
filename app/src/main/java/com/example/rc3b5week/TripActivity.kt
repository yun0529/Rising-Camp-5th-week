package com.example.rc3b5week

import android.graphics.BitmapRegionDecoder.newInstance
import android.media.ImageReader.newInstance
import android.media.ImageWriter.newInstance
import android.net.sip.SipManager.newInstance
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo.newInstance
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceRequest.newInstance
import android.net.wifi.p2p.nsd.WifiP2pServiceRequest.newInstance
import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceInfo.newInstance
import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceRequest.newInstance
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.rc3b5week.databinding.ActivityTripBinding
import android.R

import androidx.annotation.NonNull

import com.google.android.material.bottomnavigation.BottomNavigationView




private lateinit var cityHomeFragment: CityHomeFragment
private lateinit var planFragment: PlanFragment
private lateinit var tripToolFragment: TripToolFragment
private lateinit var saveFragment: SaveFragment

private lateinit var binding : ActivityTripBinding
class TripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTripBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(com.example.rc3b5week.R.id.fl_fragment, CityHomeFragment()).commit()

        binding.bnvTrip.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                com.example.rc3b5week.R.id.trip_menu_home -> {
                    supportFragmentManager.beginTransaction()
                    .replace(com.example.rc3b5week.R.id.fl_fragment, CityHomeFragment()).commit()
                }
                com.example.rc3b5week.R.id.trip_menu_plan -> {
                    supportFragmentManager.beginTransaction()
                        .replace(com.example.rc3b5week.R.id.fl_fragment, PlanFragment()).commit()
                }
                com.example.rc3b5week.R.id.trip_menu_tool -> {
                    supportFragmentManager.beginTransaction()
                        .replace(com.example.rc3b5week.R.id.fl_fragment, TripToolFragment()).commit()
                }
                com.example.rc3b5week.R.id.trip_menu_save -> {
                    supportFragmentManager.beginTransaction()
                        .replace(com.example.rc3b5week.R.id.fl_fragment, SaveFragment()).commit()
                }
            }
            true
        })


    }
    fun onFragmentChange(index:Int){
        when(index){
            1 -> {supportFragmentManager.beginTransaction()
                .replace(com.example.rc3b5week.R.id.fl_fragment, VisitFragment()).commit()}
            2 -> {supportFragmentManager.beginTransaction()
                .replace(com.example.rc3b5week.R.id.fl_fragment, MapFragment()).commit()}
        }
    }

}