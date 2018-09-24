package com.jonasvieira.tutorialapp.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.jonasvieira.tutorialapp.R;
import com.sdsmdg.harjot.crollerTest.Croller;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.croller)
    Croller croller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show());

        croller.setOnProgressChangedListener(progress -> croller.setLabel(progress + "%"));

        showTargetView();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favorite) {
            showTargetView();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showTargetView() {
        final TapTargetSequence sequence = new TapTargetSequence(this)
                .targets(
                        TapTarget.forView(croller, "teste 1", "teste 1")
                                .outerCircleColor(R.color.colorAccent)
                                .outerCircleAlpha(.95f)
                                .targetCircleColor(R.color.colorWhite)
                                .titleTextSize(24)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextSize(18)
                                .descriptionTextColor(R.color.colorWhite)
                                .textColor(R.color.colorWhite)
                                .textTypeface(Typeface.SANS_SERIF)
                                .drawShadow(true)
                                .cancelable(false)
                                .transparentTarget(true)
                                .targetRadius(60)
                        ,
                        TapTarget.forView(fab, "teste 2", "teste 2")
                                .outerCircleColor(R.color.colorAccent)
                                .outerCircleAlpha(.95f)
                                .targetCircleColor(R.color.colorWhite)
                                .titleTextSize(24)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextSize(18)
                                .descriptionTextColor(R.color.colorWhite)
                                .textColor(R.color.colorWhite)
                                .textTypeface(Typeface.SANS_SERIF)
                                .drawShadow(true)
                                .cancelable(false)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(toolbar, "teste 3", "teste 3")
                                .outerCircleColor(R.color.colorAccent)
                                .outerCircleAlpha(.95f)
                                .targetCircleColor(R.color.colorWhite)
                                .titleTextSize(24)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextSize(18)
                                .descriptionTextColor(R.color.colorWhite)
                                .textColor(R.color.colorWhite)
                                .textTypeface(Typeface.SANS_SERIF)
                                .drawShadow(true)
                                .cancelable(false)
                                .transparentTarget(true)
                                .targetRadius(60),
                        TapTarget.forView(croller, "teste 4", "teste 4")
                                .outerCircleColor(R.color.colorAccent)
                                .outerCircleAlpha(.95f)
                                .targetCircleColor(R.color.colorWhite)
                                .titleTextSize(24)
                                .titleTextColor(R.color.colorWhite)
                                .descriptionTextSize(18)
                                .descriptionTextColor(R.color.colorWhite)
                                .textColor(R.color.colorWhite)
                                .textTypeface(Typeface.SANS_SERIF)
                                .drawShadow(true)
                                .cancelable(false)
                                .transparentTarget(true)
                                .targetRadius(60)
                )
                .listener(new TapTargetSequence.Listener() {
                    public void onSequenceFinish() {

                    }

                    @Override
                    public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
                        Log.d("TapTargetView", "Clicked on " + lastTarget.id());
                    }

                    @Override
                    public void onSequenceCanceled(TapTarget lastTarget) {

                    }
                });

        sequence.start();
    }
}
