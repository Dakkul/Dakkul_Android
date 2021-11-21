package com.example.dakkul.ui.story

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.dakkul.R
import com.example.dakkul.data.DakkulAPI
import com.example.dakkul.data.RetrofitBuilder
import com.example.dakkul.data.detail.response.ResponseDetail
import com.example.dakkul.databinding.FragmentStoryDialogBinding
import com.example.dakkul.ui.home.HomeFragmentDirections
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoryDialogFragment(id: Int) : DialogFragment() {
    private var _binding: FragmentStoryDialogBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다")

    var did =id
    var before=""
    var after=""
    var keyword=""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoryDialogBinding.inflate(layoutInflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        exitDialog()
        clickButton()
        initNetwork(did)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun exitDialog(){
        binding.ivQuit.setOnClickListener {
            dismiss()
        }
    }

    private fun clickButton(){
        binding.btnRevenge.setOnClickListener {
            dismiss()

            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPunchFragment(before,after,keyword))
        }
    }
    private fun initNetwork(id_ : Int){
        Log.d("asdf",id_.toString())
        val call: Call<ResponseDetail> = RetrofitBuilder.dakkulAPI.getDetail(id_)

        call.enqueue(object : Callback<ResponseDetail> {
            override fun onResponse(
                call: Call<ResponseDetail>,
                response: Response<ResponseDetail>
            ) {
                Log.d("NetworkTest","onResponse")
                if(response.isSuccessful){
                    Log.d("NetworkData", "response success")
                    response.body()?.let{

                        Glide.with(binding.ivGraphic.context)
                            .load(it.data.imageBefore)
                            .into(binding.ivGraphic)

                        Glide.with(binding.ivWanted.context)
                            .load(it.data.imageWanted)
                            .into(binding.ivWanted)

                        before=it.data.imageBefore
                        after=it.data.imageAfter
                        keyword=it.data.keyword

                        binding.tvStory.text = it.data.description
                        binding.tvTitle.text = it.data.title
                    }
                } else{ Log.d("NetworkTest","response failed") }
            }

            override fun onFailure(call: Call<ResponseDetail>, t: Throwable) {
                Log.e("NetworkTest","error:$t")
            }

        })
    }
}