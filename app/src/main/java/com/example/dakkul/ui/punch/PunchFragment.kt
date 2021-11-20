package com.example.dakkul.ui.punch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.dakkul.R
import com.example.dakkul.databinding.FragmentPunchBinding


class PunchFragment : Fragment() {


    lateinit var binding:FragmentPunchBinding
    private val viewModel:PunchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPunchBinding.inflate(inflater,container,false)
        binding.vm = viewModel
        binding.lifecycleOwner=viewLifecycleOwner
        setListeners()
        return binding.root
    }

    private fun setListeners(){
        binding.imgBtnPunchBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnPunchReview.setOnClickListener {
            findNavController().navigate(R.id.action_punchFragment_to_punchReviewFragment)
        }
        binding.imgPunchImage.setOnClickListener {
            viewModel.isClick.value=true

        }

    }

}