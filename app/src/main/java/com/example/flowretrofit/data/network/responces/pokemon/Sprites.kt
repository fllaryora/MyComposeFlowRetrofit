package com.example.flowretrofit.data.network.responces.pokemon

import com.example.flowretrofit.data.network.responces.pokemon.generation.*
import com.google.gson.annotations.SerializedName


data class Sprites(
    @SerializedName("back_default")
    val backDefault: String,
    @SerializedName("back_female")
    val backFemale: Any,
    @SerializedName("back_shiny")
    val backShiny: String,
    @SerializedName("back_shiny_female")
    val backShinyFemale: Any,
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_female")
    val frontFemale: Any,
    @SerializedName("front_shiny")
    val frontShiny: String,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: Any,
    val other: Other,
    val versions: Versions
)

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)


data class DreamWorld(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_female")
    val frontFemale: Any
)

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String
)

data class Versions(
    @SerializedName("generation-i")
    val generationI: GenerationI,
    @SerializedName("generation-ii")
    val generationIi: GenerationIi,
    @SerializedName("generation-iii")
    val generationIii: GenerationIii,
    @SerializedName("generation-iv")
    val generationIv: GenerationIv,
    @SerializedName("generation-v")
    val generationV: GenerationV,
    @SerializedName("generation-vi")
    val generationVi: GenerationVi,
    @SerializedName("generation-vii")
    val generationVii: GenerationVii,
    @SerializedName("generation-viii")
    val generationViii: GenerationViii
)


