package com.geektech.lovecalculator.onBoarding

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentOnBoardingBinding
import com.geektech.lovecalculator.onBoarding.adapter.AdapterOnBoarding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    @Inject
    lateinit var pref: SharedPreferences
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = AdapterOnBoarding(){
            saveSeen()
            findNavController().navigateUp()
        }
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver);
    }
    private fun saveSeen() {
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    companion object {
        const val SEEN_KEY = "seen.key"
    }

}
