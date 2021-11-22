package com.example.dakkul.ui.punch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PunchViewModel:ViewModel() {



    val isClick=MutableLiveData<Boolean>()
    val isEdit=MutableLiveData<Boolean>()

    init{
        isClick.value=false
        isEdit.value=false
    }
}