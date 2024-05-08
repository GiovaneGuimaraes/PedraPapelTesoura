package com.example.pedrapapeltesoura.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val options: List<String> = listOf("Pedra", "Papel", "Tesoura", "Spock", "Lagarto")
): Parcelable
