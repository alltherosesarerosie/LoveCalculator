package com.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.geektech.lovecalculator.databinding.FragmentFirstBinding
import com.geektech.lovecalculator.viewmodel.LoveViewModel
import retrofit2.Callback
import retrofit2.Response

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

                viewModel.getLiveLove(firstEt.text.toString(), secondEt.text.toString())
                    .observe(viewLifecycleOwner, Observer { loveModel ->
                        Log.e("astra", "onResponse: $loveModel")
                        val b = Bundle()
                        b.putSerializable("love", loveModel)
                        val ans = AnswerFragment()
                        val fragmentTransaction: FragmentTransaction =
                            activity?.supportFragmentManager?.beginTransaction()!!
                        ans.arguments = b
                        fragmentTransaction.addToBackStack(null)
                        fragmentTransaction.replace(R.id.fragment_container, ans)
                        fragmentTransaction.commit()
                    })
            }
        }
    }

}