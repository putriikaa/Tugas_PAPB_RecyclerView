package com.example.tugas_p10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class PahlawanAdapter(private val pahlawanList: List<Pahlawan>, private val onClickPahlawan: (Pahlawan) -> Unit) :
    RecyclerView.Adapter<PahlawanAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ShapeableImageView = itemView.findViewById(R.id.title_image)
        val heading: TextView = itemView.findViewById(R.id.heading)
        val subheading: TextView = itemView.findViewById(R.id.subheading)
        val ttl: TextView = itemView.findViewById(R.id.ttl)

        fun bind(pahlawan: Pahlawan) {
            titleImage.setImageResource(pahlawan.titleImage)
            heading.text = pahlawan.heading
            subheading.text = pahlawan.subheading
            ttl.text = pahlawan.ttl

            itemView.setOnClickListener {
                onClickPahlawan(pahlawan)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return pahlawanList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = pahlawanList[position]
        holder.bind(currentItem)
    }
}
