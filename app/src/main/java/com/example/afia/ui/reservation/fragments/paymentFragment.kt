package com.example.afia.ui.reservation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.afia.R
import com.example.afia.ui.reuseable.SuccessActivity
import kotlinx.android.synthetic.main.fragment_payment.view.*

/**
 * A simple [Fragment] subclass.
 */
class paymentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_payment, container, false)

        view.reservationBtn.setOnClickListener {

            val intent = Intent(activity , SuccessActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP )
            activity?.startActivity(intent)


        }
        // Inflate the layout for this fragment
        return view
    }

}
