package com.example.archcomponentsnavigation.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.example.archcomponentsnavigation.MainActivity
import com.example.archcomponentsnavigation.R
import com.example.archcomponentsnavigation.databinding.FragmentSignupSecondBinding

/**
 * A simple [Fragment] subclass.
 */
class SignUpSecondFragment : Fragment() {

    private val viewModel: SignUpViewModel by navGraphViewModels(R.id.navigation_sign_up)

    private var viewBinding: FragmentSignupSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSignupSecondBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.liveData.observe(viewLifecycleOwner, Observer { user ->
            viewBinding!!.etDescription.setText(user.description)
        })
        viewBinding!!.btnGoToThirdScreen.setOnClickListener {
            val description = viewBinding!!.etDescription.text.toString()
            if (description.isBlank()) {
                Toast.makeText(
                    requireActivity(),
                    "Please, provide a description",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                viewModel.setDescription(description)
                (context as MainActivity).onNavigationSelected(R.id.action_signUpSecondFragment_to_signUpThirdFragment)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

}
