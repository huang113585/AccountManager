package com.example.accountmanager.ui.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.Bean.User;
import com.example.accountmanager.R;
import com.example.activity.Login;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

public class PersonFragment extends Fragment {

    private PersonViewModel dashboardViewModel;
    private ConstraintLayout constraintLayout4,constraintLayout5,constraintLayout6,
            constraintLayout7,constraintLayout8;
    private TextView textView5;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_person, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        //加载我的信息
       getMyinfo();
       constraintLayout8.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               BmobUser bmobUser = BmobUser.getCurrentUser(BmobUser.class);
               BmobUser.logOut();
               startActivity(new Intent(getActivity(), Login.class));
               getActivity().finish();
           }
       });
    }

    private void getMyinfo() {
        BmobUser bu = BmobUser.getCurrentUser(BmobUser.class);
        String Id = bu.getObjectId();
        BmobQuery<User> bmobQuery = new BmobQuery<>();
        bmobQuery.getObject(Id, new QueryListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null){
                    textView5.setText(user.getUsername());
                }else {
                    Toast.makeText(getActivity(),"加载失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        textView5 = getActivity().findViewById(R.id.textView5);
        constraintLayout8 = getActivity().findViewById(R.id.constraintLayout8);
    }
}