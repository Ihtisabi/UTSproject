package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    companion object {
        lateinit var foodListStatic: List<Food>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cheese Cake", "Cheesecake lembut dan creamy yang menggoda", R.drawable.cheesecake),
            Food("Cireng", "Cireng crispy khas Sunda yang gurih, cocok untuk camilan", R.drawable.cireng),
            Food("Donut", "Donut empuk dengan berbagai varian rasa yang manis", R.drawable.donut),
            Food("Kopi Hitam", "Kopi hitam seduh nikmat, sempurna untuk memulai hari", R.drawable.kopi_hitam),
            Food("Mie Goreng", "Mie goreng bumbu kaya, pedas dan menggugah selera", R.drawable.mie_goreng),
            Food("Nasi Goreng", "Nasi goreng spesial dengan bumbu kaya, nikmat dan mengenyangkan", R.drawable.nasigoreng),
            Food("Sparkling Tea", "Teh yang menyegarkan di setiap tegukan", R.drawable.sparkling_tea)
        )

        foodListStatic = foodList

        // Inisialisasi FoodAdapter dengan fungsi lambda untuk menangani klik item
        adapter = FoodAdapter(foodList) { food ->
            val intent = Intent(this, OrderActivity::class.java).apply {
                putExtra("foodName", food.name) // Kirim nama makanan yang diklik ke OrderActivity
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
