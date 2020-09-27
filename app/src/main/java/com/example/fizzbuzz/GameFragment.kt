package com.example.fizzbuzz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.databinding.DataBindingUtil

import com.example.fizzbuzz.models.FizzBuzzNum
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

const val LAST_NUM = "lastNumber"

class GameFragment : Fragment(), View.OnClickListener {

    var fizzBuzzNum = 0
    lateinit var navController: NavController

    private val fizzBuzzNumber : FizzBuzzNum = FizzBuzzNum(0)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_NUM,fizzBuzzNum)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            fizzBuzzNum = savedInstanceState.getInt(LAST_NUM, 0)
            randNum.text = fizzBuzzNum.toString()
        }


        navController = Navigation.findNavController(view)


        view.findViewById<Button>(R.id.fizzBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.buzzBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.fizzBizzBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.numTxt).setOnClickListener(this)
        view.findViewById<Button>(R.id.fizzBtn).setOnClickListener(this)
    }





    override fun onClick(p0: View?) {

        when(p0!!.id){
            R.id.fizzBtn -> {
                if(fizzBuzzNum == 0) {
                    fizzBuzzNum = fizzBuzzNumber.genNumber()

                    randNum.text = fizzBuzzNum.toString()
                }
                if(fizzBuzzNum % 3 == 0){
                    navController.navigate(R.id.action_gameFragment_to_winFragment)

                }else{
                    navController.navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            }
            R.id.buzzBtn -> {
                if(fizzBuzzNum == 0) {
                    fizzBuzzNum = fizzBuzzNumber.genNumber()

                    randNum.text = fizzBuzzNum.toString()
                }

                if(fizzBuzzNum % 5 == 0){
                    navController.navigate(R.id.action_gameFragment_to_winFragment)
                }else{
                    navController.navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            }
            R.id.fizzBizzBtn -> {
                if(fizzBuzzNum == 0) {
                    fizzBuzzNum = fizzBuzzNumber.genNumber()

                    randNum.text = fizzBuzzNum.toString()
                }

                if(fizzBuzzNum % 3 == 0 && fizzBuzzNum % 5 == 0){
                    navController.navigate(R.id.action_gameFragment_to_winFragment)
                }else{
                    navController.navigate(R.id.action_gameFragment_to_gameOverFragment)
                }
            }
            R.id.numTxt -> {
                fizzBuzzNum = fizzBuzzNumber.genNumber()
                randNum.text = fizzBuzzNum.toString()
            }

        }
    }




}