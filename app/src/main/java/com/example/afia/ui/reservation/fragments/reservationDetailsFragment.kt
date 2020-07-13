package com.example.afia.ui.reservation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.paris.extensions.style

import com.example.afia.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_reservation_details.*
import kotlinx.android.synthetic.main.fragment_reservation_details.view.*

/**
 * A simple [Fragment] subclass.
 */
class reservationDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_reservation_details, container, false)

        view.dayShift_cardView.setOnClickListener {card ->
            card.style(R.style.selectedCardView)

            nightShift_cardView.style(R.style.notSelectedCardView)
            // change text color

            dayShift_textView.style(R.style.selectedCardText)
            dayShift_startTime_textView.style(R.style.selectedCardText)
            dayShift_endTime_textView.style(R.style.selectedCardText)

            nightShift_textView.style(R.style.notSelectedText)
            nightShift_startTime_textView.style(R.style.notSelectedText)
            nightShift_endTime_textView.style(R.style.notSelectedText)
        }

        view.nightShift_cardView.setOnClickListener {card ->
            card.style(R.style.selectedCardView)
            dayShift_cardView.style(R.style.notSelectedCardView)
            // change text color

            nightShift_textView.style(R.style.selectedCardText)
            nightShift_startTime_textView.style(R.style.selectedCardText)
            nightShift_endTime_textView.style(R.style.selectedCardText)

            dayShift_textView.style(R.style.notSelectedText)
            dayShift_startTime_textView.style(R.style.notSelectedText)
            dayShift_endTime_textView.style(R.style.notSelectedText)
        }

        view.nextBtn.setOnClickListener {
            activity?.findViewById<TabLayout>(R.id.tabLayout)?.getTabAt(0)?.select()
        }
        // Inflate the layout for this fragment
        return view
    }

}
