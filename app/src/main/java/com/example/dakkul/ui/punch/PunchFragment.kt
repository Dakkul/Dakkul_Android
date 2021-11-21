package com.example.dakkul.ui.punch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.dakkul.R
import com.example.dakkul.databinding.FragmentPunchBinding


class PunchFragment : Fragment() {


    lateinit var binding:FragmentPunchBinding
    private val viewModel:PunchViewModel by activityViewModels()
    private val args by navArgs<PunchFragmentArgs>()

    var isBack=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPunchBinding.inflate(inflater,container,false)
        binding.vm = viewModel
        binding.lifecycleOwner=viewLifecycleOwner

        setListeners()
        setView()
        return binding.root
    }
    private fun setView(){
        binding.tvPunchName.text=args.keyword
        Glide.with(requireContext())
                .load(args.before)
                .into(binding.imgPunchImage)

    }

    private fun setListeners(){
        binding.imgBtnPunchBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnPunchReview.setOnClickListener {
            findNavController().navigate(PunchFragmentDirections.actionPunchFragmentToPunchReviewFragment(args.after))
        }
        binding.imgPunchImage.setOnClickListener {
            if(isBack==true) {
                Glide.with(requireContext())
                        .load(args.before)
                        .into(binding.imgPunchImage)
                isBack=false
            }else{
                Glide.with(requireContext())
                        .load(args.after)
                        .into(binding.imgPunchImage)
                isBack=true
            }

            viewModel.isClick.value=true

        }

    }

}