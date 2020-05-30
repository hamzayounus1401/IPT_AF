package com.example.ipt_aa;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ipt_aa.ui.send.SendFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class NavigationDrawer extends AppCompatActivity implements MyFirebaseMessagingService.marks, SendFragment.marks {

    private AppBarConfiguration mAppBarConfiguration;
    TextView marks;
    TextView name;
    TextView email;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        sessionManager = new SessionManager(getApplication());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(NavigationDrawer.this, drawer, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        name = navigationView.getHeaderView(0).findViewById(R.id.nav_profile_name);
        email = navigationView.getHeaderView(0).findViewById(R.id.nav_profile_id);

        name.setText(sessionManager.getUserRoll());
        email.setText("");
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //These lines should be added in the OnCreate() of your main activity
        marks = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.nav_send));
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        MyFirebaseMessagingService.setOnEventListener(this);

        SendFragment.setOnEventListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        sessionManager.checkLogin();
    }


    @Override
    public void onEvent(boolean is) {
        if (is == true) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    marks.setTextColor(getResources().getColor(R.color.colorAccent));
                    marks.setText("1+");
                    marks.setGravity(Gravity.CENTER_VERTICAL);
                }
            });

        }
        if (is == false) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    marks.setTextColor(getResources().getColor(R.color.colorAccent));
                    marks.setText("");
                    marks.setGravity(Gravity.CENTER_VERTICAL);
                }
            });

        }

    }


}
