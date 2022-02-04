package com.example.rc3b5week

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rc3b5week.databinding.ItemFlBinding
import com.example.rc3b5week.databinding.ItemFooterBinding
import com.example.rc3b5week.databinding.ItemHeaderBinding

private lateinit var binding:ItemFlBinding
private lateinit var headerBinding:ItemHeaderBinding
private lateinit var footerBinding:ItemFooterBinding

class FlightAdapter(private val dataSet: ArrayList<flightData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER = 0
    private val TYPE_ITEM = 1
    private val TYPE_FOOTER = 2

    //private val listData: ArrayList<flightData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == TYPE_HEADER){
            headerBinding = ItemHeaderBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            return HeaderViewHolder(headerBinding)
        }
        else if(viewType == TYPE_FOOTER){
            footerBinding = ItemFooterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            return FooterViewHolder(footerBinding)
        }
        else{
            binding = ItemFlBinding.inflate(LayoutInflater.from(parent.context),parent, false)
            return ViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is HeaderViewHolder -> holder.bind()
            is ViewHolder -> holder.bind(dataSet[position - 1])
            is FooterViewHolder -> holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                TYPE_HEADER
            }
            dataSet.size + 1 -> {
                TYPE_FOOTER
            }
            else -> {
                TYPE_ITEM
            }
        }
    }
    override fun getItemCount(): Int {
        return dataSet.size + 2
    }
    
    fun addItem(a: Int, b:String, c:String, d:String, e:String, f:String, g:String, h:String) {
            dataSet.add(flightData(a,b,c,d,e,f,g,h))
    }

    class ViewHolder(private val binding: ItemFlBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : flightData) {
            binding.ivFlItemLogo.setImageResource(data.logo)
            binding.tvFlItemTimeStart.text = data.time_start
            binding.tvFlItemTimeEnd.text = data.time_end
            binding.tvFlItemGo.text = data.go
            binding.tvFlItemArrive.text = data.arrive
            binding.tvFlItemName.text = data.name
            binding.tvFlItemHowlong.text = data.howlong
            binding.tvFlItemPrice.text = data.price
        }
    }
    class HeaderViewHolder(private val headerBinding: ItemHeaderBinding) : RecyclerView.ViewHolder(headerBinding.root) {
        fun bind() {
            //headerBinding.tvHeaderDate.text = headerData.h_date
           // headerBinding.tvHeaderCount.text = headerData.h_count
        }
    }
    class FooterViewHolder(private val footerBinding: ItemFooterBinding) : RecyclerView.ViewHolder(footerBinding.root) {
        fun bind() {
        }
    }
}