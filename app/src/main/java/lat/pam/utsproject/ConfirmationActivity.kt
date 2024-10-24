package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var tvFoodName: TextView
    private lateinit var tvNumberOfServings: TextView
    private lateinit var tvOrderingName: TextView
    private lateinit var tvAdditionalNotes: TextView
    private lateinit var backToMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Inisialisasi komponen tampilan
        tvFoodName = findViewById(R.id.tvFoodName)
        tvNumberOfServings = findViewById(R.id.tvNumberOfServings)
        tvOrderingName = findViewById(R.id.tvOrderingName)
        tvAdditionalNotes = findViewById(R.id.tvAdditionalNotes)
        backToMenu = findViewById(R.id.backtoMenu)

        // Ambil data yang dikirimkan dari OrderActivity
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "N/A"
        val servings = intent.getStringExtra("SERVINGS") ?: "0"
        val orderingName = intent.getStringExtra("ORDERING_NAME") ?: "N/A"
        val additionalNotes = intent.getStringExtra("ADDITIONAL_NOTES") ?: "N/A"

        // Atur tampilan TextViews dengan data pesanan
        tvFoodName.text = "Food Name: $foodName"
        tvNumberOfServings.text = "Number of Servings: $servings"
        tvOrderingName.text = "Ordering Name: $orderingName"
        tvAdditionalNotes.text = "Additional Notes: $additionalNotes"

        // Pengaturan tombol kembali ke menu
        backToMenu.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
            finish() // Menutup ConfirmationActivity setelah kembali ke ListFoodActivity
        }
    }
}
