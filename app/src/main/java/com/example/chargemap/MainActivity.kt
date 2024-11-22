package com.example.chargemap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.FirebaseApp

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

        // Inicializa o Firebase
        FirebaseApp.initializeApp(this)

        // Configuração dos botões
        val cadastroButton = findViewById<Button>(R.id.buttonCadastro)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val inicioButton = findViewById<Button>(R.id.buttonInicio)

        cadastroButton.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        inicioButton.setOnClickListener {
            val intent = Intent(this, MapaActivity::class.java)
            startActivity(intent)
        }
    }
}
