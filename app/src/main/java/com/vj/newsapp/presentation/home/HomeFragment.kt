package com.vj.newsapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vj.domain.utils.ApiRequestStatus
import com.vj.newsapp.R
import com.vj.newsapp.databinding.FragmentHomeBinding
import com.vj.newsapp.presentation.home.adapter.NewsHomeAdapter
import com.vj.newsapp.presentation.home.viewmodel.HomeViewModel
import com.vj.newsapp.utils.NetworkHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TAG = "HomeFragment"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val country = "us"
    private val page = 1

    @Inject
    lateinit var newsHomeAdapter: NewsHomeAdapter
    private var fragmentHomeBinding: FragmentHomeBinding? = null
    private val binding get() = fragmentHomeBinding!!
    private val homeViewModel: HomeViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewAdapter()
        callNewsHeadLines()
    }

    private fun initRecyclerViewAdapter() {
        binding.newsList.apply {
            adapter = newsHomeAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun callNewsHeadLines() {
        activity?.let {
            if (NetworkHelper.hasInternet(it.applicationContext))
                homeViewModel.getNewsHeadLines(country, page)
            else
                Toast.makeText(activity, getString(R.string.no_internet), Toast.LENGTH_SHORT).show()
        }
        homeViewModel.newsHeadLinesResponse.observe(viewLifecycleOwner) { result ->
            when (result) {
                is ApiRequestStatus.Success -> {
                    Log.i(TAG, "Success --> ${result.response}")
                    binding.newsList.visibility = View.VISIBLE
                    newsHomeAdapter.diffUtils.submitList(result.response.articles)

                }
                is ApiRequestStatus.Failed -> {
                    Log.i(TAG, "Failed: ")
                }
            }

        }
    }

}