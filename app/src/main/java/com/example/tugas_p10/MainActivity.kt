package com.example.tugas_p10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Pahlawan>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var subheading : Array<String>
    lateinit var ttl : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.cutnyakmeutia,
            R.drawable.pattimura,
            R.drawable.soekarno,
            R.drawable.antasari,
            R.drawable.cutnyakdien,
            R.drawable.sisinga,
            R.drawable.teukumar,
            R.drawable.imam,
            R.drawable.diponegoro
        )

        heading = arrayOf(
            "Cut Nyak Meutia",
            "Kapiten Pattimura",
            "Ir.Soekarno",
            "Pangeran Antasari",
            "Cut Nyak Dien",
            "Sisingamangaraja XII",
            "Teuku Umar",
            "Imamku Tuan Bonjol",
            "Pangeran Diponegoro"
        )

        subheading = arrayOf(
            "Pahlawan Aceh",
            "Pahlawan Maluku",
            "Proklamator Kemerdekaan",
            "Pahlawan Kalimantan Selatan",
            "Pahlawan Aceh",
            "Pahlawan Batak",
            "Pahlawan Aceh",
            "Pahlawan Sumatera Barat",
            "Pahlawan Mataram"

        )

        ttl = arrayOf(
            "Lahir pada 1870 di Aceh, Sumatera",
            "Lahir pada tanggal 8 Juni 1783 di Pulau Saparua, Maluku ",
            "Lahir pada tanggal 6 Juni 1901 di Blitar, Jawa Timur",
            "Lahir pada tahun 1809 di Banjarmasin.",
            "lahir pada tahun 1848 di Lampisang, Aceh, Sumatera",
            "Lahir pada tanggal 27 September 1849 di Tapanuli, Sumatera Utara",
            "Lahir pada tanggal 15 Februari 1854 di Meulaboh, Aceh Barat",
            "Lahir pada tahun 1772 di Sumatera Barat",
            "Lahir pada tanggal 11 November 1785"
        )

        newRecyclerView = findViewById(R.id.rv_disaster)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Pahlawan>()
        getUserData()

        val adapter = PahlawanAdapter(newArrayList) { pahlawan ->
            val message = "Anda klik pada ${pahlawan.heading} - ${pahlawan.subheading}"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        newRecyclerView.adapter = adapter
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val pahlawan = Pahlawan(imageId[i], heading[i], subheading[i], ttl[i])
            newArrayList.add(pahlawan)
        }
    }
}
