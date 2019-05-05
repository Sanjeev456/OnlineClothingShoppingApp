package com.example.onlineclothingshoppingapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragments.LoginActivity;
import fragments.RegisterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Boolean status = true;
    private Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (status){
            LoginActivity loginActivity = new LoginActivity();
            fragmentTransaction.replace(R.id.fragmentContainer,loginActivity);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnLoad.setText("Register");
            status = false;

        }else{
            RegisterActivity registerActivity = new RegisterActivity();
            fragmentTransaction.replace(R.id.fragmentContainer,registerActivity);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btnLoad.setText("Login");
            status = true;
        }
    }
}
