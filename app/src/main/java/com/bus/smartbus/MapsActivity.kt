package com.bus.smartbus

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var polyFoo: PolylineOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        var listView = findViewById<ListView>(R.id.ListView)
        var list = mutableListOf<Model>()

        list.add(Model("1", "Н.Вербіж(міст)"))
        list.add(Model("2", "Автостанція"))
        list.add(Model("3", "Кляштор(на вимогу)"))
        list.add(Model("4", "Ліцей №1"))
        list.add(Model("5", "Вул.Винниченка"))
        list.add(Model("6", "Ліцей №3"))
        list.add(Model("7", "Вул,Богуна"))
        list.add(Model("8", "Щіткова фабрика"))
        list.add(Model("9", "Житловий масив Гомін"))
        list.add(Model("10", "Завод Крп"))

        listView.adapter = MyAdapter(this, R.layout.stations_row, list)

        listView.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            if (position == 0) {
                val foo = LatLng(48.5219277,25.0139032)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 1) {
                val foo = LatLng(48.5259212,25.0264061)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 2) {
                val foo = LatLng(48.524686,25.035598)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 3) {
                val foo = LatLng(48.5243528,25.0420084)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 4) {
                val foo = LatLng(48.5250987,25.0471553)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 5) {
                val foo = LatLng(48.5258819,25.0578298)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 6) {
                val foo = LatLng(48.5258474,25.0618019)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 7) {
                val foo = LatLng(48.5257274,25.0695304)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 8) {
                val foo = LatLng(48.5228098,25.090712)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }

            if (position == 9) {
                val foo = LatLng(48.5253455,25.0781946)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(foo))
            }
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

//        add stations markers
        val markerList = intent.getStringArrayListExtra("markerList")
        for (value in markerList){

            var strTmp = value
            var foo =  strTmp.split(",")
            val tmpMarker = LatLng(foo[0].toDouble(), foo[1].toDouble())

            mMap.addMarker(
                MarkerOptions()
                    .position(tmpMarker))

        }

//        add route markers
        //val markerList = intent.getStringArrayListExtra("markerList")
        polyFoo = PolylineOptions()
        for (value in markerList){

            var strTmp = value
            var foo =  strTmp.split(",")
            val tmpMarker = LatLng(foo[0].toDouble(), foo[1].toDouble())
            polyFoo = polyFoo.add(tmpMarker)
            println(tmpMarker)
        }
        mMap.addPolyline(
            polyFoo
        )

        val main = LatLng(48.526294,25.024429)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(main))
        mMap.setMinZoomPreference(13.0f)
    }
}