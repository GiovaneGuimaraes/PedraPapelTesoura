package com.example.pedrapapeltesoura.ui
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.R
import com.example.pedrapapeltesoura.databinding.GameChooseBinding
import com.example.pedrapapeltesoura.model.Game


class GameWithTwoPlayers: AppCompatActivity() {
    private val acb: GameChooseBinding by lazy {
        GameChooseBinding.inflate(layoutInflater)
    }

    private val game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)
        acb.toolbarIn.toolbar.apply {
            subtitle = this@GameWithTwoPlayers.javaClass.simpleName
            setSupportActionBar(this)
        }

        val textBox = findViewById<TextView>(R.id.textBox)
        val buttonRock = acb.buttonRock
        val buttonPaper = acb.buttonPaper
        val buttonScissor = acb.buttonScissor
        val buttonSpock = acb.buttonSpock
        val buttonLizard = acb.buttonLizard

        buttonRock.setOnClickListener { playGame("Pedra") }
        buttonPaper.setOnClickListener { playGame("Papel") }
        buttonScissor.setOnClickListener { playGame("Tesoura") }
        buttonSpock.setOnClickListener { playGame("Spock")}
        buttonLizard.setOnClickListener { playGame("Lagarto")}
    }

    private fun playGame(playerChoice: String) {
        val computerChoice = game.options.random()

        val result = "Você escolheu $playerChoice\nO computador escolheu $computerChoice"
        val textBox = findViewById<TextView>(R.id.textBox)
        textBox.text = result

        val winner = determineWinner(playerChoice, computerChoice)
        textBox.append("\n$winner")
    }

    private fun determineWinner(playerChoice: String, computerChoice: String): String {
        return when {
            playerChoice == computerChoice -> "Empate!"
            playerChoice == "Pedra" && computerChoice == "Tesoura" ||
                    playerChoice == "Pedra" && computerChoice == "Lagarto" ||
                    playerChoice == "Papel" && computerChoice == "Pedra" ||
                    playerChoice == "Papel" && computerChoice == "Spock" ||
                    playerChoice == "Tesoura" && computerChoice == "Papel" ||
                    playerChoice == "Tesoura" && computerChoice == "Lagarto" ||
                    playerChoice == "Lagarto" && computerChoice == "Papel" ||
                    playerChoice == "Lagarto" && computerChoice == "Spock" ||
                    playerChoice == "Spock" && computerChoice == "Pedra" ||
                    playerChoice == "Spock" && computerChoice == "Tesoura" -> "Você venceu!"
            else -> "Você perdeu!"
        }
    }
}