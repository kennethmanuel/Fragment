package com.kennethmanuel.week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var events = arrayListOf(
        Event(1, "ILPC", "Lomba programming", R.drawable.programming, "08/01/2021", 25, 10),
        Event(2, "MANIAC", "Lomba Multimedia", R.drawable.mm, "25/07/2021", 17, 5),
        Event(3, "ICF", "Pameran karya mahasiswa", R.drawable.project, "25/07/2021", 17, 3)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buat dulu EventFragmentList
        var eventFragment = EventFragmentList.newInstance(events)
        // Buat transaksi
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, eventFragment)
            commit()
        }
    }
}