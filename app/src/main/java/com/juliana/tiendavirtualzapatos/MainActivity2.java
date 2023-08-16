package com.juliana.tiendavirtualzapatos;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.juliana.tiendavirtualzapatos.databinding.ActivityMainBinding;
import com.juliana.tiendavirtualzapatos.ui.sucursales.SucursalesFragment;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MainActivity2 extends AppCompatActivity {

    private MapView mapView;
    private IMapController controller;
    private ActivityMainBinding binding;
    LayoutInflater inflater;
    ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(R.layout.sucursales_layout);
        SucursalesFragment sf = new SucursalesFragment();
        sf.onCreate(savedInstanceState);
        sf.onCreateView(inflater, container,savedInstanceState);
        Configuration.getInstance().setUserAgentValue(BuildConfig.BUILD_TYPE);
        isStoragePermissionGranted();
        mapView=findViewById(R.id.mapViewAthena);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setVisibility(View.VISIBLE);
        mapView.setMultiTouchControls(true);
        controller=mapView.getController();
        controller.setZoom(15.0);
        GeoPoint sucursalNorte = new GeoPoint(4.647250,-74.101606);
        controller.setCenter(sucursalNorte);
        Marker pointSN=new Marker(mapView);
        pointSN.setTitle("Sucursal Norte");
        pointSN.setPosition(sucursalNorte);
        pointSN.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);

        GeoPoint sucursalSur = new GeoPoint(4.6426226,-74.1588922);
        controller.setCenter(sucursalSur);
        Marker pointSS=new Marker(mapView);
        pointSS.setTitle("Sucursal Sur");
        pointSS.setPosition(sucursalSur);
        pointSS.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(pointSS);
        mapView.getOverlays().add(pointSN);

    }

    protected void onResume(){
        super.onResume();
        if (mapView!=null)
            mapView.onResume();
    }

    protected void onPause(){
        super.onPause();
        if (mapView!=null)
            mapView.onPause();
    }
    public boolean isStoragePermissionGranted(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                return true;
            }else{
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION},1);
                return false;
            }
        }else {
            return true;
        }
    }


}
