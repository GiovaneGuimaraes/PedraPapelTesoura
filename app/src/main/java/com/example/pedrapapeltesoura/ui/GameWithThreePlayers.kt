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
        val buttonSpock = gcb.buttonSpock
        val buttonLizard = gcb.buttonLizard

        buttonRock.setOnClickListener { playGame("Pedra") }
        buttonPaper.setOnClickListener { playGame("Papel") }
        buttonScissor.setOnClickListener { playGame("Tesoura") }
        buttonSpock.setOnClickListener { playGame("Spock")}
        buttonLizard.setOnClickListener { playGame("Lagarto")}
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
            // ninguem ganha escolhendo pedra
            playerChoice == "Pedra" && computerOneChoice == "Pedra" && computerTwoChoice == "Pedra" ||
            playerChoice == "Pedra" && computerOneChoice == "Tesoura" && computerTwoChoice == "Papel" ||
            playerChoice == "Pedra" && computerOneChoice == "Papel" && computerTwoChoice == "Tesoura" ||
            playerChoice == "Pedra" && computerOneChoice == "Lagarto" && computerTwoChoice == "Papel" ||
            playerChoice == "Pedra" && computerOneChoice == "Lagarto" && computerTwoChoice == "Spock" ||
            playerChoice == "Pedra" && computerOneChoice == "Spock" && computerTwoChoice == "Lagarto" ||
            playerChoice == "Pedra" && computerOneChoice == "Spock" && computerTwoChoice == "Tesoura" -> "Empate!"

            // ninguem ganha escolhendo papel
            playerChoice == "Papel" && computerOneChoice == "Papel" && computerTwoChoice == "Papel" ||
            playerChoice == "Papel" && computerOneChoice == "Pedra" && computerTwoChoice == "Tesoura" ||
            playerChoice == "Papel" && computerOneChoice == "Pedra" && computerTwoChoice == "Lagarto" ||
            playerChoice == "Papel" && computerOneChoice == "Tesoura" && computerTwoChoice == "Pedra" ||
            playerChoice == "Papel" && computerOneChoice == "Tesoura" && computerTwoChoice == "Spock" ||
            playerChoice == "Papel" && computerOneChoice == "Lagarto" && computerTwoChoice == "Spock" ||
            playerChoice == "Papel" && computerOneChoice == "Lagarto" && computerTwoChoice == "Pedra" ||
            playerChoice == "Papel" && computerOneChoice == "Spock" && computerTwoChoice == "Tesoura" ||
            playerChoice == "Papel" && computerOneChoice == "Spock" && computerTwoChoice == "Lagarto" -> "Empate!"

            //ninguem ganha escolhendo tesoura
            playerChoice == "Tesoura" && computerOneChoice == "Tesoura" && computerTwoChoice == "Tesoura" ||
            playerChoice == "Tesoura" && computerOneChoice == "Papel" && computerTwoChoice == "Pedra" ||
            playerChoice == "Tesoura" && computerOneChoice == "Papel" && computerTwoChoice == "Spock" ||
            playerChoice == "Tesoura" && computerOneChoice == "Pedra" && computerTwoChoice == "Lagarto" ||
            playerChoice == "Tesoura" && computerOneChoice == "Pedra" && computerTwoChoice == "Papel" ||
            playerChoice == "Tesoura" && computerOneChoice == "Lagarto" && computerTwoChoice == "Pedra" ||
            playerChoice == "Tesoura" && computerOneChoice == "Lagarto" && computerTwoChoice == "Spock" ||
            playerChoice == "Tesoura" && computerOneChoice == "Spock" && computerTwoChoice == "Papel" ||
            playerChoice == "Tesoura" && computerOneChoice == "Spock" && computerTwoChoice == "Lagarto" -> "Empate!"

            //ninguem ganha escolhendo lagarto
            playerChoice == "Lagarto" && computerOneChoice == "Lagarto" && computerTwoChoice == "Lagarto" ||
            playerChoice == "Lagarto" && computerOneChoice == "Papel" && computerTwoChoice == "Pedra" ||
            playerChoice == "Lagarto" && computerOneChoice == "Papel" && computerTwoChoice == "Tesoura" ||
            playerChoice == "Lagarto" && computerOneChoice == "Spock" && computerTwoChoice == "Tesoura" ||
            playerChoice == "Lagarto" && computerOneChoice == "Spock" && computerTwoChoice == "Pedra" ||
            playerChoice == "Lagarto" && computerOneChoice == "Tesoura" && computerTwoChoice == "Papel" ||
            playerChoice == "Tesoura" && computerOneChoice == "Tesoura" && computerTwoChoice == "Spock" ||
            playerChoice == "Tesoura" && computerOneChoice == "Pedra" && computerTwoChoice == "Papel" ||
            playerChoice == "Tesoura" && computerOneChoice == "Pedra" && computerTwoChoice == "Spock" -> "Empate!"

            //ninguem ganha escolhendo spock
            playerChoice == "Spock" && computerOneChoice == "Spock" && computerTwoChoice == "Spock" ||
            playerChoice == "Spock" && computerOneChoice == "Pedra" && computerTwoChoice == "Papel" ||
            playerChoice == "Spock" && computerOneChoice == "Pedra" && computerTwoChoice == "Lagarto" ||
            playerChoice == "Spock" && computerOneChoice == "Tesoura" && computerTwoChoice == "Papel" ||
            playerChoice == "Spock" && computerOneChoice == "Tesoura" && computerTwoChoice == "Lagarto" ||
            playerChoice == "Spock" && computerOneChoice == "Papel" && computerTwoChoice == "Pedra" ||
            playerChoice == "Spock" && computerOneChoice == "Papel" && computerTwoChoice == "Tesoura" ||
            playerChoice == "Spock" && computerOneChoice == "Lagarto" && computerTwoChoice == "Pedra" ||
            playerChoice == "Spock" && computerOneChoice == "Lagarto" && computerTwoChoice == "Tesoura" -> "Empate!"


            // empate pelo mesmo resultado
            playerChoice == "Pedra" && computerOneChoice == "Pedra" && computerTwoChoice == "Tesoura" -> "Empate!"
            playerChoice == "Pedra" && computerOneChoice == "Pedra" && computerTwoChoice == "Lagarto" -> "Empate!"
            playerChoice == "Papel" && computerOneChoice == "Papel" && computerTwoChoice == "Pedra" -> "Empate!"
            playerChoice == "Papel" && computerOneChoice == "Papel" && computerTwoChoice == "Spock" -> "Empate!"
            playerChoice == "Tesoura" && computerOneChoice == "Tesoura" && computerTwoChoice == "Papel" -> "Empate!"
            playerChoice == "Tesoura" && computerOneChoice == "Tesoura" && computerTwoChoice == "Lagarto" -> "Empate!"
            playerChoice == "Lagarto" && computerOneChoice == "Lagarto" && computerTwoChoice == "Papel" -> "Empate!"
            playerChoice == "Lagarto" && computerOneChoice == "Lagarto" && computerTwoChoice == "Spock" -> "Empate!"
            playerChoice == "Spock" && computerOneChoice == "Spock" && computerTwoChoice == "Pedra" -> "Empate!"
            playerChoice == "Spock" && computerOneChoice == "Spock" && computerTwoChoice == "Tesoura" -> "Empate!"

            // ganhar
            playerChoice == "Pedra" && computerOneChoice == "Tesoura" && computerTwoChoice == "Tesoura" -> "Você venceu!"
            playerChoice == "Pedra" && computerOneChoice == "Lagarto" && computerTwoChoice == "Lagarto" -> "Você venceu!"
            playerChoice == "Pedra" && computerOneChoice == "Tesoura" && computerTwoChoice == "Lagarto" -> "Você venceu!"
            playerChoice == "Pedra" && computerOneChoice == "Lagarto" && computerTwoChoice == "Tesoura" -> "Você venceu!"

            playerChoice == "Papel" && computerOneChoice == "Pedra" && computerTwoChoice == "Pedra" -> "Você venceu!"
            playerChoice == "Papel" && computerOneChoice == "Spock" && computerTwoChoice == "Spock" -> "Você venceu!"
            playerChoice == "Papel" && computerOneChoice == "Spock" && computerTwoChoice == "Pedra" -> "Você venceu!"
            playerChoice == "Papel" && computerOneChoice == "Pedra" && computerTwoChoice == "Spock" -> "Você venceu!"

            playerChoice == "Tesoura" && computerOneChoice == "Papel" && computerTwoChoice == "Papel" -> "Você venceu!"
            playerChoice == "Tesoura" && computerOneChoice == "Lagarto" && computerTwoChoice == "Lagarto" -> "Você venceu!"
            playerChoice == "Tesoura" && computerOneChoice == "Papel" && computerTwoChoice == "Lagarto" -> "Você venceu!"
            playerChoice == "Tesoura" && computerOneChoice == "Lagarto" && computerTwoChoice == "Papel" -> "Você venceu!"

            playerChoice == "Lagarto" && computerOneChoice == "Papel" && computerTwoChoice == "Papel" -> "Você venceu!"
            playerChoice == "Lagarto" && computerOneChoice == "Spock" && computerTwoChoice == "Spock" -> "Você venceu!"
            playerChoice == "Lagarto" && computerOneChoice == "Papel" && computerTwoChoice == "Spock" -> "Você venceu!"
            playerChoice == "Lagarto" && computerOneChoice == "Spock" && computerTwoChoice == "Papel" -> "Você venceu!"

            playerChoice == "Spock" && computerOneChoice == "Tesoura" && computerTwoChoice == "Tesoura" -> "Você venceu!"
            playerChoice == "Spock" && computerOneChoice == "Pedra" && computerTwoChoice == "Pedra" -> "Você venceu!"
            playerChoice == "Spock" && computerOneChoice == "Tesoura" && computerTwoChoice == "Pedra" -> "Você venceu!"
            playerChoice == "Spock" && computerOneChoice == "Pedra" && computerTwoChoice == "Tesoura" -> "Você venceu!"

            else -> "Você perdeu!"
        }
    }
}