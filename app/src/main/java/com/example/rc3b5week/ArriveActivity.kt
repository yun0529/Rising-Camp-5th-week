package com.example.rc3b5week

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rc3b5week.databinding.ActivityArriveBinding

private lateinit var binding : ActivityArriveBinding

class ArriveActivity : AppCompatActivity() {
    private val s_data: String = "서울"
    private val j_data: String = "제주"
    private val b_data: String = "부산"
    private val g_data: String = "광주"
    private val c_data: String = "청주"
    private val d_data: String = "대구"
    private val y_data: String = "여수"
    private val yy_data: String = "양양"
    private val p_data: String = "포항"
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityArriveBinding.inflate(layoutInflater)
        val intent = Intent()
        binding.cpArriveInSeoul.setOnClickListener {
            intent.putExtra("Arrive", s_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInJeju.setOnClickListener {
            intent.putExtra("Arrive", j_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInBusan.setOnClickListener {
            intent.putExtra("Arrive", b_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInGwangju.setOnClickListener {
            intent.putExtra("Arrive", g_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInCheongju.setOnClickListener {
            intent.putExtra("Arrive", c_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInDaegu.setOnClickListener {
            intent.putExtra("Arrive", d_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInYeosu.setOnClickListener {
            intent.putExtra("Arrive", y_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInYangyang.setOnClickListener {
            intent.putExtra("Arrive", yy_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpArriveInPohang.setOnClickListener {
            intent.putExtra("Arrive", p_data)
            setResult(RESULT_OK, intent)
            finish()
        }


        setContentView(binding.root)
    }
}