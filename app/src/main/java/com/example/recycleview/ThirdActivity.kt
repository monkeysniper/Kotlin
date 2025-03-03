package com.example.recycleview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var recyclerView1: RecyclerView? = null
    private var binding: ActivityThirdBinding? = null
    private var adapter: Adapter? = null
    private var modelAdapter: ModelAdapter? = null
    private var list: MutableList<Model>? = null
    private var list1: ArrayList<Model2>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        this.enableEdgeToEdge()
        setContentView(binding!!.root)

        recyclerView = findViewById(R.id.rv)
        recyclerView1 = binding?.rv1

        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        list = ArrayList()
        list?.apply {
            add(Model(R.drawable.ic_burger, "Burger", R.drawable.border3))
            add(Model(R.drawable.ic_pizza1, "Pizza", R.drawable.border3))
            add(Model(R.drawable.ic_chicken, "Chicken", R.drawable.border3))
        }

        list1 = ArrayList()
        list1?.apply {
            add(
                Model2(
                    R.drawable.border4, R.drawable.star, R.drawable.star, R.drawable.star,
                    R.drawable.star, R.drawable.star, R.drawable.burger1, "Salad Burger"
                )
            )
            add(
                Model2(
                    R.drawable.border4, R.drawable.star, R.drawable.star, R.drawable.star,
                    R.drawable.star, R.drawable.star, R.drawable.burger1, "Salad Burger"
                )
            )
            add(
                Model2(
                    R.drawable.border4, R.drawable.star, R.drawable.star, R.drawable.star,
                    R.drawable.star, R.drawable.star, R.drawable.burger1, "Salad Burger"
                )
            )
            add(
                Model2(
                    R.drawable.border4, R.drawable.star, R.drawable.star, R.drawable.star,
                    R.drawable.star, R.drawable.star, R.drawable.burger1, "Salad Burger"
                )
            )
        }

        // Установка адаптеров
        adapter = Adapter(list as ArrayList<Model>)
        modelAdapter = ModelAdapter(list1!!)

        recyclerView?.adapter = adapter
        recyclerView1?.adapter = modelAdapter

        // Поиск по строке
        binding?.searchBar?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                adapter?.moveItemToTopByName(s.toString().trim { it <= ' ' })
            }
        })
    }
}