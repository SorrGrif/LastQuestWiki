package comsorrgriflastquestwiki.github.lastquestwiki;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
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

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        contactFragment.OnFragmentInteractionListener,
        classesFragment.OnFragmentInteractionListener,
        racesFragment.OnFragmentInteractionListener,
        faqFragment.OnFragmentInteractionListener,
        puzzleFragment.OnFragmentInteractionListener,
        tutorialFragment.OnFragmentInteractionListener,
        tipsFragment.OnFragmentInteractionListener,
        tipContentFragment.OnFragmentInteractionListener,
        itemsFragment.OnFragmentInteractionListener,
        humanFragment.OnFragmentInteractionListener,
        elfFragment.OnFragmentInteractionListener,
        dwarfFragment.OnFragmentInteractionListener,
        hobbitFragment.OnFragmentInteractionListener,
        archerFragment.OnFragmentInteractionListener,
        barbarianFragment.OnFragmentInteractionListener,
        wizardFragment.OnFragmentInteractionListener,
        fighterFragment.OnFragmentInteractionListener,
        welcomeFragment.OnFragmentInteractionListener,
        languageFragment.OnFragmentInteractionListener{


    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this retrieves the users set language
        SharedPreferences pref = getPreferences(Context.MODE_APPEND);
        String lang = pref.getString("lang", "en");
        getResources().getConfiguration().locale = new Locale(lang);
        getResources().updateConfiguration(getResources().getConfiguration(), getResources().getDisplayMetrics());

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //if theres no saved instant state, set to the default welcome frag
        //this makes it so when you rotate device it doesnt reset to the default frag
        if(savedInstanceState == null) {
            fm = getSupportFragmentManager();
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new welcomeFragment());
            tran.commit();
        }
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
            fm = getSupportFragmentManager();
            FragmentTransaction tran = fm.beginTransaction();
            tran.replace(R.id.mainFrame, new languageFragment());
            tran.commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        fm = getSupportFragmentManager();
        FragmentTransaction tran = fm.beginTransaction();
        if (id == R.id.nav_races) {
            tran.replace(R.id.mainFrame, new racesFragment());
            tran.commit();
        } else if (id == R.id.nav_contact) {
            tran.replace(R.id.mainFrame, new contactFragment());
            tran.commit();
        } else if (id == R.id.nav_classes) {
            tran.replace(R.id.mainFrame, new classesFragment());
            tran.commit();
        }else if (id == R.id.nav_items) {
            tran.replace(R.id.mainFrame, new itemsFragment());
            tran.commit();
        }else if (id == R.id.nav_faq) {
            tran.replace(R.id.mainFrame, new faqFragment());
            tran.commit();
        }else if (id == R.id.nav_tips) {
            tran.replace(R.id.mainFrame, new tipsFragment());
            tran.commit();
        } else if (id == R.id.nav_tutorials) {
            tran.replace(R.id.mainFrame, new tutorialFragment());
            tran.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
