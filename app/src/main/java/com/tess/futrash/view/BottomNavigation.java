package com.tess.futrash.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tess.futrash.R;
import com.tess.futrash.view.fragment.ChartFragment;
import com.tess.futrash.view.fragment.ConfirmFragment;
import com.tess.futrash.view.fragment.LandingPageFragment;
import com.tess.futrash.view.fragment.OrderFragment;

public class BottomNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        //Menampilkan halaman Fragment yang pertama kali muncul
        getFragmentPage(new LandingPageFragment());

        /*Inisialisasi BottomNavigationView beserta listenernya untuk
         *menangkap setiap kejadian saat salah satu menu item diklik
         */
        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.all_food:
                        fragment = new LandingPageFragment();
                        break;

                    case R.id.save_:
                        fragment = new ChartFragment();
                        break;

                    case R.id.order:
                        fragment = new OrderFragment();
                        break;

                    case R.id.confirm:
                        fragment = new ConfirmFragment();
                        break;

                }
                return getFragmentPage(fragment);
            }
        });
    }

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}