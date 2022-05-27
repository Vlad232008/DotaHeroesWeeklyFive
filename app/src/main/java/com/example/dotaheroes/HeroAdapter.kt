package com.example.dotaheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dotaheroes.databinding.HeroListBinding
import com.example.dotaheroes.json.HeroInfo

class HeroAdapter(private val listener: Listener, private val names: List<HeroInfo>) :
    ListAdapter<HeroInfo,HeroAdapter.MyViewHolder>(ItemComparator()) {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = HeroListBinding.bind(itemView)
        fun setData(names: HeroInfo, listener: Listener) = with(binding) {
            val base_URl = "https://api.opendota.com${names.icon}"
            tvName.text = names.localized_name
            ivIcon.load(base_URl)
            btnHero.setOnClickListener {
                listener.onClickItem(position)
            }
        }
        companion object {
            fun create(parent: ViewGroup): MyViewHolder {
                return MyViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.hero_list, parent, false)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    class ItemComparator : DiffUtil.ItemCallback<HeroInfo>() {
        override fun areItemsTheSame(oldItem: HeroInfo, newItem: HeroInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HeroInfo, newItem: HeroInfo): Boolean {
            return oldItem == newItem
        }
    }
    override fun getItemCount(): Int {
        return names.size
    }
    interface Listener{
        fun onClickItem(id:Int)
    }
}