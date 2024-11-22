package com.example.chargemap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val emailField: EditText = findViewById(R.id.editTextTextEmailAddress)
        val passwordField: EditText = findViewById(R.id.editTextTextPassword)
        val buttonConcluido: Button = findViewById(R.id.buttonConcluido)
        val buttonVoltar: Button = findViewById(R.id.buttonVoltar)


        val db = FirebaseFirestore.getInstance()

        // Botão "Concluído" para salvar no Firebase
        buttonConcluido.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Validar entrada de dados
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

            // Salvar no Firestore
            val user = hashMapOf(
                "email" to email,
                "senha" to password
            )

            db.collection("Usuarios")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Cadastro concluído com sucesso!", Toast.LENGTH_SHORT).show()
                    // Navegar para tela de login
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erro ao cadastrar: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }

        buttonVoltar.setOnClickListener {
            finish() // Volta para a tela anterior
        }
    }
}
