package com.bus.smartbus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var zalupa: PolylineOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        var listView = findViewById<ListView>(R.id.ListView)
        var list = mutableListOf<Model>()

        list.add(Model("№ 2", "Залізничний вокзал - Шепарівське кільце"))
        list.add(Model("№ 2А", "Залізничний вокзал - Шепарівці-Левада"))
        list.add(Model("№ 3", "Н.Вербіж(міст)- Завод КРП"))


        listView.adapter = MyAdapter(this, R.layout.stations_row, list)

        listView.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            if (position == 0) {
                Toast.makeText(
                    baseContext, "I AM 2",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
//        add stations markers
//        val markerList = intent.getStringArrayListExtra("markerList")
//        for (value in markerList){
//
//            var strTmp = value
//            var foo =  strTmp.split(",")
//            val tmpMarker = LatLng(foo[0].toDouble(), foo[1].toDouble())
//            mMap.addMarker(MarkerOptions().position(tmpMarker))
//        }

//        add route markers
//        val markerList = intent.getStringArrayListExtra("markerList")
//        zalupa = PolylineOptions()
//        for (value in markerList){
//
//            var strTmp = value
//            var foo =  strTmp.split(",")
//            val tmpMarker = LatLng(foo[0].toDouble(), foo[1].toDouble())
//            zalupa = zalupa.add(tmpMarker)
//            println(tmpMarker)
//        }
//        mMap.addPolyline(
//            zalupa
//        )

        val main = LatLng(48.526294,25.024429)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(main))
        mMap.setMinZoomPreference(13.0f)
    }
}