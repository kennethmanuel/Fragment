package com.kennethmanuel.week8

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_event_detail.view.*
import java.io.Serializable

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_EVENT = "event"

/**
 * A simple [Fragment] subclass.
 * Use the [EventDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventDetailFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var event: Event? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        arguments?.let {
            event = it.getSerializable(ARG_EVENT) as Event
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.fragment_event_detail, container, false).apply {
            imageEvent.setImageDrawable(activity!!.applicationContext.getDrawable(event!!.pic))
            textEventName.text = event?.name
            textDescription.text = event?.desc
            barNeeds.max = event?.crewNeeded ?: 10
            barNeeds.progress = event?.crewNumber ?:0
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(event: Event) =
            EventDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_EVENT, event as Serializable)
                }
            }
    }
}