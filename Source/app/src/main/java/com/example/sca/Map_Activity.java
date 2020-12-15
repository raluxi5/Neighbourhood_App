package com.example.sca;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Icon;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import java.util.ArrayList;

public class Map_Activity extends AppCompatActivity  {

    private MapView mapView;
    Button featuresB;
    public static ArrayList<String> feature_names = new ArrayList<String>();
    private DrawerLayout drawerLayout;
    private ImageView imag;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigation;
    private ImageView chatbutton;
    private ImageView problemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.access_token));

        // This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.map_activity);

        Toolbar toolbar = findViewById(R.id.layoutToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.logo3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        chatbutton = findViewById(R.id.chatButton);
        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LoginActivity.login == false && Create_Acc.createaccount == false )
                    startActivity(new Intent(Map_Activity.this, Chat_Next.class));
                else {
                    startActivity(new Intent(Map_Activity.this, ChatPosts_Activity.class));
                }
            }
        });

        problemButton = findViewById(R.id.problembutton);
        problemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Map_Activity.this, Problem_Activity.class));
            }
        });

        navigation = findViewById(R.id.navigationView);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.menuLogin: {
                       //startActivity(new Intent(Map_Activity.this, LoginActivity.class));
                       //return true;
                        Toast.makeText(Map_Activity.this,"CLICKKKKKKKKKK",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.menuSignin:{
                        startActivity(new Intent(Map_Activity.this, Create_Acc.class));
                        return true;
                    }
                    case R.id.menuChat:
                        {startActivity(new Intent(Map_Activity.this, ChatPosts_Activity.class));
                            return true;}
                    case R.id.menuMap:
                        {startActivity(new Intent(Map_Activity.this, Map_Activity.class));
                            return true;}
                    case R.id.menuLanguage:
                        {startActivity(new Intent(Map_Activity.this, MainActivity.class));
                            return true;}
                    case R.id.menuReport:
                       {startActivity(new Intent(Map_Activity.this, Problem_Activity.class));
                           return true;}
                    default:
                        return false;

                }
            }
        });


        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        featuresB = findViewById(R.id.buttonDetails);
        featuresB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Map_Activity.this,Nbhd_Activity.class));
            }
        });



        mapView.getMapAsync(new OnMapReadyCallback() {

            @Override
            public void onMapReady(@NonNull final MapboxMap mapboxMap) {


                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                       MarkerOptions marker1 = new MarkerOptions();
                       MarkerOptions marker2 = new MarkerOptions();
                       MarkerOptions marker3 = new MarkerOptions();
                       MarkerOptions marker4 = new MarkerOptions();

                       marker1.title("National Art Museum");
                       marker1.position(new LatLng(48.200767,16.342551));
                       IconFactory iconFactory1 = IconFactory.getInstance(Map_Activity.this);
                       Icon myicon1;
                       Icon icon1 = iconFactory1.fromResource(R.drawable.painting_palette);
                       myicon1 = IconFactory.recreate(icon1.getId(), Bitmap.createScaledBitmap(icon1.getBitmap(),60,60,false));
                       marker1.icon(myicon1);
                       mapboxMap.addMarker(marker1);
                       feature_names.add(marker1.getTitle());

                        marker2.title("Merkur");
                        marker2.position(new LatLng(48.201382,16.343474));
                        IconFactory iconFactory2 = IconFactory.getInstance(Map_Activity.this);
                        Icon myicon2;
                        Icon icon2 = iconFactory2.fromResource(R.drawable.shopping_bag);
                        myicon2 = IconFactory.recreate(icon2.getId(), Bitmap.createScaledBitmap(icon2.getBitmap(),60,60,false));
                        marker2.icon(myicon2);
                        mapboxMap.addMarker(marker2);
                        feature_names.add(marker2.getTitle());

                        marker3.title("Royal Hotel");
                        marker3.position(new LatLng(48.199595,16.344869));
                        IconFactory iconFactory3 = IconFactory.getInstance(Map_Activity.this);
                        Icon myicon3;
                        Icon icon3 = iconFactory3.fromResource(R.drawable.hotel);
                        myicon3 = IconFactory.recreate(icon3.getId(), Bitmap.createScaledBitmap(icon3.getBitmap(),60,60,false));
                        marker3.icon(myicon3);
                        mapboxMap.addMarker(marker3);
                        feature_names.add(marker3.getTitle());

                        marker4.title("Artemis Hospital");
                        marker4.position(new LatLng(48.201461,16.341521));
                        IconFactory iconFactory4 = IconFactory.getInstance(Map_Activity.this);
                        Icon myicon4;
                        Icon icon4 = iconFactory4.fromResource(R.drawable.hospital);
                        myicon4 = IconFactory.recreate(icon4.getId(), Bitmap.createScaledBitmap(icon4.getBitmap(),60,60,false));
                        marker4.icon(myicon4);
                        mapboxMap.addMarker(marker4);
                        feature_names.add(marker4.getTitle());

                    }
                });
            }
        });
    }


    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    @Override
    public boolean onSupportNavigateUp () {
        onBackPressed();  // go previous activity
        return super.onSupportNavigateUp();
    }


}




