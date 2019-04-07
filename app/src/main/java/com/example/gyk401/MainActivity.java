package com.example.gyk401;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    HealthFragment healthFragment;
    DietFragment dietFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.BottomNav);
        homeFragment = new HomeFragment();
        healthFragment = new HealthFragment();
        dietFragment = new DietFragment();

        setFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.homeitem:
                        setFragment(homeFragment);
                        return true;
                    case R.id.healthitem:
                        setFragment(healthFragment);
                        return true;
                    case R.id.dietitem:
                        setFragment(dietFragment);
                        return true;
                    default:
                        return false;
                }
            }
        });


    }

    public void setFragment(Fragment f)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.MainFrame,f);
        ft.commit();
    }


}
