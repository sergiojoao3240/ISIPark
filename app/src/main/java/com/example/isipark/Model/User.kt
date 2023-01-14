package com.example.isipark.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user")
data class User(@PrimaryKey(autoGenerate = true) val id: Int = 0 ,
                val name: String?, val nif: Int?, val birthDate: String?,
                val gender: String?, val typeUserID: Int?,
                val addressID: Int?, val email: String?,
                val password: String?, val passwordHash: String?,
                val passwordSalt: String?,
                var token: String?) {
}