package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import paba.nit2x.explisitintent.Pegawai

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var _btnExplisit1 = findViewById<Button>(R.id.btnExplisit1)
        val _dataKirim = findViewById<EditText>(R.id.dataKirim)
        val _btnExplisit2 = findViewById<Button>(R.id.btnExplisit2)

        val isiPegawai: ArrayList<Pegawai> = arrayListOf()

        isiPegawai.add(Pegawai(1, "Anita", "Test"))
        isiPegawai.add(Pegawai(1, "Tatik", "Marketing"))

        val _btnExplisit3 = findViewById<Button>(R.id.btnExplisit3)
        _btnExplisit3.setOnClickListener {
            val intentWithData = Intent(
                this@MainActivity,
                MainActivity4::class.java
            ).apply {
                putExtra(MainActivity4.dataPegawai, isiPegawai)
            }
            startActivity(intentWithData)

        }


        _btnExplisit1.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                MainActivity2::class.java

            )

            _btnExplisit2.setOnClickListener {
                val intentWithData = Intent(
                    this@MainActivity,
                    MainActivity3::class.java
                ).apply {
                    putExtra(MainActivity3.dataTerima, _dataKirim.text.toString())
                }
                startActivity(
                    intentWithData
                )

            }

        }


    }

    private lateinit var _returnHasil: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()

    ) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            val selectedItem = result.data?.getStringExtra(
                MainActivity5.SelectedItem
            )
            _returnHasil.text = selectedItem

        }

    }

}