package com.example.meteo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapView extends AppCompatActivity  implements  OnMapReadyCallback{
    double lon;
    double lat;
    LatLng Vmap;
    GoogleMap map;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_view);
        Bundle b=getIntent().getExtras();
        lon =b.getDouble( "lon");
        lat = b.getDouble("lat" );
        Vmap = new LatLng(lat,lon);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions().position(Vmap));

        map.moveCamera(CameraUpdateFactory.newLatLng(Vmap));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Vmap,12));

        map.getUiSettings().setZoomControlsEnabled(true);
    }
}
