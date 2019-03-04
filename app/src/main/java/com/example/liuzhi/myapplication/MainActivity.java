package com.example.liuzhi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.jceterlibrary.MylibClass;
import com.example.jceterlibrary.ToastUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MylibClass mylibClass = new MylibClass();

        mylibClass.name = "TestJceter";

        ToastUtil.showToast(this, mylibClass.name);
    }
}
