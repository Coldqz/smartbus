package com.bus.smartbus

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

        list.add(Model("number 3", ""))
        list.add(Model("number 3", "asdasd"))

        listView.adapter = MyAdapter(requireActivity(), R.layout.buses_row, list)
        listView.setOnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
            if (position == 0){
                Toast.makeText(
                    requireContext(), "Please verify your email address.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return view
    }

}
