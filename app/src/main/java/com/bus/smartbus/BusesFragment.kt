package com.bus.smartbus

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 */
class BusesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_buses, container, false)
        //return LayoutInflater.from(container?.context).inflate(R.layout.fragment_buses, container, false)

        var listView = view.findViewById<ListView>(R.id.ListView)
        var list = mutableListOf<Model>()

        list.add(Model("№ 2", "Залізничний вокзал - Шепарівське кільце"))
        list.add(Model("№ 2А", "Залізничний вокзал - Шепарівці-Левада"))
        list.add(Model("№ 3", "Н.Вербіж(міст)- Завод КРП"))


        listView.adapter = MyAdapter(requireActivity(), R.layout.buses_row, list)

        listView.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            if (position == 0){
                Toast.makeText(
                    requireContext(), "I AM 2",
                    Toast.LENGTH_SHORT
                ).show()            }

            if (position == 1){
                Toast.makeText(
                    requireContext(), "I AM 2",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (position == 2){
                val markerList = arrayListOf<String>("48.5219277,25.0139032","48.5259212,25.0264061","48.524686,25.035598","48.5243528,25.0420084","48.5250987,25.0471553","48.5258819,25.0578298","48.5258474,25.0618019","48.5257274,25.0695304","48.5228098,25.090712","48.5253455,25.0781946")

                val intent = Intent(requireActivity(),MapsActivity::class.java)
                intent.putExtra("markerList", markerList)
                startActivity(intent)
            }
        }
        return view
    }
}
