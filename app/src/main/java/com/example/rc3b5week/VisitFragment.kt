package com.example.rc3b5week

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rc3b5week.databinding.FragmentVisitBinding
import com.example.rc3b5week.tour.TourList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var binding : FragmentVisitBinding
data class Tour(val name : String, val intro : String?, val where : String, val photo : String, var checked : Boolean)

class VisitFragment : Fragment() {
    private lateinit var lvAdapter: TourAdapter
    private val tourData = arrayListOf<Tour>()
    private val API_KEY = "wdhkh5dw5ev6cvg3"
    @SuppressLint("InflateParams")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentVisitBinding.inflate(layoutInflater, container, false)
        getTourData(API_KEY, "kr","",1,"")
        val footer = layoutInflater.inflate(R.layout.item_footer_list, null, false)
        lvAdapter = TourAdapter(requireContext(), tourData)
        binding.lvTour.addFooterView(footer)
        binding.lvTour.adapter = lvAdapter
        return binding.root

    }
    private fun getTourData(key: String, locale: String, category: String, page: Int, cid: String){
        val tourInterface = TourRetrofitClient.tRetrofit.create(TourInterface::class.java)
        tourInterface.getWeather(key,locale, category, page, cid).enqueue(object :
            Callback<TourList> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<TourList>, response: Response<TourList>) {
                if (response.isSuccessful) {
                    Log.d("FlightList", "데이터는 넘어온다.")
                    val result = response.body() as TourList
                    var n = result.resultCount
                    var t_name = ""
                    var t_intro: String? = ""
                    var t_where = ""
                    var t_photo = ""
                    for(i in 0 until n){
                        t_name = result.items[i].title
                        t_intro = result.items[i].introduction
                        t_where = result.items[i].region1cd.label +" "+ result.items[i].region2cd.label
                        t_photo = result.items[i].repPhoto.photoid.imgpath
                        tourData.add(Tour(t_name, t_intro, t_where, t_photo,false))
                    }
                    lvAdapter.notifyDataSetChanged()
                }

                else{
                    Log.d("FlightList", "FlightData - onResponse : Error code ${response.code()}")
                }
            }
            override fun onFailure(call: Call<TourList>, t: Throwable) {
                Log.d("FlightList", t.message ?: "통신오류")
            }
        })

    }


}