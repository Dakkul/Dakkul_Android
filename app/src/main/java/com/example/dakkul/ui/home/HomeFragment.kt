package com.example.dakkul.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.example.dakkul.data.Story
import com.example.dakkul.databinding.FragmentHomeBinding
import com.example.dakkul.ui.home.adapter.HomeRVAdapter
import com.example.dakkul.ui.story.StoryDialogFragment
import com.google.android.material.chip.Chip

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeRVAdapter: HomeRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        initAdapter()

        binding.cgHomeTag.children.forEach {
            (it as Chip).setOnCheckedChangeListener { buttonView, isChecked ->
                if (it.id != binding.chipHomeAll.id) {
                    if (binding.chipHomeAll.isChecked) {
                        binding.chipHomeAll.isChecked = false
                    }
                    if(binding.cgHomeTag.checkedChipIds.size > 3) {
                        it.isChecked = false
                    }
                } else {
                    if (binding.chipHomeAll.isChecked) {
                        binding.cgHomeTag.clearCheck()
                        binding.cgHomeTag.check(binding.chipHomeAll.id)
                    }
                }
            }
        }
    }

    private fun initAdapter() {
        val testList = listOf<Int>()
        homeRVAdapter = HomeRVAdapter()
        homeRVAdapter.itemList.addAll(
            listOf(
                // 서버에서 data 받아 와서 추가
                Story("", "", "", testList),
                Story("", "", "", testList),
                Story("", "", "", testList),
                Story("", "", "", testList)
            )
        )
        homeRVAdapter.setItemClickListener(object :HomeRVAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                StoryDialogFragment(id).show(
                    parentFragmentManager,  "StoryDialogFragment"
                )
            }
        })

        binding.rvHomeTargetList.adapter = homeRVAdapter
    }
}