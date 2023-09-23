package ru.anb.testunisafe.fiatures.list.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.testunisafe.R
import ru.anb.testunisafe.databinding.ItemListBinding
import ru.anb.testunisafe.fiatures.list.data.model.ShopList

class ListAdapter(private val listInteraction: ListInteraction) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shopList: ShopList) {
            binding.name.text = shopList.name
            binding.created.text =
                binding.root.context.getString(R.string.created, shopList.created)
            binding.remove.setOnClickListener {
                listInteraction.remove(shopList.id)
            }
            binding.root.setOnClickListener {
                listInteraction.toSingleList(shopList.id)
            }
        }
    }

    private var shoppingList: List<ShopList> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun getItemCount() = shoppingList.size


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(shopList: List<ShopList>) {
        shoppingList = shopList
        notifyDataSetChanged()
    }
}