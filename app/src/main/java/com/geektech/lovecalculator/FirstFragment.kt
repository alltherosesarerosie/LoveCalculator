package com.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentFirstBinding
import com.geektech.lovecalculator.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Callback
import retrofit2.Response

@AndroidEntryPoint
class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            btnCalc.setOnClickListener {
                viewModel.getLiveLove( firstName = firstEt.text.toString(), secondName = secondEt.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        findNavController().navigate(R.id.answerFragment, bundleOf("love" to it))
                    })
            }
        }
    }

}