package com.example.root.villupuramglug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.root.villupuramglug.fragment.AboutFragment;
import com.example.root.villupuramglug.fragment.ActivityFragment;
import com.example.root.villupuramglug.fragment.ContactFragment;
import com.example.root.villupuramglug.fragment.GlugsFragment;
import com.example.root.villupuramglug.fragment.MainFragment;
import com.example.root.villupuramglug.fragment.TutorialsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        final String now_playing = i.getStringExtra("now_playing");
        final String earned = i.getStringExtra("earned");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Toast.makeText(getApplicationContext(),"Now Playing : " + now_playing,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Earned : " + earned,Toast.LENGTH_SHORT).show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        disPlaySelectedScreen(R.id.nav_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_main) {

        } else if (id == R.id.nav_activity) {
        } else if (id == R.id.nav_tutorials) {
        }
        disPlaySelectedScreen(id);
        return true;
    }


    private void disPlaySelectedScreen(int id)
    {
        Fragment fragment = null;
        switch (id)
        {
            case R.id.nav_main:
                Bundle bundle = new Bundle();
                bundle.putString("val", "From Activity");
                fragment = new MainFragment();
                fragment.setArguments(bundle);

                break;

            case R.id.nav_activity:
                fragment = new ActivityFragment();
                break;

            case R.id.nav_tutorials:
                fragment = new TutorialsFragment();
                break;
            case R.id.nav_glugs:
                fragment = new GlugsFragment();
                break;
            case R.id.nav_contact:
                fragment = new ContactFragment();
                break;
            case R.id.nav_about:
                fragment = new AboutFragment();
                break;

        }

        if(fragment != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }








}
