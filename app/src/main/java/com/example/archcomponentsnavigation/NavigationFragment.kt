package com.example.archcomponentsnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.archcomponentsnavigation.databinding.FragmentNavigationBinding

/**
 * A simple [Fragment] subclass.
 */
class NavigationFragment : Fragment() {

    private val navController by lazy { findNavController() }
    private val args: NavigationFragmentArgs by navArgs()
    var viewBinding: FragmentNavigationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentNavigationBinding.inflate(inflater, container, false)
        viewBinding!!.ivMenuClose.apply {
            setOnClickListener {
                navController.popBackStack()
            }
            expandIconTouchArea()
        }

        val currentDestination = args.currentDestination
        when (currentDestination) {
            R.id.homeFragment -> {
                viewBinding!!.tvHome.isSelected = true
            }
            R.id.transactionsFragment -> {
                viewBinding!!.tvTransactions.isSelected = true
            }
            R.id.settingFragment -> {
                viewBinding!!.tvSettings.isSelected = true
            }
        }

        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(android.R.anim.slide_in_left)
            .setPopExitAnim(android.R.anim.slide_out_right)
            .setPopUpTo(R.id.homeFragment, false)
            .setLaunchSingleTop(true)
            .build()

        viewBinding!!.tvHome.setOnClickListener {
            if(currentDestination != R.id.homeFragment) {
                navController.navigate( NavigationFragmentDirections.actionNavigationFragmentToHomeFragment(), navOptions)
            } else {
                navController.popBackStack()
            }
        }
        viewBinding!!.tvTransactions.setOnClickListener {
            if(currentDestination != R.id.transactionsFragment) {
                navController.navigate(NavigationFragmentDirections.actionNavigationFragmentToTransactionsFragment(), navOptions)
            } else {
                navController.popBackStack()
            }
        }
        viewBinding!!.tvSettings.setOnClickListener {
            if(currentDestination != R.id.settingFragment) {
                navController.navigate(NavigationFragmentDirections.actionNavigationFragmentToSettingFragment() , navOptions)
            } else {
                navController.popBackStack()
            }
        }

        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

}
