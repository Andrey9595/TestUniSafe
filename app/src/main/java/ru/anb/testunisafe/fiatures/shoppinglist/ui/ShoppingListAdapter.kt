package ru.anb.testunisafe.fiatures.shoppinglist.ui

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.testunisafe.R
import ru.anb.testunisafe.databinding.ShoppingListBinding
import ru.anb.testunisafe.fiatures.shoppinglist.data.model.ShopListItem

class ShoppingListAdapter(private val shoppingListInteraction: ShoppingListInteraction) :
    RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {

    inner class ShoppingListViewHolder(private val binding: ShoppingListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shopListItem: ShopListItem) {
            if (shopListItem.isCrossed){
                binding.nameListShopping.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            binding.nameListShopping.text = shopListItem.name
            binding.count.text =
                binding.root.context.getString(R.string.count, shopListItem.created)
            binding.remove.setOnClickListener {
                shoppingListInteraction.crossItOff(shopListItem.id)
            }
        }
    }

    private var shoppingList: List<ShopListItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        return ShoppingListViewHolder(
            ShoppingListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = shoppingList.size


    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        val item = shoppingList[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateShoppingList(list: List<ShopListItem>) {
        shoppingList = list
        notifyDataSetChanged()
    }
}