package com.example.dakkul.ui.punch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dakkul.R
import com.example.dakkul.databinding.FragmentPunchBinding


class PunchFragment : Fragment() {


    lateinit var binding:FragmentPunchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPunchBinding.inflate(inflater,container,false)

        return binding.root
    }

}