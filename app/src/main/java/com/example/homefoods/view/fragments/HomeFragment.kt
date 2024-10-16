package com.example.homefoods.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homefoods.R
import com.example.homefoods.adapters.RecyclerAdapter
import com.example.homefoods.model.RestaurantDetails

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var recyclerView4: RecyclerView
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the RecyclerView
        recyclerView = view.findViewById(R.id.horizontal_recycler_view)
        recyclerView2 = view.findViewById(R.id.horizontal_recycler_view2)
        recyclerView3 = view.findViewById(R.id.horizontal_recycler_view3)
        recyclerView4 = view.findViewById(R.id.horizontal_recycler_view4)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView3.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView4.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Sample data for RecyclerView
        val items = listOf("Pasta Place", "123 Noodle St","Pasta Place", "123 Noodle St","Pasta Place", "123 Noodle St","Pasta Place", "123 Noodle St")

        // Set the adapter
        adapter = RecyclerAdapter(items)
        recyclerView.adapter = adapter
        recyclerView2.adapter = adapter
        recyclerView3.adapter = adapter
        recyclerView4.adapter = adapter
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}