package com.example.pedrapapeltesoura.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    var pedra: Int = 0,
    var papel: Int = 0,
    var tesoura: Int = 0,
): Parcelable
