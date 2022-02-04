package com.example.rc3b5week

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.rc3b5week.databinding.FragmentTripToolBinding
import com.example.rc3b5week.model.WeatherResponse
import com.example.rc3b5week.testModel.TestResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

private lateinit var binding: FragmentTripToolBinding

class TripToolFragment : Fragment() {
    private val API_KEY = "85a798e66825e9c0bf87bc69ac33f43d"
    private val API_KEY2 = "45f932fd7c76ec5414b5c8ec204ea5cf"
    private val longNow = System.currentTimeMillis()
    private val Cal : Calendar = Calendar.getInstance()
    private val tDate = Date(longNow)
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentTripToolBinding.inflate(layoutInflater, container, false)
        getWeatherData(33.4624,126.54039,"minutely",API_KEY2)


        val tDateFormat = SimpleDateFormat("MM.dd", Locale("ko", "KR"))
        val strDate = tDateFormat.format(tDate)
        binding.tvTodayDate.text = strDate.toString()

        //val timeFormat = SimpleDateFormat("hh:mm", Locale("ko", "KR"))
        //val strTime = timeFormat.format(tDate)

        val hour = (Cal.get(Calendar.HOUR) + 1).toString()
        val hour2 = (Cal.get(Calendar.HOUR) + 2).toString()
        val hour3 = (Cal.get(Calendar.HOUR) + 3).toString()

        if(hour.toInt() < 10){
            binding.tvCurrentTime2.text = "0$hour:00"
        }
        else{
            binding.tvCurrentTime2.text = "$hour:00"
        }
        if(hour2.toInt() < 10){
            binding.tvCurrentTime3.text = "0$hour2:00"
        }
        else{
            binding.tvCurrentTime3.text = "$hour:00"
        }
        if(hour3.toInt() < 10){
            binding.tvCurrentTime4.text = "0$hour3:00"
        }
        else{
            binding.tvCurrentTime4.text = "$hour:00"
        }

        val month = (Cal.get(Calendar.MONTH)+1).toString()
        val day = (Cal.get(Calendar.DATE)+1).toString()
        binding.tvTomorrowDate.text = " $month.$day"
        val month2 = (Cal.get(Calendar.MONTH)+1).toString()
        val day2 = (Cal.get(Calendar.DATE)+2).toString()
        binding.tvTomorrowDate2.text = " $month2.$day2"
        val month3 = (Cal.get(Calendar.MONTH)+1).toString()
        val day3 = (Cal.get(Calendar.DATE)+3).toString()
        binding.tvTomorrowDate3.text = " $month3.$day3"
        val month4 = (Cal.get(Calendar.MONTH)+1).toString()
        val day4 = (Cal.get(Calendar.DATE)+4).toString()
        binding.tvTomorrowDate4.text = " $month4.$day4"
        val month5 = (Cal.get(Calendar.MONTH)+1).toString()
        val day5 = (Cal.get(Calendar.DATE)+5).toString()
        binding.tvTomorrowDate5.text = " $month5.$day5"

        binding.tvTomorrow2.text = doDayOfWeek(0).toString()
        binding.tvTomorrow3.text = doDayOfWeek(1).toString()
        binding.tvTomorrow4.text = doDayOfWeek(2).toString()
        binding.tvTomorrow5.text = doDayOfWeek(3).toString()

