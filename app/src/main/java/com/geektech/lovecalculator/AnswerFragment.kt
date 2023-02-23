package com.geektech.lovecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.lovecalculator.databinding.FragmentAnswerBinding

class AnswerFragment : Fragment() {
    lateinit var binding: FragmentAnswerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAnswerBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ans = arguments?.getSerializable("love") as LoveModel
        binding.fName.text = ans.firstName
        binding.sName.text = ans.secondName
        binding.result.text = ans.persentage+"%"
    }


}