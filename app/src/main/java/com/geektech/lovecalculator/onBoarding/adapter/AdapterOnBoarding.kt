package com.geektech.lovecalculator.onBoarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.ItemOnBoardingBinding
import com.geektech.lovecalculator.ext.loadImage
import com.geektech.lovecalculator.onBoarding.model.OnBoard

class AdapterOnBoarding(private val onClick:()-> Unit) : Adapter<AdapterOnBoarding.OnBoardingViewHolder>() {
    private val data = arrayListOf(
        OnBoard("Have a good time","You should take a time to help those who need you", R.raw.writing),
        OnBoard("Cherishing love","It is no longer possible for you to cherish love", R.raw.time),
        OnBoard("Have a break up?","We have made the correction for you don't worry. Maybe someone is waiting for you!", R.raw.writing)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding): ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {
            with(binding) {
                titleTv.text = onBoard.title
                descTv.text = onBoard.desc
                onBoard.img?.let { binding.lottie.setAnimation(it) }
                btnStart.isVisible = adapterPosition==data.lastIndex
                btnStart.setOnClickListener {
                    onClick()
                }
            }

        }

    }

}