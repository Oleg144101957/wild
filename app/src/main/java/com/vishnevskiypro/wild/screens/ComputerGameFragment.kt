package com.vishnevskiypro.wild.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vishnevskiypro.wild.databinding.FragmentComputerGameBinding

class ComputerGameFragment : Fragment() {

    private lateinit var binding: FragmentComputerGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComputerGameBinding.inflate(layoutInflater, container, false)



        return binding.root
    }


}