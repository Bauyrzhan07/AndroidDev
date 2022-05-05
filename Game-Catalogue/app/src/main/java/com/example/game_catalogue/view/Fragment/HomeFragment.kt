package com.example.game_catalogue.view.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.game_catalogue.R
import com.example.game_catalogue.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnCategories.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_categoryListFragment)
            }
            btnGames.setOnClickListener {
                findNavController().navigate(
                    R.id.action_homeFragment_to_gameListFragment,
                    bundleOf(GameListFragment.ARG_MODE to 0)
                )
            }
        }
    }
}