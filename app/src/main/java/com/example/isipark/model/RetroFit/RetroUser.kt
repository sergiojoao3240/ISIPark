package com.example.isipark.model.RetroFit

import com.google.gson.annotations.SerializedName

data class RetroUser(@SerializedName("id") val id: Int,
                     @SerializedName("nome") val name: String,
                     @SerializedName("nif") val nif: Int,
                     @SerializedName("DataNasc") val birthDate: String,
                     @SerializedName("genero") val gender: String,
                     @SerializedName("tipo_utilizadorid") val typeUserID: Int,
                     @SerializedName("Moradaid_morada") val addressID: Int,
                     @SerializedName("email") val email: String,
                     @SerializedName("password") val password: String,
                     @SerializedName("token") val token: String) {
}