package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    private lateinit var tvFoodName: TextView
    private lateinit var etServings: EditText
    private lateinit var etName: EditText
    private lateinit var etNotes: EditText
    private lateinit var btnOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // Inisialisasi view
        tvFoodName = findViewById(R.id.tvFoodName)
        etServings = findViewById(R.id.etServings)
        etName = findViewById(R.id.etName)
        etNotes = findViewById(R.id.etNotes)
        btnOrder = findViewById(R.id.btnOrder)

        // Ambil nama makanan dari Intent dan tampilkan di TextView
        val foodName = intent.getStringExtra("foodName") ?: "Unknown Food"
        tvFoodName.text = foodName

        btnOrder.setOnClickListener {
            placeOrder(foodName) // Pass foodName to placeOrder
        }
    }

    private fun placeOrder(foodName: String) {
        //input data order
        val servings = etServings.text.toString()
        val orderingName = etName.text.toString()
        val additionalNotes = etNotes.text.toString()

        // membuat intent untuk diteruskan ke ConfirmationActivity
        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("FOOD_NAME", foodName)
            putExtra("SERVINGS", servings)
            putExtra("ORDERING_NAME", orderingName)
            putExtra("ADDITIONAL_NOTES", additionalNotes)
        }
        startActivity(intent)
    }
}
