package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    private lateinit var tvFoodName: TextView // Ganti spinnerFoodName menjadi TextView untuk menampilkan nama makanan
    private lateinit var etServings: EditText
    private lateinit var etName: EditText
    private lateinit var etNotes: EditText
    private lateinit var btnOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order) // Pastikan layout sudah sesuai

        // Initialize views
        tvFoodName = findViewById(R.id.tvFoodName) // TextView untuk menampilkan nama makanan
        etServings = findViewById(R.id.etServings)
        etName = findViewById(R.id.etName)
        etNotes = findViewById(R.id.etNotes)
        btnOrder = findViewById(R.id.btnOrder)

        // Ambil nama makanan dari Intent dan tampilkan di TextView
        val foodName = intent.getStringExtra("foodName") ?: "Unknown Food"
        tvFoodName.text = foodName

        // Set the order button click listener
        btnOrder.setOnClickListener {
            placeOrder(foodName) // Pass foodName to placeOrder
        }
    }

    private fun placeOrder(foodName: String) {
        // Gather input data
        val servings = etServings.text.toString()
        val orderingName = etName.text.toString()
        val additionalNotes = etNotes.text.toString()

        // Create an intent to navigate to ConfirmationActivity
        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("FOOD_NAME", foodName)
            putExtra("SERVINGS", servings)
            putExtra("ORDERING_NAME", orderingName)
            putExtra("ADDITIONAL_NOTES", additionalNotes)
        }
        startActivity(intent)
    }
}
