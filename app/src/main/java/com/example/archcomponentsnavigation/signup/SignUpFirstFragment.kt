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
import com.example.archcomponentsnavigation.databinding.FragmentSignupFirstBinding

/**
 * A simple [Fragment] subclass.
 */
class SignUpFirstFragment : Fragment() {

    private val viewModel: SignUpViewModel by navGraphViewModels(R.id.navigation_sign_up)

    private var viewBinding: FragmentSignupFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentSignupFirstBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.liveData.observe(viewLifecycleOwner, Observer { user ->
            viewBinding!!.apply {
                etName.setText(user.name)
                etLastName.setText(user.lastName)
            }
        })
        viewBinding!!.btnGoToSecondScreen.setOnClickListener {
            val lastName = viewBinding!!.etLastName.text.toString()
            val name = viewBinding!!.etName.text.toString()
            if (name.isBlank() || lastName.isBlank()) {
                Toast.makeText(
                    requireActivity(),
                    "Please, provide a name and a last name",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                viewModel.setName(name, lastName)
                (context as MainActivity).onNavigationSelected(R.id.action_signUpFirstFragment_to_signUpSecondFragment)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

}
