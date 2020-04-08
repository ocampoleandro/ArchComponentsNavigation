package com.example.archcomponentsnavigation.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.example.archcomponentsnavigation.MainActivity
import com.example.archcomponentsnavigation.R
import com.example.archcomponentsnavigation.databinding.FragmentSignupThirdBinding

/**
 * A simple [Fragment] subclass.
 */
class SignUpThirdFragment : Fragment() {

    private val viewModel: SignUpViewModel by navGraphViewModels(R.id.navigation_sign_up)

    private var viewBinding: FragmentSignupThirdBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSignupThirdBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.liveData.observe(viewLifecycleOwner, Observer { user ->
            viewBinding!!.apply {
                tvName.text = user.name
                tvLastName.text = user.lastName
                tvDescription.text = user.description
            }
        })
        viewBinding!!.btnGoHome.setOnClickListener {
            (context as MainActivity).onNavigationSelected(R.id.action_global_homeFragment2)
        }
        super.onViewCreated(view, savedInstanceState)
    }

}