        return binding.root

    }

    private fun getWeatherData(lat : Double, lon : Double, exclude : String, key : String){
        val weatherInterface = RetrofitClient.sRetrofit.create(WeatherInterface::class.java)
        weatherInterface.getWeather(lat,lon,exclude,key).enqueue(object : Callback<WeatherResponse>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {

                if(response.isSuccessful){
                    val result = response.body() as WeatherResponse
                    binding.tvSubsi.text = (result.current.temp - 273.15).toInt().toString() + "°"
                    binding.tvCurrentTemp.text = (result.current.temp - 273.15).toInt().toString() + "°"

                    when (result.current.weather[0].main) {
                        "Clouds" -> {
                            binding.tvWeatherAbout.text = " 구름많음"
                            binding.ivCurrentWeatherIcon.setImageResource(R.drawable.cloud_icon)
                        }
                        "Clear" -> {
                            binding.tvWeatherAbout.text = " 맑음"
                            binding.ivCurrentWeatherIcon.setImageResource(R.drawable.sun_icon)
                        }
                        "Rain" -> {
                            binding.tvWeatherAbout.text = " 비"
                            binding.ivCurrentWeatherIcon.setImageResource(R.drawable.rain_icon)

                        }
                        "Snow" -> {
                            binding.tvWeatherAbout.text = " 눈"
                            binding.ivCurrentWeatherIcon.setImageResource(R.drawable.snow_icon)
                        }
                    }

                    binding.tvMaxTemp.text = (result.daily[0].temp.min - 273.15).toInt().toString() + "°"
                    binding.tvMinTemp.text = (result.daily[0].temp.max - 273.15).toInt().toString() + "°"

                    binding.tvMaxTemp2.text = (result.daily[1].temp.min - 273.15).toInt().toString() + "°"
                    binding.tvMinTemp2.text = (result.daily[1].temp.max - 273.15).toInt().toString() + "°"

                    binding.tvMaxTemp3.text = (result.daily[2].temp.min - 273.15).toInt().toString() + "°"
                    binding.tvMinTemp3.text = (result.daily[2].temp.max - 273.15).toInt().toString() + "°"

                    binding.tvMaxTemp4.text = (result.daily[3].temp.min - 273.15).toInt().toString() + "°"
                    binding.tvMinTemp4.text = (result.daily[3].temp.max - 273.15).toInt().toString() + "°"

                    binding.tvMaxTemp5.text = (result.daily[4].temp.min - 273.15).toInt().toString() + "°"
                    binding.tvMinTemp5.text = (result.daily[4].temp.max - 273.15).toInt().toString() + "°"

                    when (result.daily[1].weather[0].main) {
                        "Clouds" -> {
                            binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.cloud_icon_small_size)
                        }
                        "Clear" -> {
                            binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.sun_icon_small_size)
                        }
                        "Rain" -> {
                            binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.rain_icon_small_size)

                        }
                        "Snow" -> {
                            binding.ivTomorrowWeatherIcon.setImageResource(R.drawable.snow_icon_small_size)
                        }
                    }
                    when (result.daily[2].weather[0].main) {
                        "Clouds" -> {
                            binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.cloud_icon_small_size)
                        }
                        "Clear" -> {
                            binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.sun_icon_small_size)
                        }
                        "Rain" -> {
                            binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.rain_icon_small_size)

                        }
                        "Snow" -> {
                            binding.ivTomorrowWeatherIcon2.setImageResource(R.drawable.snow_icon_small_size)
                        }
                    }
                    when (result.daily[3].weather[0].main) {
                        "Clouds" -> {
                            binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.cloud_icon_small_size)
                        }
                        "Clear" -> {
                            binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.sun_icon_small_size)
                        }
                        "Rain" -> {
                            binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.rain_icon_small_size)

                        }
                        "Snow" -> {
                            binding.ivTomorrowWeatherIcon3.setImageResource(R.drawable.snow_icon_small_size)
                        }
                    }
                    when (result.daily[4].weather[0].main) {
                        "Clouds" -> {
                            binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.cloud_icon_small_size)
                        }
                        "Clear" -> {
                            binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.sun_icon_small_size)
                        }
                        "Rain" -> {
                            binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.rain_icon_small_size)

                        }
                        "Snow" -> {
                            binding.ivTomorrowWeatherIcon4.setImageResource(R.drawable.snow_icon_small_size)
                        }
                    }
                    when (result.daily[5].weather[0].main) {
                        "Clouds" -> {
                            binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.cloud_icon_small_size)
                        }
                        "Clear" -> {
                            binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.sun_icon_small_size)
                        }
                        "Rain" -> {
                            binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.rain_icon_small_size)

                        }
                        "Snow" -> {
                            binding.ivTomorrowWeatherIcon5.setImageResource(R.drawable.snow_icon_small_size)
                        }
                    }

                    when (result.hourly[1].weather[0].main) {
                        "Clouds" -> {
                            binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.cloud_icon)
                        }
                        "Clear" -> {
                            binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.sun_icon)
                        }
                        "Rain" -> {
                            binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.rain_icon)

                        }
                        "Snow" -> {
                            binding.ivCurrentWeatherIcon2.setImageResource(R.drawable.snow_icon)
                        }
                    }
                    binding.tvCurrentTemp2.text = (result.hourly[1].temp - 273.15).toInt().toString() + "°"

                    when (result.hourly[2].weather[0].main) {
                        "Clouds" -> {
                            binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.cloud_icon)
                        }
                        "Clear" -> {
                            binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.sun_icon)
                        }
                        "Rain" -> {
                            binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.rain_icon)
                        }
                        "Snow" -> {
                            binding.ivCurrentWeatherIcon3.setImageResource(R.drawable.snow_icon)
                        }
                    }
                    binding.tvCurrentTemp3.text = (result.hourly[2].temp - 273.15).toInt().toString() + "°"

                    when (result.hourly[3].weather[0].main) {
                        "Clouds" -> {
                            binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.cloud_icon)
                        }
                        "Clear" -> {
                            binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.sun_icon)
                        }
                        "Rain" -> {
                            binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.rain_icon)
                        }
                        "Snow" -> {
                            binding.ivCurrentWeatherIcon4.setImageResource(R.drawable.snow_icon)
                        }
                    }
                    binding.tvCurrentTemp4.text = (result.hourly[3].temp - 273.15).toInt().toString() + "°"
                }
                else{
                    Log.d("MainActivity", "getWeekWeatherData - onResponse : Error code ${response.code()}")
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("TripToolFragment2", t.message ?: "통신오류")
            }
        })

    }

    private fun doDayOfWeek(n :Int): String? {
        val cal : Calendar = Calendar.getInstance()
        var strWeek :String? = null

        var nWeek = (cal.get(Calendar.DAY_OF_WEEK)+n)
        when(nWeek%7){
            0 -> {
                strWeek = "일"
            }
            1 -> {
                strWeek = "월"
            }
            2 -> {
                strWeek = "화"
            }
            3 -> {
                strWeek = "수"
            }
            4 -> {
                strWeek = "목"
            }
            5 -> {
                strWeek = "금"
            }
            6 -> {
                strWeek = "토"
            }
        }
        return strWeek
    }
   /*private fun getWeatherData(city : String, key : String){
        val testWeatherInterface = TestRetrofitClient.wRetrofit.create(TestWeatherInterface::class.java)
        testWeatherInterface.getWeather(city, key).enqueue(object : Callback<TestResponse> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<TestResponse>, response: Response<TestResponse>) {
                if(response.isSuccessful){
                    val result = response.body() as TestResponse

                   binding.tvSubsi.text = (result.main.temp - 273.15).toInt().toString() + "°"
                    when (result.weather[0].main) {
                        "Clouds" -> {
                            binding.tvWeatherAbout.text = " 구름많음"
                        }
                        "Clear" -> {
                            binding.tvWeatherAbout.text = " 맑음"
                        }
                        "Rain" -> {
                            binding.tvWeatherAbout.text = " 비"
                        }
                        "Snow" -> {
                            binding.tvWeatherAbout.text = " 눈"
                        }
                    }
                }
                else{
                    Log.d("TripToolFragment1", "getWeatherData - onResponse : Error code ${response.code()}")
                }
            }
            override fun onFailure(call: Call<TestResponse>, t: Throwable) {
                Log.d("TripToolFragment1", t.message ?: "통신오류")
            }
        })
    }*/
}