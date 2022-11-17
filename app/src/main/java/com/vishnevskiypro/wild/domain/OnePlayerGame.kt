package com.vishnevskiypro.wild.domain

class OnePlayerGame() {

    fun playResult(playerChoice: String, computerChoice: String) =
        when{
            playerChoice == "stone" && computerChoice == "scissors" -> "Player Win"
            playerChoice == "scissors" && computerChoice == "paper" -> "Player Win"
            playerChoice == "paper" && computerChoice == "stone" -> "Player Win"

            computerChoice == "stone" && playerChoice == "scissors" -> "Computer Win"
            computerChoice == "scissors" && playerChoice == "paper" -> "Computer Win"
            computerChoice == "paper" && playerChoice == "stone" -> "Computer Win"

            else -> "Draw"
        }

    companion object{
        val listForComputer = listOf("paper", "scissors", "stone")

        fun computerRandom(): String{
            val randomNumber = (0..2).random()
            return listForComputer[randomNumber]
        }
    }
}