package com.example.pedrapapeltesoura.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pedrapapeltesoura.databinding.GameChooseBinding


class GameWithTwoPlayers: AppCompatActivity() {
    private val acb: GameChooseBinding by lazy {
        GameChooseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)
        acb.toolbarIn.toolbar.apply {
            subtitle = this@GameWithTwoPlayers.javaClass.simpleName
            setSupportActionBar(this)
        }
    }
}