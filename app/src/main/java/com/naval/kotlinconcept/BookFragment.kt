package com.naval.kotlinconcept

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.naval.kotlinconcept.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.book_fragment.*


class BookFragment : BaseFragment(R.layout.book_fragment) {

    companion object {
        fun newInstance() = BookFragment()
    }

    private lateinit var viewModel: BookViewModel
    lateinit var navController: NavController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        ( activity as MainActivity).onFragmentInteraction(getString(R.string.book_fragment))

        //val btnGoToHF=view.findViewById<Button>(R.id.btnGoToHF)
        btnGoToHF.setOnClickListener{
             navController.navigate(R.id.action_bookFragment_to_homeFragment)
            //onButtonPressed(getString(R.string.search_fragment))
        }
    }

    override fun onBackPreesed():Boolean {
        Log.i("TAG",Thread.currentThread().getStackTrace()[2].className)
        super.onBackPreesed()
        findNavController().navigate(R.id.dropFragment,
            null,
            NavOptions.Builder().setPopUpTo(R.id.homeFragment, false).build())
        // setPopUpTo is fun to remove the fragments from stack
        (activity as MainActivity).onFragmentInteraction(getString(R.string.drop_fragment))
        return true
    }
}
