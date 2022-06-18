package com.vj.newsapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.vj.domain.utils.ApiRequestStatus
import com.vj.newsapp.R
import com.vj.newsapp.presentation.home.viewmodel.HomeViewModel
import com.vj.newsapp.utils.ConnectionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "HomeFragment"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var connectivityManager: ConnectionManager
    private val country = "us"
    private val page = 1

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onStart() {
        super.onStart()
        connectivityManager.registerConnectionObserver(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callNewsHeadLines()
    }

    private fun callNewsHeadLines() {
        homeViewModel.getNewsHeadLines(country, page)
        homeViewModel.newsHeadLines.observe(viewLifecycleOwner) {result ->
            when(result){
                is ApiRequestStatus.Success -> {
                    Log.i(TAG, "Success: ${result.response}")
                }
                is ApiRequestStatus.Failed -> {
                    Log.i(TAG, "Failed: ")
                }
            }

        }
    }

    override fun onStop() {
        super.onStop()
        connectivityManager.unregisterConnectionObserver(this)
    }

}