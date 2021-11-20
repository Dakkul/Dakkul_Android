package com.example.dakkul.ui.punch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.dakkul.R
import com.example.dakkul.data.RetrofitBuilder
import com.example.dakkul.databinding.FragmentPunchBinding
import com.example.dakkul.databinding.FragmentPunchReviewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PunchReviewFragment : Fragment() {

    lateinit var binding: FragmentPunchReviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPunchReviewBinding.inflate(inflater,container,false)
        setListeners()
        return binding.root
    }

    private fun setListeners(){
        binding.imgBtnPunchReviewBack.setOnClickListener {
            findNavController().navigate(R.id.action_punchReviewFragment_to_homeFragment)
        }

        binding.etPunchReview.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var userinput = binding.etPunchReview.text.toString()
                binding.tvPunchReviewCount.text = userinput.length.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.btnPunchDone.setOnClickListener {
            CoroutineScope(IO).launch {
                val response = RetrofitBuilder.dakkulAPI.setPost(binding.etPunchReview.text.toString(),3)
                withContext(Main){
                    if(response.status==200) {
                        findNavController().navigate(R.id.action_punchReviewFragment_to_resultFragment)
                    }else{

                    }

                }
            }



        }
        binding.btnPunchReturn.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}