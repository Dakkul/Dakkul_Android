package com.example.dakkul.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dakkul.R
import com.example.dakkul.data.Story
import com.example.dakkul.databinding.FragmentHomeBinding
import com.example.dakkul.ui.home.adapter.HomeRVAdapter

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeRVAdapter: HomeRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        initAdapter()
    }

    private fun initAdapter() {
        val testList = listOf<Int>()
        homeRVAdapter = HomeRVAdapter()
        homeRVAdapter.itemList.addAll(
            listOf(
                Story("","","", testList),
                Story("","","", testList),
                Story("","","", testList),
                Story("","","", testList)
            )
        )
        binding.rvHomeTargetList.adapter = homeRVAdapter
    }
}