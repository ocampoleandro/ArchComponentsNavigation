package com.example.archcomponentsnavigation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.archcomponentsnavigation.MainActivity

import com.example.archcomponentsnavigation.R

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.btn_home).setOnClickListener {
            //Todo: USE AN INTERFACE INSTEAD :D
            (context as MainActivity).onNavigationSelected(R.id.action_loginFragment_to_homeFragment)
        }
        view.findViewById<Button>(R.id.btn_sign_up).setOnClickListener {
            (context as MainActivity).onNavigationSelected(R.id.action_loginFragment_to_navigation)
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
