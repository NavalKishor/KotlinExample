package com.naval.kotlinconcept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naval.kotlinconcept.viewmodel.PickViewModel


class PickFragment : BaseFragment() {

    companion object {
        fun newInstance() = PickFragment()
    }
    private lateinit var viewModel: PickViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pick_fragment, container, false)
    }
}
