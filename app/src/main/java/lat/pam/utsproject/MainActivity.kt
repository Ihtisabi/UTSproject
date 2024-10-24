package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvRegister = findViewById(R.id.tvRegister)

        btnLogin.setOnClickListener {
            loginUser()
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Memeriksa status pendaftaran dari SharedPreferences
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val isRegistered = sharedPreferences.getBoolean("isRegistered", false)

        if (!isRegistered) {
            Toast.makeText(this, "Please register before logging in.", Toast.LENGTH_SHORT).show()
            return
        }

        // Ambil data username dan password yang disimpan
        val savedUsername = sharedPreferences.getString("username", null)
        val savedPassword = sharedPreferences.getString("password", null)

        // Logika login yang diperbaiki
        if (username == savedUsername && password == savedPassword) {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish() // Menutup MainActivity
        } else {
            Toast.makeText(this, "Login Failed. Invalid username or password.", Toast.LENGTH_SHORT).show()
        }
    }

}
