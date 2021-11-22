package com.example.dakkul.ui.punch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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
    private val args by navArgs<PunchFragmentArgs>()
    private val viewModel:PunchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPunchReviewBinding.inflate(inflater,container,false)
        binding.vm=viewModel
        binding.lifecycleOwner=viewLifecycleOwner
        setListeners()
        setview()
        return binding.root
    }
    private fun setview(){
        Glide.with(requireContext())
                .load(args.after)
                .into(binding.imgPunchImage)
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
                viewModel.isEdit.value = userinput.isNotEmpty()

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        binding.btnPunchDone.setOnClickListener {
            /*CoroutineScope(IO).launch {
                val response = RetrofitBuilder.dakkulAPI.setPost(binding.etPunchReview.text.toString(),1)
                withContext(Main){
                    if(response.status==200) {
                        findNavController().navigate(PunchFragmentDirections.actionPunchFragmentToPunchReviewFragment(args.after))
                    }else{

                    }

                }
            }*/

            findNavController().navigate(PunchReviewFragmentDirections.actionPunchReviewFragmentToResultFragment(args.after))
        }
        binding.btnPunchReturn.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}