package com.training.testapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User (
  @PrimaryKey
  @SerializedName("id"        ) var id        : Int?     = null,
  @SerializedName("title"     ) var title     : String?  = null,
  @SerializedName("completed" ) var completed : Boolean? = null

)