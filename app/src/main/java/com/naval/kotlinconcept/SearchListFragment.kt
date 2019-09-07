package com.naval.kotlinconcept


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.naval.kotlinconcept.viewmodel.SearchListViewModel
import kotlinx.android.synthetic.main.search_list_fragment.*


class SearchListFragment : BaseFragment(R.layout.search_list_fragment) {

    companion object {
        fun newInstance() = SearchListFragment()
    }

    private lateinit var viewModel: SearchListViewModel
    var navController: NavController?=null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchListViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        ( activity as MainActivity).onFragmentInteraction(getString(R.string.search_list_fragment))

        //val btnGoToBF=view.findViewById<Button>(R.id.btnGoToBF)
        btnGoToBF.setOnClickListener{
           // Navigation.findNavController(it).navigate(R.id.action_searchListFragment_to_bookFragment)//working
             navController!!.navigate(R.id.action_searchListFragment_to_bookFragment)//working
//            findNavController().navigate(R.id.dropFragment)//working
        }
    }




}
