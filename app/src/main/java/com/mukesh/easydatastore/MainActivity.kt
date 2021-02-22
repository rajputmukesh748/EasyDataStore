package com.mukesh.easydatastore

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.mukesh.easydatastoremethods.calldatastore.CallDataStore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onResume() {
        super.onResume()

        findViewById<Button>(R.id.btAddData).setOnClickListener {
            val storeData = findViewById<EditText>(R.id.etTextView).text.trim().toString()
            CallDataStore.storeData(key = STRING_KEY, storeData = storeData)
            CallDataStore.getPreferenceData(STRING_KEY){
                Log.e("skdnaskndkasdasd", "${it}")
            }
        }
    }

}