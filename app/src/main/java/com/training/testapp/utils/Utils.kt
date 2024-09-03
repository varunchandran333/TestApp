package com.training.testapp.utils

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.training.testapp.data.model.User
import java.io.BufferedReader
import java.io.InputStreamReader

fun readJsonFromAssets(context: Context, path: String): String {
    val identifier = "[ReadJSON]"
    try {
        val file = context.assets.open(path)
        Log.i(
            identifier,
            "Found File: $file.",
        )
        val bufferedReader = BufferedReader(InputStreamReader(file))
        val stringBuilder = StringBuilder()
        bufferedReader.useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
            }
        }
        Log.i(
            identifier,
            "getJSON  stringBuilder: $stringBuilder.",
        )
        val jsonString = stringBuilder.toString()
        Log.i(
            identifier,
            "JSON as String: $jsonString.",
        )
        return jsonString
    } catch (e: Exception) {
        Log.e(
            identifier,
            "Error reading JSON: $e.",
        )
        e.printStackTrace()
        return ""
    }
}

fun getUsersData(context: Context):List<User>{
    val gson = Gson()
    val type = object : TypeToken<List<User>>() {}.type
    val jsonString = readJsonFromAssets(context, "user.json")
    return gson.fromJson(jsonString, type)
}