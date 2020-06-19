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

        //var listView = view.findViewById<ListView>(R.id.ListView)
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
                    requireContext(), "I AM 2A",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (position == 2){
                startActivity(Intent(requireActivity(),MapsActivity::class.java))
            }
        }
        return view
    }
}
