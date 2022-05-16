package com.example.voiceofbangladesh;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);


        NavigationView navigationView = findViewById(R.id.nav_view);
        // make navigation icon in real image
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home_Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Home_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_emergency:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Emergency_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_report:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Report_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_govinfot:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Govinfo_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_feedback:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Feedback_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_settings:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Settings_Fragment()).commit();
                Intent intent = new Intent(Home.this,SettingsActivity.class);
                startActivity(intent);

                break;
            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Help_Fragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_share:
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
              //  shareintent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/app/details?id= ");
                shareintent.setType("text/plain");
                startActivity(Intent.createChooser(shareintent,"share vai"));
                break;
            case R.id.nav_exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure? You want to Exit.")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}