package com.kennethmanuel.week8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import java.io.Serializable

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_EVENTS = "events"

/**
 * A simple [Fragment] subclass.
 * Use the [EventFragmentList.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventFragmentList : ListFragment() {
    // TODO: Rename and change types of parameters
    private var events: ArrayList<Event> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            events = it.getSerializable(ARG_EVENTS) as ArrayList<Event>
        }
        var adapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_list_item_1, events)
        listAdapter = adapter
    }

    // TODO: membuat implementasi fun onListItemClick
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        // Buat fragment detail
        var eventDetailFragment = EventDetailFragment.newInstance(events[position])
        activity!!.supportFragmentManager.beginTransaction().apply {
//            replace(R.id.container, eventDetailFragment)
//            addToBackStack(null)
//            commit()
            eventDetailFragment.show(this, "dialog")
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(events: ArrayList<Event>) =
            EventFragmentList().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_EVENTS, events as Serializable)
                }
            }
    }
}