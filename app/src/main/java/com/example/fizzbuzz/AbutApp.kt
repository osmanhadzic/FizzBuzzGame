package com.example.fizzbuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_abut_app2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AbutApp.newInstance] factory method to
 * create an instance of this fragment.
 */
class AbutApp : Fragment(R.layout.fragment_abut_app2),View.OnClickListener {

    lateinit var navController: NavController

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.backBtn -> navController.navigate(R.id.action_abutApp2_to_mainFragment2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.backBtn).setOnClickListener(this)

    }


}