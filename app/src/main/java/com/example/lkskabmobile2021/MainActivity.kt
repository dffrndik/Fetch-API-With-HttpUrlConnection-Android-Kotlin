package com.example.lkskabmobile2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.example.lkskabmobile2021.adapter.EmpAdapter
import com.example.lkskabmobile2021.databinding.ActivityMainBinding
import com.example.lkskabmobile2021.model.EmpModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding
    lateinit var jsonString : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchAPI()
        val listView : ListView = binding.listView
        val adapter = EmpAdapter(this, parseJSON(jsonString))
        listView.adapter = adapter

    }
    fun fetchAPI() = runBlocking{
        launch(Dispatchers.IO) {
            val conn = URL("https://raw.githubusercontent.com/dffrndik/Fetch-API-With-HttpUrlConnection-Android-Kotlin/master/soal_mobile.json").openConnection() as HttpURLConnection
            val data = conn.inputStream.bufferedReader().readText()
            jsonString = data
        }
    }
    fun parseJSON(jsonString : String): MutableList<EmpModel> {
        val jsonObject = JSONObject(jsonString)
        val jsonArray = jsonObject.getJSONArray("item")
        val list : MutableList<EmpModel> = mutableListOf()
        for (i in 0 until jsonArray.length()){
            val jsonOutputObject = jsonArray.getJSONObject(i)
            list.add( EmpModel(
                jsonOutputObject.getString("employeeid"),
                jsonOutputObject.getString("nama"),
                jsonOutputObject.getString("position"),
            ))
        }
        return list
    }

}
