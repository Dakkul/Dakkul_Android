package com.example.dakkul.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dakkul.data.RetrofitBuilder
import com.example.dakkul.data.StoryRequest
import com.example.dakkul.data.StoryResponse
import com.example.dakkul.databinding.FragmentHomeBinding
import com.example.dakkul.ui.home.adapter.HomeRVAdapter
import com.example.dakkul.ui.story.StoryDialogFragment
import com.example.dakkul.ui.story.StoryDialogFragmentDirections
import com.google.android.material.chip.Chip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeRVAdapter: HomeRVAdapter
    private var tags = mutableListOf<Int>()

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
                if (it.id != binding.chipHomeAll.id) { // 나머지
                    if (binding.chipHomeAll.isChecked) { // 전체 체크 제거
                        binding.chipHomeAll.isChecked = false
                    }
                    if (binding.cgHomeTag.checkedChipIds.size > 3) { // 3개 이상이면 체크 안되게
                        it.isChecked = false
                    } else {
                        for (i in 0..binding.cgHomeTag.size) {
                            if (it.id == binding.cgHomeTag.getChildAt(i).id) {
                                if (it.isChecked) {
                                    tags.add(i)
                                } else {
                                    tags.remove(i)
                                    if(tags.size==0){
                                        binding.chipHomeAll.isChecked = true
                                    }
                                }
                                Log.d("testt", tags.toString())
                                initTagAPI()
                                break
                            }
                        }
                    }

                } else { // all
                    if (binding.chipHomeAll.isChecked) {
                        tags.clear()
                        binding.cgHomeTag.clearCheck()
                        binding.cgHomeTag.check(binding.chipHomeAll.id)
                        initAPI()
                    }
                }
            }
        }
    }

    private fun initTagAPI() {

        val call: Call<StoryResponse> = RetrofitBuilder.dakkulAPI.getTag(StoryRequest(tags))
        call.enqueue(object : Callback<StoryResponse> {
            override fun onResponse(
                call: Call<StoryResponse>,
                response: Response<StoryResponse>,
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    if (data != null) {
                        homeRVAdapter.itemList.clear()
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

    private fun initAdapter() {

        homeRVAdapter = HomeRVAdapter()

        initAPI()
        homeRVAdapter.setItemClickListener(object : HomeRVAdapter.ItemClickListener {
            override fun onClick(view: View, position: Int) {
                StoryDialogFragment(position + 1).show(
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
                        homeRVAdapter.itemList.clear()
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