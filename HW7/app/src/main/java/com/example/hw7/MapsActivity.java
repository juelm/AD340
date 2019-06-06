package com.example.hw7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private FusedLocationProviderClient mLocationClient;
    private final String TAG = "YOU ARE HERE...?";
    private boolean mLocationPermissionGranted;
    private GoogleMap mMap;
    private String camDescription;
    private String camLat;
    private String camLon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();
        camDescription = intent.getStringExtra("description");
        camLat = intent.getStringExtra("lat");
        camLon = intent.getStringExtra("lon");

//        Bundle bundle = intent.getExtras();
//        camDescription = bundle.getString("description");
//        camLat = bundle.getString("lat");
//        camLon = bundle.getString("lon");
       // Log.d(TAG, camLat);

        mLocationClient = LocationServices.getFusedLocationProviderClient(this);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        putCamera(camLat, camLon, mMap);

        getLocationPermission();

        getLocation();

        //Log.d(TAG, "Permission Granted ? " + mLocationPermissionGranted);
        //putCamera(camLat, camLon, mMap);
    }

    @SuppressLint("MissingPermission")
    private void getLocation(){
        if(mLocationPermissionGranted){
            Task location = mLocationClient.getLastLocation();

            location.addOnCompleteListener(new OnCompleteListener<Location>(){

                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location actualLocation = task.getResult();
                    //Log.d(TAG, "Lat: " + actualLocation.getLatitude());
                    if(actualLocation != null) {
                        String latLong = String.format("Lat: %f, Long: %f",
                                actualLocation.getLatitude(),
                                actualLocation.getLongitude());
                        mMap.setMyLocationEnabled(true);
                        mMap.getUiSettings().setMyLocationButtonEnabled(true);

                        //update Map

                        LatLng here = new LatLng(actualLocation.getLatitude(),
                                actualLocation.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(here).title("Current Location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 10));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(9));

                    }else{


                        LatLng here = new LatLng(47.699670,-122.332708);
                        mMap.addMarker(new MarkerOptions().position(here).title("Current Location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 10));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(9));
                        //Log.e(TAG, "Location not found");
                    }

                }
            });
            location.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
            });
        }
    }

    private void getLocationPermission(){
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            mLocationPermissionGranted = true;
        }else{
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
        }
    }

    private void putCamera(String lat, String lon, GoogleMap map){

        LatLng here = new LatLng(Double.parseDouble(lat),
                Double.parseDouble(lon));
        map.addMarker(new MarkerOptions().position(here).title("Camera Location"));
        //map.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 10));
        //map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
