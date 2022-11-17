package com.vishnevskiypro.wild.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.vishnevskiypro.wild.R
import com.vishnevskiypro.wild.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)

        binding.btnPlayWithComputer.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_computerGameFragment)
        }

        binding.btnTwoPlayers.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
        }

        binding.btnScores.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_menuFragment_to_resultFragment)
        }

        return binding.root
    }

}