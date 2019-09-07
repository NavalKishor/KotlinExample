package com.naval.kotlinconcept

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.naval.kotlinconcept.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.search_fragment.*


class SearchFragment : BaseFragment(R.layout.search_fragment) {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var viewModel: SearchViewModel
    lateinit var navController: NavController
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        (activity as HomeFragment.OnFragmentInteractionListener).onFragmentInteraction(getString(R.string.search_fragment))
        btnGoToSLF.setOnClickListener {
            navController.navigate(R.id.action_searchFragment_to_searchListFragment)
        }
    }


}
