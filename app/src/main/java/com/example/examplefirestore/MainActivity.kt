package com.example.examplefirestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.examplefirestore.databinding.ActivityMainBinding

const val TAG = "FIRESTORE"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        uploadData()
    }

    private fun uploadData() {
        binding!!.btnUploadData.setOnClickListener{

            val hashMap = hashMapOf<String, Any>(
                "name" to "Janko Muzykant",
                "city" to "Szczecin",
                "age" to 24
            )

            FirebaseUtils().fireStoreDatabase.collection("users")
                .add(hashMap)
                .addOnSuccessListener {
                    Log.d(TAG, "OK")
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "$exception")
                }
        }
    }
}