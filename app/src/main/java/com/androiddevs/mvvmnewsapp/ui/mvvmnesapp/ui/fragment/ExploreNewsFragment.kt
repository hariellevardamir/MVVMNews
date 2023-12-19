package com.androiddevs.mvvmnewsapp.ui.mvvmnesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.databinding.FragmentExploreNewsBinding
import com.androiddevs.mvvmnewsapp.ui.mvvmnesapp.ui.NewsActivity
import com.androiddevs.mvvmnewsapp.ui.mvvmnesapp.ui.NewsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExploreNewsFragment : Fragment(R.layout.fragment_explore_news) {

    private lateinit var binding: FragmentExploreNewsBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var bottomNavigationView: BottomNavigationView
    private val TAG = "ExploreNewsFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        bottomNavigationView =
            (activity as NewsActivity).findViewById(R.id.bottomNavigationView)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreNewsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView.visibility = View.VISIBLE

        binding.ivSports.setOnClickListener {
            findNavController().navigate(
                R.id.action_exploreNewsFragment_to_sportsNewsFragment
            )
            bottomNavigationView.visibility = View.GONE
        }

        binding.ivPolitics.setOnClickListener {
            findNavController().navigate(
                R.id.action_exploreNewsFragment_to_politicsNewsFragment
            )
            bottomNavigationView.visibility = View.GONE
        }

        binding.ivTechnology.setOnClickListener {
            findNavController().navigate(
                R.id.action_exploreNewsFragment_to_technologyNewsFragment
            )
            bottomNavigationView.visibility = View.GONE
        }

        binding.ivEconomy.setOnClickListener {
            findNavController().navigate(
                R.id.action_exploreNewsFragment_to_economyNewsFragment
            )
            bottomNavigationView.visibility = View.GONE
        }

        binding.ivMagazine.setOnClickListener {
            findNavController().navigate(
                R.id.action_exploreNewsFragment_to_magazineNewsFragment
            )
            bottomNavigationView.visibility = View.GONE
        }
    }
}
