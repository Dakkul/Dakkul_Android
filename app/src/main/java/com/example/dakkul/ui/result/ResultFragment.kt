package com.example.dakkul.ui.result

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dakkul.R
import com.example.dakkul.databinding.FragmentResultBinding
import android.text.SpannableString

import android.text.style.RelativeSizeSpan

import android.text.Spannable

import android.graphics.Typeface

import android.text.style.StyleSpan

import android.text.style.ForegroundColorSpan




class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun textColorSet(){
        val content: String = binding.tvPeople.text.toString()
        val spannableString = SpannableString(content)

        val word = "안드로이드"
        val start = content.indexOf(word)
        val end = start + word.length

        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#FF6702")),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            RelativeSizeSpan(1.3f),
            start,
            end,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.tvPeople.text
    }
}