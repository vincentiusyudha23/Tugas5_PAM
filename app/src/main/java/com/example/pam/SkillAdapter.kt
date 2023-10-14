package com.example.pam

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pam.databinding.ItemSkillListBinding


class SkillAdapter (
    data: ArrayList<String>,
    val onItemClick: (String) -> Unit
    ): RecyclerView.Adapter<SkillAdapter.MyViewHolder>(){

    private var filteredSkill: ArrayList<String>

    init {
        filteredSkill = data
    }

    inner class MyViewHolder(private val binding: ItemSkillListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(text: String){
            binding.tvSkill.text = text
            binding.root.setOnClickListener{
                onItemClick(text)
            }
        }
    }

    fun setfilteredList(data: ArrayList<String>){
        filteredSkill = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = ItemSkillListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredSkill.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(filteredSkill[position])
    }
}