package com.example.task6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task6.data.Data
import com.example.task6.data.ImageDocument
import com.example.task6.databinding.ListItemBinding
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class MyListAdapter(val items: MutableList<ImageDocument>) :
    RecyclerView.Adapter<MyListAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListAdapter.Holder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MyListAdapter.Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
            val item = items[position]
            val parsed = OffsetDateTime.parse(item.datetime)
            val parseDate = parsed.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            val parseTime = parsed.format(DateTimeFormatter.ofPattern("HH:mm"))

            Glide.with(it)
                .load(item.image_url)
                .into(holder.img)
            holder.title.text = item.display_sitename
            holder.date.text = parseDate
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Holder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val img = binding.imageView
        val title = binding.titleTv
        val date = binding.dateTv
    }
}