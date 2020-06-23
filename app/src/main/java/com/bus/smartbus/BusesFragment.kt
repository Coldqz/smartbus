package com.bus.smartbus

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class BusesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_buses, container, false)

        var listView = view.findViewById<ListView>(R.id.ListView)
        var list = mutableListOf<Model>()

//        for (i in range(100)) {
//            bus = SELECT FROM bu WHERE id = i
//        }
//
//            collection {
//         0 : Model0,
//         1 : Model1
//
//    **/
//        int c_id = -1

        var db = DataBaseHandler(requireContext())
//        db.deleteData()
//        db.resetAuto()
//        db.deleteData()

//        Buses insert
//        val markerList = """48.5219277,25.0139032","48.5259212,25.0264061","48.524686,25.035598","48.5243528,25.0420084","48.5250987,25.0471553","48.5258819,25.0578298","48.5258474,25.0618019","48.5257274,25.0695304","48.5253455,25.0781946","48.5228098,25.090712"""
//        var bus1 = BusDB("3","Н.Вербіж(міст)-Завод КРП",markerList)
//        var bus2 = BusDB("testbus2","alksdlkasjd;test2",markerList)
//        var bus3 = BusDB("testbus3","asdastest3",markerList)
//        db.insertData(bus1)
//        db.insertData(bus2)
//        db.insertData(bus3)

//        db.deleteData()
        var data = db.readData()
        for (i in 0..(data.size - 1)) {
            println(data.get(i).name + " " + data.get(i).description + " " + data.get(i).routeCoord + "\n")
        }


        for (i in 0..(data.size - 1)) {
            list.add(Model(data.get(i).name, data.get(i).description))
        }
//        list.add(Model("№ 2", "Залізничний вокзал - Шепарівське кільце"))

//        c_id += 1
//        collection[c_id] = Model
//        list.add(Model("№ 2А", "Залізничний вокзал - Шепарівці-Левада"))
//        list.add(Model("№ 3", "Н.Вербіж(міст)- Завод КРП"))

        listView.adapter = MyAdapter(requireActivity(), R.layout.buses_row, list)

        listView.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            var markerList = arrayListOf<String>(data[position].routeCoord)
            val intent = Intent(requireActivity(),MapsActivity::class.java)
            intent.putExtra("markerList", markerList)
            startActivity(intent)


//            if (position == 2){
//                val markerList = arrayListOf<String>("48.5219277,25.0139032","48.5259212,25.0264061","48.524686,25.035598","48.5243528,25.0420084","48.5250987,25.0471553","48.5258819,25.0578298","48.5258474,25.0618019","48.5257274,25.0695304","48.5253455,25.0781946","48.5228098,25.090712")
//
//
//                val intent = Intent(requireActivity(),MapsActivity::class.java)
//                intent.putExtra("markerList", markerList)
//                startActivity(intent)
//            }
        }
        return view
    }
}
