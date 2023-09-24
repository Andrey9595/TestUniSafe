package ru.anb.testunisafe.fiatures.shoppinglist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.anb.testunisafe.databinding.FragmentShopingListBinding
import ru.anb.testunisafe.fiatures.list.ui.ListFragment
import ru.anb.testunisafe.fiatures.shoppinglist.domain.LoadStateShoppingList
import kotlin.properties.Delegates


@AndroidEntryPoint
class ShoppingListFragment : Fragment(), ShoppingListInteraction {


    private var _binding: FragmentShopingListBinding? = null
    private val binding get() = _binding!!

    private var listId by Delegates.notNull<Int>()

    private val viewModel: ShoppingListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShopingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { listId = it.getInt(ListFragment.LIST_ID_KEY) }

        viewModel.getShoppingList(listId)
        binding.addSoppingList.setOnClickListener {
            val name = binding.addNAmeShoppingList.text.toString()
            val count = binding.addCount.text.toString()
            if (name.isBlank() && count.isBlank())
                Toast.makeText(
                    requireContext(),
                    "Name and count should be not empty",
                    Toast.LENGTH_SHORT
                )
                    .show()
            else {
                viewModel.addToShoppingList(listId, name.trim(), count.trim())
                binding.addNAmeShoppingList.text = null
                binding.addCount.text = null
            }
        }

        val adapter = ShoppingListAdapter(this)
        binding.recyclerViewShoppingList.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.shoppingListState.collect() {
                    when (it) {
                        is LoadStateShoppingList.GetShoppingList -> adapter.updateShoppingList(it.data.itemList)
                        is LoadStateShoppingList.ToShoppingList -> viewModel.getShoppingList(listId)
                        is LoadStateShoppingList.CrossItOff -> viewModel.getShoppingList(listId)
                        is LoadStateShoppingList.Error -> Toast.makeText(
                            requireContext(),
                            it.error,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    override fun crossItOff(itemId: Int) {
        viewModel.crossItOff(listId, itemId)
    }
}