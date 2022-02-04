package com.example.rc3b5week

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.rc3b5week.databinding.ItemTourBinding
import com.google.android.material.internal.ContextUtils.getActivity

private lateinit var binding: ItemTourBinding

class TourAdapter(private val context: Context, private val tourList: ArrayList<Tour>) : BaseAdapter() {
    var activity : TripActivity? = TripActivity()
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = tourList.size

    override fun getItem(p0: Int): Any = tourList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    @SuppressLint("RestrictedApi")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        binding = ItemTourBinding.inflate(inflater, p2, false)

        binding.tvTourItemName.text = tourList[p0].name
        binding.tvTourItemIntro.text = tourList[p0].intro
        binding.tvTourItemWhere.text = tourList[p0].where
        Glide.with(context).load(tourList[p0].photo).into(binding.ivTourItemThumbnail)
        binding.cbLike.isChecked = tourList[p0].checked
        binding.cbLike.setOnCheckedChangeListener { CompoundButton, onSwitch ->
            tourList[p0].checked = onSwitch
        }
        binding.clTourItemLayout.setOnClickListener {
            activity = getActivity(context) as TripActivity
            activity!!.onFragmentChange(2)
        }

        return binding.root
    }
}