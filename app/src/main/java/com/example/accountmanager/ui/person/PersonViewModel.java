package com.example.accountmanager.ui.person;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PersonViewModel extends ViewModel {

    private MutableLiveData<String> mText;



    public LiveData<String> getText() {
        return mText;
    }
}