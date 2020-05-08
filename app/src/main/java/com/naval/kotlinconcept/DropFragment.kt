package com.naval.kotlinconcept

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
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
