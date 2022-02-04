package com.example.rc3b5week

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rc3b5week.databinding.ActivityGoBinding
import android.content.Intent




private lateinit var binding : ActivityGoBinding

class GoActivity : AppCompatActivity() {
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
        binding = ActivityGoBinding.inflate(layoutInflater)
        val intent = Intent()
        binding.cpGoInSeoul.setOnClickListener {
            intent.putExtra("Go", s_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInJeju.setOnClickListener {
            intent.putExtra("Go", j_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInBusan.setOnClickListener {
            intent.putExtra("Go", b_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInGwangju.setOnClickListener {
            intent.putExtra("Go", g_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInCheongju.setOnClickListener {
            intent.putExtra("Go", c_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInDaegu.setOnClickListener {
            intent.putExtra("Go", d_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInYeosu.setOnClickListener {
            intent.putExtra("Go", y_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInYangyang.setOnClickListener {
            intent.putExtra("Go", yy_data)
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.cpGoInPohang.setOnClickListener {
            intent.putExtra("Go", p_data)
            setResult(RESULT_OK, intent)
            finish()
        }

        setContentView(binding.root)
    }
}