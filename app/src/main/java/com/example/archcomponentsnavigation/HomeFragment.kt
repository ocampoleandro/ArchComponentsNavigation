package com.example.archcomponentsnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btn_home_second_screen).setOnClickListener {
            (context as MainActivity).onNavigationSelected(R.id.action_homeFragment_to_homeSecondFragment)
        }
        view.findViewById<ImageView>(R.id.iv_menu).apply {
            setOnClickListener {
                (context as MainActivity).openNavigationDrawer()
            }
            expandIconTouchArea()
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
