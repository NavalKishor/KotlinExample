package com.naval.kotlinconcept

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.naval.kotlinconcept.network.RetrofitFactory
import com.naval.kotlinconcept.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.search_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException


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
        val service = RetrofitFactory.makeRetrofitService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getPosts()
            try {
              withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        response.body()?.let { println(it)
                            tvSF.setText(it.toString())
                        }
                    } else {
                        toast("Error network operation failed with ${response.code().also { print(it) }.apply {  }}")
                    }
                }
            } catch (e: HttpException) {
                Log.e("REQUEST", "Exception ${e.message}")
            } catch (e: Throwable) {
                Log.e("REQUEST", "Ooops: Something else went wrong")
            }
        }
    }


}

fun BaseFragment.toast(msg:String,len:Int=Toast.LENGTH_LONG){
    Toast.makeText(context,msg,len).show()
}
