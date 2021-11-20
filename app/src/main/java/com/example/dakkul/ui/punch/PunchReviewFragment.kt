package com.example.dakkul.ui.punch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.dakkul.R
import com.example.dakkul.databinding.FragmentPunchBinding
import com.example.dakkul.databinding.FragmentPunchReviewBinding


class PunchReviewFragment : Fragment() {

    lateinit var binding: FragmentPunchReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPunchReviewBinding.inflate(inflater,container,false)
        return binding.root
    }

    fun setListeners(){
        binding.etPunchReview.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })
    }


}