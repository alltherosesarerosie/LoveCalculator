package com.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.geektech.lovecalculator.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
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
                LoveService().api.calculatePerc(
                    firstName = firstEt.text.toString(),
                    secondName =  secondEt.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful){
                            Log.e("astra", "onResponse: ${response.body()}")
                            val love = response.body()
                            val b = Bundle()
                            b.putSerializable("love", love)
                            val ans = AnswerFragment()
                            val fragmentTransaction: FragmentTransaction =
                                activity?.supportFragmentManager?.beginTransaction()!!
                            ans.arguments = b
                            fragmentTransaction.addToBackStack(null)
                            fragmentTransaction.replace(R.id.fragment_container, ans)
                            fragmentTransaction.commit()
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("astra", "${t.message}")
                    }
                })
            }
        }
    }

}