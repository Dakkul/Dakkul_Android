package com.example.dakkul.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.dakkul.R
import com.example.dakkul.data.RetrofitBuilder
import com.example.dakkul.databinding.FragmentResultBinding
import com.example.dakkul.ui.punch.PunchFragmentArgs
import kotlinx.coroutines.*

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다")

    private val args by navArgs<ResultFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        setView()
        btnClickSet()
        return binding.root
    }

    private fun setView(){
        Glide.with(requireContext())
                .load(args.after)
                .into(binding.imageView13)
        /*CoroutineScope(Dispatchers.IO).launch {
            val response = RetrofitBuilder.dakkulAPI.getResult(1)
            withContext(Dispatchers.Main){
                if(response.status==200) {
                    binding.tv8.text=response.data[3].content

                    //findNavController().navigate(R.id.action_punchReviewFragment_to_resultFragment)
                }else{

                }

            }
        }*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun btnClickSet(){
        binding.ivRevengeEnd.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }
    }
}