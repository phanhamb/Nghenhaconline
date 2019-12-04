package com.hamb.nghenhacmp3online.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.hamb.nghenhacmp3online.Adapter.MainViewPageAdapter;
import com.hamb.nghenhacmp3online.Fragment.Fragment_Timkiem;
import com.hamb.nghenhacmp3online.Fragment.Fragment_Trangchu;
import com.hamb.nghenhacmp3online.R;

public class MainActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init(){
        MainViewPageAdapter mainViewPageAdapter = new MainViewPageAdapter(getSupportFragmentManager());
        mainViewPageAdapter.addFragment(new Fragment_Trangchu(),"Trang Chủ");
        mainViewPageAdapter.addFragment(new Fragment_Timkiem(),"Tìm Kiếm");
        viewPager.setAdapter(mainViewPageAdapter);
        tablayout.setupWithViewPager(viewPager);
    }

    private void anhxa(){
        tablayout = (TabLayout) findViewById(R.id.mytablayout);
        viewPager = (ViewPager) findViewById(R.id.myviewpage);

    }
}
