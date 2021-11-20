package com.example.dakkul.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.example.dakkul.data.RetrofitBuilder
import com.example.dakkul.data.Story
import com.example.dakkul.data.StoryResponse
import com.example.dakkul.databinding.FragmentHomeBinding
import com.example.dakkul.ui.home.adapter.HomeRVAdapter
import com.example.dakkul.ui.story.StoryDialogFragment
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                    if (binding.cgHomeTag.checkedChipIds.size > 3) {
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

        homeRVAdapter = HomeRVAdapter()

        initAPI()
        homeRVAdapter.setItemClickListener(object : HomeRVAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                StoryDialogFragment(position).show(
                    parentFragmentManager, "StoryDialogFragment"
                )
            }
        })

        binding.rvHomeTargetList.adapter = homeRVAdapter
    }

    private fun initAPI() {
        val call: Call<StoryResponse> = RetrofitBuilder.dakkulAPI.getStory()

        call.enqueue(object : Callback<StoryResponse> {
            override fun onResponse(
                call: Call<StoryResponse>,
                response: Response<StoryResponse>,
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    if (data != null) {
                        homeRVAdapter.itemList.addAll(
                            data
                        )
                    }
                    homeRVAdapter.notifyDataSetChanged()
                } else {

                }
            }

            override fun onFailure(call: Call<StoryResponse>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }
}