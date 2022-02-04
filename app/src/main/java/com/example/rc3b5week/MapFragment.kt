package com.example.rc3b5week

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rc3b5week.databinding.FragmentMapBinding
import com.example.rc3b5week.databinding.FragmentVisitBinding
import android.R
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import net.daum.mf.map.api.MapPOIItem





private lateinit var binding : FragmentMapBinding
class MapFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentMapBinding.inflate(layoutInflater, container, false)

        val mapView = MapView(activity)
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(33.41427, 126.26667), true);
        val MARKER_POINT = MapPoint.mapPointWithGeoCoord(33.41427, 126.26667)
        val mapViewContainer = binding.clMap as ViewGroup
        val customMarker = MapPOIItem()
        customMarker.itemName = "Custom Marker"
        customMarker.tag = 1
        customMarker.mapPoint = MARKER_POINT
        customMarker.markerType = MapPOIItem.MarkerType.CustomImage // 마커타입을 커스텀 마커로 지정.

        customMarker.customImageResourceId = com.example.rc3b5week.R.drawable.custom_marker // 마커 이미지.

        customMarker.isCustomImageAutoscale =
            false // hdpi, xhdpi 등 안드로이드 플랫폼의 스케일을 사용할 경우 지도 라이브러리의 스케일 기능을 꺼줌.

        customMarker.setCustomImageAnchor(0.5f, 1.0f)

        mapView.addPOIItem(customMarker)
        mapViewContainer.addView(mapView)

        return binding.root
    }


}