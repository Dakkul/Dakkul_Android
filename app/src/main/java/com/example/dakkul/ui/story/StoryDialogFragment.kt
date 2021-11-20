package com.example.dakkul.ui.story

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import com.example.dakkul.R
import com.example.dakkul.databinding.FragmentStoryDialogBinding

class StoryDialogFragment(id: Int) : DialogFragment() {
    private var _binding: FragmentStoryDialogBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 화면 밖 터치 시 종료 막음
        isCancelable = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoryDialogBinding.inflate(layoutInflater, container, false)

        exitDialog()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRevenge.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.punchFragment, null)
        }
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
}