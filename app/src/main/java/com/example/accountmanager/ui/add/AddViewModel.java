package com.example.accountmanager.ui.add;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddViewModel extends ViewModel {

    private MutableLiveData<String> mText;



    public LiveData<String> getText() {
        return mText;
    }
}