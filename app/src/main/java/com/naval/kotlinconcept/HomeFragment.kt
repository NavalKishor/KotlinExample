package com.naval.kotlinconcept

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.naval.kotlinconcept.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment(R.layout.fragment_home) {
    private  val ARG_PARAM1 = "param1"
    private  val ARG_PARAM2 = "param2"


    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private lateinit var viewModel: HomeViewModel

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
        onButtonPressed(getString(R.string.hello_blank_fragment))
        //val btnSearch=view.findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener{
            navController.navigate(R.id.action_homeFragment_to_searchFragment)
            onButtonPressed(getString(R.string.search_fragment))
        }
       // val btnDrop=view.findViewById<Button>(R.id.btnDrop)
        btnDrop.setOnClickListener{
            navController.navigate(R.id.action_homeFragment_to_dropFragment)
            onButtonPressed(getString(R.string.drop_fragment))
        }
       // val btnPick=view.findViewById<Button>(R.id.btnPick)
        btnPick.setOnClickListener{
            navController.navigate(R.id.action_homeFragment_to_pickFragment)
            onButtonPressed(getString(R.string.pick_fragment))
        }

    }

    fun onButtonPressed(uri: String) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(data: String)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */


        fun newInstance(param1: String, param2: String) = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2) }
        }

        fun newInstance() = HomeFragment()
    }
}
