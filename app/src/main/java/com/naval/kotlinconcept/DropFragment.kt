package com.naval.kotlinconcept

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naval.kotlinconcept.viewmodel.DropViewModel


class DropFragment : BaseFragment(R.layout.drop_fragment) {

    companion object {
        fun newInstance() = DropFragment()
    }

    private lateinit var viewModel: DropViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DropViewModel::class.java)
    }

}
