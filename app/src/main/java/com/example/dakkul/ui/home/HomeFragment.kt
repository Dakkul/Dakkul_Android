package com.example.dakkul.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dakkul.R
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
        homeRVAdapter = HomeRVAdapter()
//        homeRVAdapter.itemList.addAll(
//            listOf(
//                Product("와이셔츠", 1800),
//                Product("교복셔츠", 1800),
//                Product("일반셔츠, 블라우스", 3000),
//                Product("티셔츠", 3000),
//                Product("맨투맨, 후드티", 4000),
//                Product("니트 스웨터, 가디건", 3500),
//                Product("바지, 스커트", 6000),
//                Product("원피스, 점프수트", 6000),
//                Product("스키/보드바지, 패딩바지", 10900),
//                Product("인조가죽 하의", 10900),
//                Product("정장자켓, 교복자켓", 4000),
//                Product("조끼", 2000),
//                Product("자켓, 점퍼", 6000),
//                Product("코트, 트렌치코트", 12000),
//                Product("대형러그", 30000),
//                Product("커튼", 15000),
//                Product("대형커튼", 30000),
//                Product("발매트", 3000),
//                Product("쇼파커버", 8000),
//                Product("애견쿠션", 25000),
//                Product("애견의류", 7000),
//                Product("무릎담요", 5000),
//                Product("인형", 7000),
//                Product("대형인형", 20000),
//                Product("앞치", 4000)
//            )
//        )
        binding.rvHomeTargetList.adapter = homeRVAdapter
    }
}