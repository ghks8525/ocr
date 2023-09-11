package com.test.ocr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.test.ocr.databinding.ActivityInsuranceBinding
import com.test.ocr.databinding.ActivityMainBinding
import com.test.ocr.databinding.ViewInsuranceBinding
import com.test.ocr.dto.Insurance

class InsuranceActivity :AppCompatActivity() {
    lateinit var mBinding: ActivityInsuranceBinding
    // When using Latin script library
    val insurance = ArrayList<Insurance>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_insurance)
        insurance.add(Insurance("현대해상"))
        insurance.add(Insurance("한화손해보험"))

        mBinding.aiRvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        mBinding.aiRvList.adapter = Adapter(insurance){
            mBinding.aiRvList.forEach {

            }
        }
        mBinding.aiBtnNext.setOnClickListener {
        }
    }


    inner class Adapter(val arr: ArrayList<Insurance>, val clickListener: (() -> Unit)) : RecyclerView.Adapter<Adapter.ViewHolder>() {
        inner class ViewHolder(val binding: ViewInsuranceBinding) : RecyclerView.ViewHolder(binding.root) {
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ViewInsuranceBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ViewHolder(binding)
        }

        override fun getItemCount(): Int = arr.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.sel = arr[position].sel
            holder.binding.viTvName.text = arr[position].name

            holder.binding.root.setOnClickListener {
                clickListener()
                if(arr[position].sel){
                    arr[position].sel = !arr[position].sel
                }else{
                    arr.forEach {
                        it.sel = false
                    }
                }
                arr[position].sel = true
                notifyDataSetChanged()
            }
        }


    }


}