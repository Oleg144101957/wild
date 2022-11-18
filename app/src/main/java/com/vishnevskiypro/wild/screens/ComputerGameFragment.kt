package com.vishnevskiypro.wild.screens

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.vishnevskiypro.wild.R
import com.vishnevskiypro.wild.databinding.FragmentComputerGameBinding
import com.vishnevskiypro.wild.domain.OnePlayerGame

class ComputerGameFragment : Fragment() {

    private val sharedPreferences by lazy { requireActivity()
        .applicationContext.getSharedPreferences("shared_preferences", Context.MODE_PRIVATE) }

    private lateinit var binding: FragmentComputerGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComputerGameBinding.inflate(layoutInflater, container, false)

        binding.playerPaper.setOnClickListener {
            play("paper")
        }

        binding.playerScissors.setOnClickListener {
            play("scissors")
        }

        binding.playerStone.setOnClickListener {
            play("stone")
        }

        binding.tvResult.setOnClickListener {
            findNavController().navigate(
                R.id.action_computerGameFragment_to_resultFragment)
        }


        return binding.root
    }

    private fun play(playerChoice: String){
        val onePlayerGame = OnePlayerGame()
        val compChoice = OnePlayerGame.computerRandom()
        val result = onePlayerGame.playResult(playerChoice, compChoice)
        binding.tvResult.text = result

        when(result){
            "Player Win" -> {
                saveResult("Player Win")
                binding.playerLayout.setBackgroundColor(Color.BLUE)
                binding.computerLayout.setBackgroundColor(Color.RED)
            }

            "Computer Win" -> {
                saveResult("Computer Win")
                binding.playerLayout.setBackgroundColor(Color.RED)
                binding.computerLayout.setBackgroundColor(Color.BLUE)
            }

            else -> {
                saveResult("Draw")
                binding.playerLayout.setBackgroundColor(Color.GRAY)
                binding.computerLayout.setBackgroundColor(Color.GRAY)
            }
        }
    }

    private fun saveResult(whoWin: String){
        if (whoWin == "Player Win"){
            var previousScore = sharedPreferences.getInt("Player_Win", 0)
            previousScore++
            sharedPreferences.edit().putInt("Player_Win", previousScore).apply()
        } else if (whoWin == "Computer Win"){
            var previousScore = sharedPreferences.getInt("Computer_Win", 0)
            previousScore++
            sharedPreferences.edit().putInt("Computer_Win", previousScore).apply()
        } else {
            var previousScore = sharedPreferences.getInt("Draw", 0)
            previousScore++
            sharedPreferences.edit().putInt("Draw", previousScore).apply()
        }
    }

    private fun hideNotUsed(player: String, computer: String){

    }
}