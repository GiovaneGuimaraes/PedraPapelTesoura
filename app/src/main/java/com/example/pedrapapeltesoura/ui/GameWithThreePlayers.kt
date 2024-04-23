package com.example.pedrapapeltesoura.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.R
import com.example.pedrapapeltesoura.databinding.GameChooseBinding
import com.example.pedrapapeltesoura.model.Game

class GameWithThreePlayers: AppCompatActivity() {
    private val gcb: GameChooseBinding by lazy {
        GameChooseBinding.inflate(layoutInflater)
    }

    private val game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(gcb.root)
        gcb.toolbarIn.toolbar.apply {
            subtitle = this@GameWithThreePlayers.javaClass.simpleName
            setSupportActionBar(this)
        }

        val textBox = findViewById<TextView>(R.id.textBox)
        val buttonRock = gcb.buttonRock
        val buttonPaper = gcb.buttonPaper
        val buttonScissor = gcb.buttonScissor

        buttonRock.setOnClickListener { playGame("Pedra") }
        buttonPaper.setOnClickListener { playGame("Papel") }
        buttonScissor.setOnClickListener { playGame("Tesoura") }
    }

    private fun playGame(playerChoice: String) {
        val computerOneChoice = game.options.random()
        val computerTwoChoice = game.options.random()

        val result = "Você escolheu $playerChoice\nO computador 1 escolheu $computerOneChoice \n" +
                "O computador 2 escolheu $computerTwoChoice"
        val textBox = findViewById<TextView>(R.id.textBox)
        textBox.text = result

        val winner = determineWinner(playerChoice, computerOneChoice, computerTwoChoice)
        textBox.append("\n$winner")
    }

    private fun determineWinner(playerChoice: String, computerOneChoice: String, computerTwoChoice: String): String {
        return when {
            // mesma escolha
            playerChoice == computerOneChoice && playerChoice == computerTwoChoice -> "Empate!"
            // ninguem ganha
            playerChoice == "Pedra" && computerOneChoice == "Tesoura" && computerTwoChoice == "Papel" -> "Empate!"
            playerChoice == "Pedra" && computerOneChoice == "Papel" && computerTwoChoice == "Tesoura" -> "Empate!"
            playerChoice == "Papel" && computerOneChoice == "Pedra" && computerTwoChoice == "Tesoura" -> "Empate!"
            playerChoice == "Papel" && computerOneChoice == "Tesoura" && computerTwoChoice == "Pedra" -> "Empate!"
            playerChoice == "Tesoura" && computerOneChoice == "Papel" && computerTwoChoice == "Pedra" -> "Empate!"
            playerChoice == "Tesoura" && computerOneChoice == "Pedra" && computerTwoChoice == "Papel" -> "Empate!"
            // 'vencedores' com o mesmo resultado
            playerChoice == "Pedra" && computerOneChoice == "Pedra" && computerTwoChoice == "Tesoura" -> "Empate!"
            playerChoice == "Tesoura" && computerOneChoice == "Pedra" && computerTwoChoice == "Pedra" -> "Empate!"
            playerChoice == "Pedra" && computerOneChoice == "Tesoura" && computerTwoChoice == "Pedra" -> "Empate!"
            playerChoice == "Papel" && computerOneChoice == "Papel" && computerTwoChoice == "Pedra" -> "Empate!"
            playerChoice == "Pedra" && computerOneChoice == "Papel" && computerTwoChoice == "Papel" -> "Empate!"
            playerChoice == "Papel" && computerOneChoice == "Pedra" && computerTwoChoice == "Papel" -> "Empate!"
            playerChoice == "Tesoura" && computerOneChoice == "Tesoura" && computerTwoChoice == "Papel" -> "Empate!"
            playerChoice == "Papel" && computerOneChoice == "Tesoura" && computerTwoChoice == "Tesoura" -> "Empate!"
            playerChoice == "Tesoura" && computerOneChoice == "Papel" && computerTwoChoice == "Tesoura" -> "Empate!"
            // ganhar
            playerChoice == "Pedra" && computerOneChoice == "Tesoura" && computerTwoChoice == "Tesoura"||
                    playerChoice == "Papel" && computerOneChoice == "Pedra" && computerTwoChoice == "Pedra"||
                    playerChoice == "Tesoura" && computerOneChoice == "Papel" && computerTwoChoice == "Papel "-> "Você venceu!"
            else -> "Você perdeu!"
        }
    }
}