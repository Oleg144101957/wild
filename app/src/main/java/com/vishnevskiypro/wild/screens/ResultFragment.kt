package com.vishnevskiypro.wild.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vishnevskiypro.wild.R
import com.vishnevskiypro.wild.databinding.FragmentMenuBinding
import com.vishnevskiypro.wild.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val sharedPreferences by lazy { requireActivity()
        .applicationContext.getSharedPreferences("shared_preferences", Context.MODE_PRIVATE) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)

        setReults()

        return binding.root
    }

    private fun setReults() {
        val playerScore = sharedPreferences.getInt("Player_Win", 0)
        val compScore = sharedPreferences.getInt("Computer_Win", 0)
        val draw = sharedPreferences.getInt("Draw", 0)
        binding.playerWin.text = "Player Score $playerScore"
        binding.pcWin.text = "Computer Win Score $compScore"
        binding.draw.text = "Draw Score $draw"
    }
}