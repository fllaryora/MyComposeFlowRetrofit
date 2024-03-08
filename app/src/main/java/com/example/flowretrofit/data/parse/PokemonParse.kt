package com.example.flowretrofit.data.parse

import androidx.compose.ui.graphics.Color
import com.example.flowretrofit.data.network.responces.pokemon.Stat
import com.example.flowretrofit.data.network.responces.pokemon.Type
import com.example.flowretrofit.ui.theme.AtkColor
import com.example.flowretrofit.ui.theme.DefColor
import com.example.flowretrofit.ui.theme.HPColor
import com.example.flowretrofit.ui.theme.SpAtkColor
import com.example.flowretrofit.ui.theme.SpDefColor
import com.example.flowretrofit.ui.theme.SpdColor
import com.example.flowretrofit.ui.theme.TypeBug
import com.example.flowretrofit.ui.theme.TypeDark
import com.example.flowretrofit.ui.theme.TypeDragon
import com.example.flowretrofit.ui.theme.TypeElectric
import com.example.flowretrofit.ui.theme.TypeFairy
import com.example.flowretrofit.ui.theme.TypeFighting
import com.example.flowretrofit.ui.theme.TypeFire
import com.example.flowretrofit.ui.theme.TypeFlying
import com.example.flowretrofit.ui.theme.TypeGhost
import com.example.flowretrofit.ui.theme.TypeGrass
import com.example.flowretrofit.ui.theme.TypeGround
import com.example.flowretrofit.ui.theme.TypeIce
import com.example.flowretrofit.ui.theme.TypeNormal
import com.example.flowretrofit.ui.theme.TypePoison
import com.example.flowretrofit.ui.theme.TypePsychic
import com.example.flowretrofit.ui.theme.TypeRock
import com.example.flowretrofit.ui.theme.TypeSteel
import com.example.flowretrofit.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}

