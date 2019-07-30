package info.ndakgamers.mhwguide;


import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import java.io.IOException;


public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment fragment = null;
    private FragmentManager fragmentManager;

    DatabaseHelper myDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Opening Database
//        DatabaseHelper myDbHelper = new DatabaseHelper(Home.this);
        myDbHelper = DatabaseHelper.getInstance(Home.this);

        // Creating Database if not there
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        // Drawer Info
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Navigation Info
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        // Show Home method
//        getHome();

        // Navigation Method
//        displayView(R.id.nav_large_monsters);

        // Default Home Fragment
        String title = getString(R.string.large_monsters_title);
        Large_Monsters fragment = new Large_Monsters();

        if (fragment != null) {
            FragmentManager fragmentMgmt = getSupportFragmentManager();
            fragmentMgmt.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

    }

    @Override
    public void onBackPressed() {
        // Pressing back popped the back stack, nothing else to do
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (!fragmentManager.isStateSaved() && fragmentManager.popBackStackImmediate()) {
            return;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }

//        if (!viewIsAtHome) {
//                displayView(R.id.nav_large_monsters);
//            }
            else {
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Home.this.finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
         }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    private void getHome(){
        fragment = new Large_Monsters();
        if (fragment != null) {
            FragmentManager fragmentMgmt = getSupportFragmentManager();
            fragmentMgmt.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displayView(item.getItemId());
        return true;

    }



    public void displayView(int viewId) {

        boolean viewIsAtHome;

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (viewId) {
            default:
                fragment = new Large_Monsters();
                title  = "Large Monsters";
                break;

            case R.id.nav_large_monsters:
                fragment = new Large_Monsters();
                title  = "Large Monsters";
                viewIsAtHome = true;
                break;

            case R.id.nav_small_monsters:
                fragment = new Small_Monsters();
                title = "Small Monsters";
                viewIsAtHome = false;
                break;

            case R.id.nav_weapons:
                fragment = new Weapons();
                title = "Weapons";
                viewIsAtHome = false;
                break;

            case R.id.nav_armors:
                fragment = new Armors_Low_High();
                title = "Armor Sets";
                viewIsAtHome = false;
                break;

            case R.id.nav_charms:
                fragment = new Charms();
                title = "Charms";
                viewIsAtHome = false;
                break;

            case R.id.nav_items:
                fragment = new Items_Recycler();
                title = "Items";
                viewIsAtHome = false;
                break;

            case R.id.palico_armor:
                fragment = new Palico_Armor();
                title = "Palico Armor";
                viewIsAtHome = false;
                break;

            case R.id.palico_gadgets:
                fragment = new Palico_Gadgets();
                title = "Palico Gadgets";
                viewIsAtHome = false;
                break;

            case R.id.palico_weps:
                fragment = new Palico_Weapons();
                title = "Palico Weapons";
                viewIsAtHome = false;
                break;

            case R.id.palico_helms:
                fragment = new Palico_Helms();
                title = "Palico Helmets";
                viewIsAtHome = false;
                break;

        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment, "TAG");
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.addToBackStack(null);
                    ft.commit();

//            getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//                @Override
//                public void onBackStackChanged() {
//                    Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("TAG");
//                    if (currentFragment instanceof ??? );{
//
//                    }
//                }
//            });
        }

        // set the toolbar title
       if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}