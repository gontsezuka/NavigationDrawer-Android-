package com.zukalover.navigationdraweraugust;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{ //IMPLEMENT FOR ONCLIK

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        /**
         * FOR ONCLICK
         */
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();//TOGGLE ROTATION


        /**
         * FOR ONCLICK
         * WHEN WE FIRST START APP IT SHOULD SHOW 1 FRAGMENT
         */

        //OVERRIEDE ACTIVITY RECREATION
        if(savedInstanceState == null) {


            //END OVERRIDE

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
            /**
             * SELECT FIRST ITEM
             */
            navigationView.setCheckedItem(R.id.nav_message); //
        }
    }

    /**
     * For onclik=ck
     * @param menuItem
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatFragment()).commit();
                break;
            case R.id. nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this,"Shared", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.nav_send:
                Toast.makeText(this,"Sent",Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * For pressing the back button to close nav drawer
     *
     */
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}